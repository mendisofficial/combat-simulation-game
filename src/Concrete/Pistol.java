package Concrete;

import Abstract.Gun;

/**
 *
 * @author chathushamendis
 */
public class Pistol extends Gun {
    public Pistol() {
        super("Pistol", 15);
    }

    @Override
    public void shoot() {
        if (hasBullets()) {
            System.out.println("Pistol fires with a POP!");
            useBullet();
            System.out.println("Pistol bullets remaining: " + getBullets());
        } else {
            System.out.println("Pistol is out of bullets! Please reload.");
        }
    }
}
