package week9.henshin.kelompok7;

public class CoreMedal {

    public enum Slot {
        HEAD, ARMS, LEGS
    }

    private String name;
    private Slot slot;

    public CoreMedal(String name, Slot slot) {
        this.name = name;
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public Slot getSlot() {
        return slot;
    }

    @Override
    public String toString() {
        return name + " (" + slot + ")";
    }
}