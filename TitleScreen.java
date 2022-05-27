import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author Hank 
 * @version May 2022
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("HUNGRY CROC",80);   
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(titleLabel,getWidth()/2,getHeight()/2);
        prepare();
    }

    /**
     * The main world act loop
     */
    public void act()
    {
        //Start the game if the user presses the space bar 
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Crocodile crocodile = new Crocodile();
        addObject(crocodile,409,100);
        Label label = new Label ("Use the \u2190 and \u2192 keys to move",40);
        Label label2 = new Label ("Press <space> to start",40);
        addObject(label,300,300);
        addObject(label2,300,350);
    }
}
