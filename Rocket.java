import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The object that the player controls
 */
public class Rocket extends Actor
{
    // Rocket Shooting Sound
    GreenfootSound sound = new GreenfootSound("sounds/shooting.mp3");
    // Game Frames Initialization
    GreenfootImage[] idle = new GreenfootImage[8];
    // Frames Image Index
    int imageIndex = 0;
    // Timer
    SimpleTimer animationTimer = new SimpleTimer();
    // Can fire
    boolean fireAble = true;
    // Rocket Speed
    int speed = 2;
    
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
        // Skip to GameOver World
        if (Greenfoot.isKeyDown("e")) {
            EndScreen endScreen = new EndScreen();
            Greenfoot.setWorld(endScreen);
        }
        // Shoots a bullet
        shoot();
        // Animate Rocket
        animateRocket();
        // Increase speed
        if (isTouching(Booster.class)) {
            speed += 2;
            removeTouching(Booster.class);
        }
    }
    
    /**
     * The method that shoots a bullet
     */
    private void shoot() {
        // Shoots a new bullet
        if (fireAble && Greenfoot.isKeyDown("space")) {
            Bullet bullet = new Bullet();
            getWorld().addObject(bullet, getX(), getY());
            sound.play();
            // Make sure it shoots one per press
            fireAble = false;
            Logger.info("Rocket fires a bullet");
        }
        // Allow user to shoot another one through another press
        if (!Greenfoot.isKeyDown("space")) {
            fireAble = true;
        }
    }
    
    /**
     * Method that moves the rocket to left
     */
    private void moveLeft() {
        // Logging info
        Logger.info(getX());
        // Move to left
        setLocation(getX()-speed, getY());
    }
    
    /**
     * Method that moves the rocket to right
     */
    private void moveRight() {
        // Logging Info
        Logger.info(getX());
        // Move to right
        setLocation(getX()+speed, getY());
    }
}
