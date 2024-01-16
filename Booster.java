import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Boost the Rocket's speed
 */
public class Booster extends Actor
{
    // Game Frames Initialization
    GreenfootImage[] idle = new GreenfootImage[14];
    // Game Frame Index
    int imageIndex = 0;
    // Animation Timer
    SimpleTimer animationTimer = new SimpleTimer();
    // Initialize speed
    private int speed;
    
    /**
     * Constructor of the class, set animation image and speed
     */
    public Booster(int speed) {
        // Initialize Animation image 
        for (int i = 0; i < idle.length; i++) {
            idle[i] = new GreenfootImage("images/mario_tile/tile0" + i + ".png");
            idle[i].scale(50, 50);
        }
        // Mark Animation Timer
        animationTimer.mark();
        // Set Rocket Image
        setImage(idle[0]);
        // Set the speed of the object
        this.speed = speed;
    }
    
    /**
     * Make the Booster goes downwards
     */
    public void act()
    {
        // Set Location
        setLocation(getX(), getY()+speed);
        // Animate Booster
        animateBooster();
    }
    
    /**
     * Set animation image every 100 ms
     */
    private void animateBooster() {
        // Change frame every 100 ms
        if (animationTimer.millisElapsed() < 100) {
            return;
        }
        // Reset Timer
        animationTimer.mark();
        // Set animation image to next frame
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
}
