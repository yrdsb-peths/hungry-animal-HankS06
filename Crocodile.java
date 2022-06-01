import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The crocodile.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crocodile extends Actor
{
    GreenfootSound crocodileSound = new GreenfootSound("minecrafteating.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[2];
    GreenfootImage[] idleLeft = new GreenfootImage[2];
    // Direction the crocodile is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Constructor - The code that gets run one time when object is created
     */
    public Crocodile()
    {
        idleRight[0] = new GreenfootImage("images/idle0.png");
        idleRight[0].scale(100,50);
        idleRight[1] = new GreenfootImage("images/idle1.png");
        idleRight[1].scale(100,50);
        idleLeft[0] = new GreenfootImage("images/idle0.png");
        idleLeft[0].mirrorHorizontally();
        idleLeft[0].scale(100,50);
        idleLeft[1] = new GreenfootImage("images/idle1.png");
        idleLeft[1].mirrorHorizontally();
        idleLeft[1].scale(100,50);
        animationTimer.mark();
        setImage(idleRight[0]);
    }
    /**
     * Animate the crocodile
     */
    int imageIndex = 0;
    public void animateCrocodile()
    {
        if(animationTimer.millisElapsed()<120)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(3);
            facing = "right";
        }
        //Remove fish if crocodile touches it
        eat();
        //Animate the crocodile
        animateCrocodile();
    }
    /**
     * Eat the fish and spawn new fish if the fish is eaten
     */
    public void eat()
    {
        if(isTouching(Fish.class))
        {
            removeTouching(Fish.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnFish();
            world.increaseScore();
            crocodileSound.play();
        }
    }
}
