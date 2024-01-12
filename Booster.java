import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Booster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Booster extends Actor
{
    // Game Frames Initialization
    GreenfootImage[] idle = new GreenfootImage[14];
    // Game Frame Index
    int imageIndex = 0;
    // Animation Timer
    SimpleTimer animationTimer = new SimpleTimer();
    
    int speed = 2;
    
    public Booster(int speed) {
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
    
    public void act()
    {
        // Set Location
        setLocation(getX(), getY()+speed);
        
        // Animate Booster
        animateBooster();
    }
    
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
