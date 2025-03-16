package CombatSimulation;

import Concrete.AK47;
import Concrete.Pistol;
import Concrete.Sniper;
import Concrete.Soldier;

/**
 *
 * @author chathushamendis
 */
public class CombatSimulation {
    public static void main(String[] args) {
        // Create soldier
        Soldier soldier = new Soldier("John");
        
        // Create guns
        AK47 ak47 = new AK47();
        Pistol pistol = new Pistol();
        Sniper sniper = new Sniper();
        
        // Load guns with bullets
        ak47.reload(30);
        pistol.reload(15);
        sniper.reload(5);
        
        // Assign guns to soldier
        soldier.pickGun(ak47);
        soldier.pickGun(pistol);
        soldier.pickGun(sniper);
        
        // Display initial inventory
        soldier.displayInventory();
        
        // Simulate combat actions
        System.out.println("COMBAT SIMULATION BEGINS:\n");
        
        // Shoot with default gun (first one picked)
        soldier.shoot();
        
        // Switch to pistol and shoot
        soldier.switchGun(1);
        soldier.shoot();
        
        // Switch to sniper and shoot twice
        soldier.switchGun(2);
        soldier.shoot();
        soldier.shoot();
        
        // Display updated inventory
        soldier.displayInventory();
        
        // Test gun switching
        System.out.println("Testing gun switching functionality:");
        soldier.switchToNextAvailableGun();
        soldier.shoot();
        
        // Test dropping and picking guns
        System.out.println("\nTesting dropping and picking guns:");
        soldier.dropActiveGun();
        soldier.displayInventory();
        
        // Try to add too many guns
        AK47 anotherAK47 = new AK47();
        anotherAK47.reload(30);
        soldier.pickGun(anotherAK47);
        
        // Pick up the dropped gun
        soldier.pickGun(pistol);
        soldier.displayInventory();
        
        // Test empty gun behavior
        System.out.println("\nTesting empty gun behavior:");
        soldier.switchGun(2); // Switch to sniper
        soldier.shoot();
        soldier.shoot();
        soldier.shoot(); // Should be out of bullets now
        soldier.reload(3); // Reload with 3 bullets
        soldier.shoot();
        
        System.out.println("\nCOMBAT SIMULATION COMPLETE");
    }
}
