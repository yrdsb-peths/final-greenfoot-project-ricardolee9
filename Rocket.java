import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // Game Frames Initialization
    GreenfootImage[] idle = new GreenfootImage[8];
    // Frames Image Index
    int imageIndex = 0;
    // Timer
    SimpleTimer animationTimer = new SimpleTimer();
    // Can fire
    boolean fireAble = true;
    
    /**
     * Constructor for the Rocket class
     */
    
    public Rocket() {
        // Animation
        for (int i = 0; i < idle.length; i++) {
            idle[i] = new GreenfootImage("images/tile/tile00" + i + ".png");
            idle[i].scale(100, 100);
        }
        // Mark Animation Timer
        animationTimer.mark();
        // Set Rocket Image
        setImage(idle[0]);
    }
    
    /**
     * Rocket animation
     */
    private void animateRocket() {
        // Change a frame every 100 ms
        if (animationTimer.millisElapsed() < 100) {
            return;
        }
        // Reset Timer
        animationTimer.mark();
        // Set animation image to next frame
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    
    /**
     * Sets the behaviour of the rocket
     */
    
    public void act()
    {
        // Moves left
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) {
            moveLeft();
        }
        // Moves right
        if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) {
            moveRight();
        }
        // Shoots a bullet
        shoot();
        // Animate Rocket
        animateRocket();
    }
    /**
     * The method that shoots a bullet
     */
    private void shoot() {
        if (fireAble && Greenfoot.isKeyDown("space")) {
            Bullet bullet = new Bullet();
            getWorld().addObject(bullet, getX(), getY());
            fireAble = false;
        }
        if (!Greenfoot.isKeyDown("space")) {
            fireAble = true;
        }
    }
    /**
     * Method that moves the rocket to left
     */
    private void moveLeft() {
        setLocation(getX()-2, getY());
    }
    
    /**
     * Method that moves the rocket to right
     */
    private void moveRight() {
        setLocation(getX()+2, getY());
    }
}
