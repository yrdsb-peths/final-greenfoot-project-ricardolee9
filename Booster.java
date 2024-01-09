import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Booster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Booster extends Actor
{
    int speed = 2;
    
    public Booster(int speed) {
        this.speed = speed;
    }
    
    public void act()
    {
        setLocation(getX(), getY()+speed);
    }
}
