import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    // Score
    private int score = 0;
    private Label scoreLabel;
    private int level = 0;
    private int speed = 1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 400x600 cells with a cell size of 1x1 pixels.
        super(400, 600, 1, false);
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        // Create the Rocket
        Rocket rocket = new Rocket();
        addObject(rocket, getWidth()/2, 500);
        rocket.turn(-90);
        // Spawn Aliens
        spawnAlien();
        // Score Label
        scoreLabel = new Label(0, 70);
        addObject(scoreLabel, 50, 50);
    }
    
    // Increases the Score
    public void increaseScore() {
        score += 1;
        if (score % 5 == 0) {
            level += 1;
            speed += 1;
        }
        scoreLabel.setValue(score);
    }
    
    public void spawnAlien() {
        Alien alien = new Alien(speed);
        addObject(alien, Greenfoot.getRandomNumber(400), 0);
    }
}
