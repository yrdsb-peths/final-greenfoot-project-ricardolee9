import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The object that Rocket shoots out
 */
public class Bullet extends Actor
{
    /**
     * Kills Alien when it touches one
     */
    public void act()
    {
        setLocation(getX(), getY() - 5);
        // Kill Alien
        if (isTouching(Alien.class)) {
            removeTouching(Alien.class);
            // Spawn New Alien and Booster
            MyWorld myWorld = (MyWorld) getWorld();
            myWorld.spawnAlien();
            myWorld.spawnBooster();
            myWorld.spawnExplosion(getX(), getY());
            myWorld.increaseScore();
            // Bullet gone
            getWorld().removeObject(this);
            Logger.info("Bullet hit Alien");
        } else if (isTouching(Booster.class)) {
            removeTouching(Booster.class);
            getWorld().removeObject(this);
            Logger.info("Bullet hit Booster");
        }
    }
}
