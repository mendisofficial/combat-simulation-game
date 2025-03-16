package Concrete;

import Abstract.Gun;

/**
 *
 * @author chathushamendis
 */
public class AK47 extends Gun {
    public AK47() {
        super("AK47", 30);
    }
    
    @Override
    public void shoot() {
        if (hasBullets()) {
            System.out.println("AK47 fires with a loud RATATATATA!");
            useBullet();
            System.out.println("AK47 bullets remaining: " + getBullets());
        } else {
            System.out.println("AK47 is out of bullets! Please reload.");
        }
    }
}
