import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien extends Actor
{
    /**
     * Act - do whatever the Alien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // Controls the speed of Alien
    private int speed;
    
    public Alien(int speed) {
        this.speed = speed;
    }
    
    public void act()
    {
        setLocation(getX(), getY() + speed);
        
        if (isTouching(Rocket.class)) {
            Logger.info("Rocket crashed into Alien");
            gameOver();
        }
    }
    
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
