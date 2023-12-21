import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 600, 1);
        // Labels initialization
        prepare();
    }

    /**
     * Loop Game World Act
     */
    public void act() {
        // Start game when enter is pressed
        if (Greenfoot.isKeyDown("enter")) {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare() {
        Label welcomeLabel = new Label("Welcome to\nAliens Hunting", 50);
        addObject(welcomeLabel, 200, 100);
        Label instructionLabel = new Label("Press <enter> to start", 40);
        addObject(instructionLabel, 200, 300);
    }
}
