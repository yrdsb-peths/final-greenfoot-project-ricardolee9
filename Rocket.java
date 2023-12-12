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
    public void act()
    {
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) {
            moveLeft();
        }
        if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) {
            moveRight();
        }
    }
    
    /**
     * Method that moves the rocket to left
     */
    private void moveLeft() {
        setLocation(getX()-1, getY());
    }
    
    /**
     * Method that moves the rocket to right
     */
    private void moveRight() {
        setLocation(getX()+1, getY());
    }
}
