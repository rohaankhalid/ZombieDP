import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class ZombieDatabaseTest {

    private ZombieDatabase zombieDatabase;

    @Before
    public void setUp() {
        zombieDatabase = new ZombieDatabase();
        zombieDatabase.addZombie(new Zombie("Regular", "Headshot"));
        zombieDatabase.addZombie(new Zombie("Tank", "Explosives"));
        zombieDatabase.addZombie(new Zombie("Runner", "Trip"));
    }

    @Test
    public void testGetWeakness() {
        assertEquals("Headshot", zombieDatabase.getWeakness("Regular"));
        assertEquals("Explosives", zombieDatabase.getWeakness("Tank"));
        assertEquals("Trip", zombieDatabase.getWeakness("Runner"));
    }

    @Test
    public void testGetWeaknessUnknown() {
        assertEquals("Unknown", zombieDatabase.getWeakness("Unknown"));
    }

    @Test
    public void testAddZombie() {
        zombieDatabase.addZombie(new Zombie("Crawler", "Fire"));
        assertEquals("Fire", zombieDatabase.getWeakness("Crawler"));
    }

    @Test
    public void testUpdateWeakness() {
        zombieDatabase.updateWeakness("Regular", "Decapitation");
        assertEquals("Decapitation", zombieDatabase.getWeakness("Regular"));
    }

    @Test
    public void testUpdateWeaknessNonExistent() {
        assertThrows(IllegalArgumentException.class, () -> {
            zombieDatabase.updateWeakness("NonExistent", "Weakness");
        });
    }

    @Test
    public void testRemoveZombie() {
        zombieDatabase.removeZombie("Regular");
        assertEquals("Unknown", zombieDatabase.getWeakness("Regular"));
    }

    @Test
    public void testRemoveZombieNonExistent() {
        zombieDatabase.removeZombie("NonExistent");
    }

    @Test
    public void testAddZombieInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            zombieDatabase.addZombie(new Zombie("", "Weakness"));
        });
        assertThrows(IllegalArgumentException.class, () -> {
            zombieDatabase.addZombie(new Zombie("Type", ""));
        });
    }
}
