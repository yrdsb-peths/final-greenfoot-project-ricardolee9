import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{

    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 600, 1); 
        
        // End Game Text
        Label gameEndLabel = new Label("You lose!", 70);
        addObject(gameEndLabel, getWidth()/2, getHeight()/2-100);
        // Restart Game Text
        Label gameRestartLabel = new Label("Restart by pressing <R>", 30);
        addObject(gameRestartLabel, getWidth()/2, getHeight()/2+100);
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("R")) {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
