package Concrete;

import Abstract.Gun;

/**
 *
 * @author chathushamendis
 */
public class Sniper extends Gun {
     public Sniper() {
        super("Sniper", 5);
    }

    @Override
    public void shoot() {
        if (hasBullets()) {
            System.out.println("Sniper fires with a precise BOOM!");
            useBullet();
            System.out.println("Sniper bullets remaining: " + getBullets());
        } else {
            System.out.println("Sniper is out of bullets! Please reload.");
        }
    }
}
