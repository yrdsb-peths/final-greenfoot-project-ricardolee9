import greenfoot.*; 

/**
 * EndScreen class is the class that constructs the Game Over Screen
 * for player to quit or restart the game
 */
public class EndScreen extends World
{

    /**
     * Constructor for objects of class EndScreen.
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
    
    /**
     * Prepare to restart a game
     */
    public void act() {
        // Restart Game
        if (Greenfoot.isKeyDown("R")) {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
