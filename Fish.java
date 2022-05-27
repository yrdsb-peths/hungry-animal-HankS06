import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * food for crocodile
 * 
 * @author Hank 
 * @version May 24
 */
public class Fish extends Actor
{
    
    int speed = 1;
    GreenfootSound fail = new GreenfootSound("epicfail.mp3");
    public void act()
    {
        setLocation(getX(),getY()+speed);
        
        //Remove fish and draw game over when fish gets to the bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY()>=world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
            fail.play();
        }
    }
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
