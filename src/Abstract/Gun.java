package Abstract;

/**
 *
 * @author chathushamendis
 */
public abstract class Gun {
    private final String name;
    private int bullets;
    private final int maxCapacity;

    public Gun(String name, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.bullets = 0; // Initialize with zero bullets
    }

    // Abstract method to be implemented by subclasses
    public abstract void shoot();

    // Common methods
    public void reload(int bullets) {
        int bulletsToLoad = Math.min(bullets, maxCapacity - this.bullets);
        this.bullets += bulletsToLoad;
        System.out.println(name + " reloaded with " + bulletsToLoad + " bullets. Current bullets: " + this.bullets);
    }

    public boolean hasBullets() {
        return bullets > 0;
    }

    public void useBullet() {
        if (hasBullets()) {
            bullets--;
        }
    }

    public String getName() {
        return name;
    }
    
    public int getBullets() {
        return bullets;
    }
    
    public int getMaxCapacity() {
        return maxCapacity;
    }
}
