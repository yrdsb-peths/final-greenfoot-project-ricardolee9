import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    // Explosion Frames
    GreenfootImage[] idle = new GreenfootImage[28];
    // Frames Image Index
    int imageIndex = 0;
    // Timer
    SimpleTimer animationTimer = new SimpleTimer();
    
    public Explosion() {
        for (int i = 0; i < idle.length; i++) {
            idle[i] = new GreenfootImage("images/explosion_tile/" + "tile" + i + ".png");
            idle[i].scale(100, 100);
        }
        // Mark Animation Timer
        animationTimer.mark();
        // Set Rocket Image
        setImage(idle[0]);
    }
    
    public void act() {
        animateExplosion();
        if (imageIndex >= 27) {
            getWorld().removeObject(this);
        }
    }
    
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
