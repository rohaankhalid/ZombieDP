public class Zombie {
    private String type;
    private String weakness;

    public Zombie(String type, String weakness) {
        if (type == null || type.isEmpty() || weakness == null || weakness.isEmpty()) {
            throw new IllegalArgumentException("Zombie type and weakness cannot be null or empty.");
        }
        this.type = type;
        this.weakness = weakness;
    }

    public String getType() {
        return type;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        if (weakness == null || weakness.isEmpty()) {
            throw new IllegalArgumentException("Weakness cannot be null or empty.");
        }
        this.weakness = weakness;
    }

    @Override
    public String toString() {
        return "Zombie{" +
                "type='" + type + '\'' +
                ", weakness='" + weakness + '\'' +
                '}';
    }
}