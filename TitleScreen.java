import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The initial world that players see, they can start game here
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
     * Contains all player instructions
     */
    private void prepare() {
        Label welcomeLabel = new Label("Welcome to\nAliens Hunting", 50);
        addObject(welcomeLabel, 200, 100);
        Label instructionLabel = new Label("Press <enter> to start", 30);
        addObject(instructionLabel, 200, 200);
        Label turnLeftLabel = new Label("Instructions\nPress <d> or <\u2192> to move\nrocket to right", 30);
        addObject(turnLeftLabel, 200, 300);
        Label turnRightLabel = new Label("Press <a> or <\u2190> to move\nrocket to left", 30);
        addObject(turnRightLabel, 200, 400);
        Label shootLabel = new Label("Press <space> to shoot", 30);
        addObject(shootLabel, 200, 500);
    }
}
