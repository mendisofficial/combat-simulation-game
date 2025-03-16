package Concrete;

import Abstract.Gun;

/**
 *
 * @author chathushamendis
 */
public class Soldier {
    private final String name;
    private final Gun[] guns;
    private int activeGunIndex;
    private int gunsHeld;
    private final int MAX_GUNS = 3;

    public Soldier(String name) {
        this.name = name;
        this.guns = new Gun[MAX_GUNS];
        this.activeGunIndex = -1; // No active gun initially
        this.gunsHeld = 0;
    }

    // Add a gun to the soldier's inventory
    public void pickGun(Gun gun) {
        if (gunsHeld < MAX_GUNS) {
            for (int i = 0; i < MAX_GUNS; i++) {
                if (guns[i] == null) {
                    guns[i] = gun;
                    System.out.println(name + " picked up a " + gun.getName());
                    gunsHeld++;
                    
                    // If this is the first gun, make it active
                    if (activeGunIndex == -1) {
                        activeGunIndex = i;
                        System.out.println(name + " is now holding the " + getActiveGun().getName());
                    }
                    
                    return;
                }
            }
        } else {
            System.out.println(name + " cannot carry more guns! Maximum capacity reached.");
        }
    }

    // Drop the currently active gun
    public void dropActiveGun() {
        if (activeGunIndex != -1) {
            System.out.println(name + " dropped the " + guns[activeGunIndex].getName());
            guns[activeGunIndex] = null;
            gunsHeld--;
            
            // Find the next available gun
            if (gunsHeld > 0) {
                switchToNextAvailableGun();
            } else {
                activeGunIndex = -1;
                System.out.println(name + " has no guns left!");
            }
        } else {
            System.out.println(name + " has no gun to drop!");
        }
    }

    // Switch to a specific gun by index (0, 1, or 2)
    public void switchGun(int index) {
        if (index >= 0 && index < MAX_GUNS && guns[index] != null) {
            activeGunIndex = index;
            System.out.println(name + " switched to " + guns[activeGunIndex].getName());
        } else {
            System.out.println("Invalid gun selection or no gun in that slot!");
        }
    }

    // Switch to the next available gun
    public void switchToNextAvailableGun() {
        int startIndex = (activeGunIndex + 1) % MAX_GUNS;
        int currentIndex = startIndex;
        
        do {
            if (guns[currentIndex] != null) {
                activeGunIndex = currentIndex;
                System.out.println(name + " switched to " + guns[activeGunIndex].getName());
                return;
            }
            currentIndex = (currentIndex + 1) % MAX_GUNS;
        } while (currentIndex != startIndex);
        
        // If we get here, there are no guns available
        activeGunIndex = -1;
        System.out.println(name + " has no guns to switch to!");
    }

    // Make the soldier shoot with the active gun
    public void shoot() {
        if (activeGunIndex != -1 && guns[activeGunIndex] != null) {
            System.out.println(name + " fires the " + guns[activeGunIndex].getName() + ":");
            guns[activeGunIndex].shoot();
        } else {
            System.out.println(name + " has no gun to shoot with!");
        }
    }

    // Reload the active gun
    public void reload(int bullets) {
        if (activeGunIndex != -1 && guns[activeGunIndex] != null) {
            System.out.println(name + " reloads the " + guns[activeGunIndex].getName() + ":");
            guns[activeGunIndex].reload(bullets);
        } else {
            System.out.println(name + " has no gun to reload!");
        }
    }

    // Get the currently active gun
    public Gun getActiveGun() {
        if (activeGunIndex != -1) {
            return guns[activeGunIndex];
        }
        return null;
    }

    // Display the soldier's inventory
    public void displayInventory() {
        System.out.println("\n" + name + "'s Gun Inventory:");
        for (int i = 0; i < MAX_GUNS; i++) {
            if (guns[i] != null) {
                String activeMarker = (i == activeGunIndex) ? " (ACTIVE)" : "";
                System.out.println("Slot " + (i + 1) + ": " + guns[i].getName() + 
                                  " - Bullets: " + guns[i].getBullets() + "/" + 
                                  guns[i].getMaxCapacity() + activeMarker);
            } else {
                System.out.println("Slot " + (i + 1) + ": Empty");
            }
        }
        System.out.println();
    }
}
