import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main game world where players play their games
 */
public class MyWorld extends World
{
    // Score
    private int score = 0;
    // Label for score
    private Label scoreLabel;
    // Level
    private int level = 0;
    // Alien & Booster speed
    private int speed = 1;
    /**
     * Constructor for objects of class MyWorld.
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
        // Spawn Booster
        spawnBooster();
        // Score Label
        scoreLabel = new Label(0, 70);
        addObject(scoreLabel, 50, 50);
    }
    
    /**
     * Increase player's score
     */
    public void increaseScore() {
        // Increase Score
        score += 1;
        // Increase Level
        if (score % 5 == 0) {
            level += 1;
            speed += 1;
        }
        // Set Label value
        scoreLabel.setValue(score);
    }
    
    /**
     * Create a new alien
     */
    public void spawnAlien() {
        Alien alien = new Alien(speed);
        addObject(alien, Greenfoot.getRandomNumber(400), 0);
    }
    
    /**
     * Create a new booster
     */
    public void spawnBooster() {
        Booster booster = new Booster(speed);
        addObject(booster, Greenfoot.getRandomNumber(400), 0);
    }
    
    /**
     * Create explosion object
     */
    public void spawnExplosion(int x, int y) {
        Explosion explosion = new Explosion();
        addObject(explosion, x, y);
    }
}
