import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Explosion effect when it shoots an Alien
 */
public class Explosion extends Actor
{
    // Explosion Frames
    GreenfootImage[] idle = new GreenfootImage[27];
    // Frames Image Index
    int imageIndex = 0;
    // Timer
    SimpleTimer animationTimer = new SimpleTimer();
    
    /**
     * Constructor for the explosion class
     */
    public Explosion() {
        // Initialize animation image
        for (int i = 0; i < idle.length; i++) {
            idle[i] = new GreenfootImage("images/explosion_tile/" + "tile" + i + ".png");
            idle[i].scale(100, 100);
        }
        // Mark Animation Timer
        animationTimer.mark();
        // Set Rocket Image
        setImage(idle[0]);
    }
    
    /**
     * Remove explosion effect after going through all frames
     */
    public void act() {
        // Animate Explosion
        animateExplosion();
        // Remove when gone through all frames
        if (imageIndex >= 26) {
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Change the frame of explosion every 100 ms
     */
    private void animateExplosion() {
        // Change a frame every 100 ms
        if (animationTimer.millisElapsed() < 50) {
            return;
        }
        // Reset Timer
        animationTimer.mark();
        // Set animation image to next frame
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
}
