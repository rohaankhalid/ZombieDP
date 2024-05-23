import java.util.HashMap;
import java.util.Map;

public class ZombieDatabase {
    private Map<String, Zombie> zombieMap;

    public ZombieDatabase() {
        this.zombieMap = new HashMap<>();
    }

    public void addZombie(Zombie zombie) {
        if (zombie == null) {
            throw new IllegalArgumentException("Zombie cannot be null.");
        }
        zombieMap.put(zombie.getType(), zombie);
    }

    public String getWeakness(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Zombie type cannot be null or empty.");
        }
        Zombie zombie = zombieMap.get(type);
        return (zombie != null) ? zombie.getWeakness() : "Unknown";
    }

    public void updateWeakness(String type, String newWeakness) {
        if (type == null || type.isEmpty() || newWeakness == null || newWeakness.isEmpty()) {
            throw new IllegalArgumentException("Zombie type and new weakness cannot be null or empty.");
        }
        Zombie zombie = zombieMap.get(type);
        if (zombie == null) {
            throw new IllegalArgumentException("Zombie type not found: " + type);
        }
        zombie.setWeakness(newWeakness);
    }

    public void removeZombie(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Zombie type cannot be null or empty.");
        }
        zombieMap.remove(type);
    }

    public Map<String, Zombie> getAllZombies() {
        return new HashMap<>(zombieMap);
    }

    @Override
    public String toString() {
        return zombieMap.toString();
    }

    public static void main(String[] args) {
        ZombieDatabase zombieDatabase = new ZombieDatabase();
        zombieDatabase.addZombie(new Zombie("Regular", "Headshot"));
        zombieDatabase.addZombie(new Zombie("Tank", "Explosives"));
        zombieDatabase.addZombie(new Zombie("Runner", "Trip"));

        System.out.println("Weakness of Regular: " + zombieDatabase.getWeakness("Regular"));
        System.out.println("Weakness of Tank: " + zombieDatabase.getWeakness("Tank"));
        System.out.println("Weakness of Runner: " + zombieDatabase.getWeakness("Runner"));
        System.out.println("Weakness of Unknown: " + zombieDatabase.getWeakness("Unknown"));
    }
}