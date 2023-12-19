import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY() - 5);
        
        if (isTouching(Alien.class)) {
            removeTouching(Alien.class);
            MyWorld myWorld = (MyWorld) getWorld();
            myWorld.spawnAlien();
            myWorld.increaseScore();
            getWorld().removeObject(this);
        }
    }
}
