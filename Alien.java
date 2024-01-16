import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Enemy of Rocket
 */
public class Alien extends Actor
{
    /**
     * Act - do whatever the Alien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // Controls the speed of Alien
    private int speed;
    
    /**
     * Constructor of the class, sets the speed of the Alien
     */
    public Alien(int speed) {
        // Set speed
        this.speed = speed;
    }
    
    /**
     * Moves the alien closer to the Rocket
     */
    public void act()
    {
        // Move Alien downwards
        setLocation(getX(), getY() + speed);
        
        // Crash into Rocket and game over
        if (isTouching(Rocket.class)) {
            Logger.info("Rocket crashed into Alien");
            gameOver();
        }
        
        // Rocket failed to kill it, game over
        if (getY() >= 600) {
            Logger.info("Alien reached the end of the world");
            gameOver();
        }
    }
    
    /**
     * Game Over method, sets to the end screen world
     */
    private void gameOver() {
        // Make it stop
        speed = 0;
        // Remove the Rocket
        removeTouching(Rocket.class);
        // Set End Screen
        EndScreen endScreen = new EndScreen();
        Greenfoot.setWorld(endScreen);
    }
}
