package week9.henshin.kelompok7;

public class OOODriver {

    private CoreMedal head, arms, legs;
    private boolean beltTilted = false;

    public void insert(CoreMedal medal) throws Exception {
        switch (medal.getSlot()) {
            case HEAD:
                if (head != null) throw new Exception("HEAD sudah terisi!");
                head = medal;
                break;
            case ARMS:
                if (arms != null) throw new Exception("ARMS sudah terisi!");
                arms = medal;
                break;
            case LEGS:
                if (legs != null) throw new Exception("LEGS sudah terisi!");
                legs = medal;
                break;
        }
    }
    
    public void tiltBelt() {
        if (beltTilted == false) {
            beltTilted = true;
            System.out.println("Belt di tilt!");
        } else {
            beltTilted = false;
            System.out.println("Belt di tilt ke posisi semula!");
        }
    }

    public boolean isBeltTilted() {
        return beltTilted;
    }

    public boolean isComplete() {
        return head != null && arms != null && legs != null;
    }

    public void reset(int choice) {
        switch (choice) {
            case 1:
                head = null;
                System.out.println("HEAD dilepas!");
                break;
            case 2:
                arms = null;
                System.out.println("ARMS dilepas!");
                break;
            case 3:
                legs = null;
                System.out.println("LEGS dilepas!");
                break;
            case 4:
                head = arms = legs = null;
                System.out.println("Semua Medal dilepas!");
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }

    public CoreMedal getHead() { return head; }
    public CoreMedal getArms() { return arms; }
    public CoreMedal getLegs() { return legs; }

    public void displayStatus() {
        System.out.println("\n=== BELT STATUS ===");
        System.out.println("HEAD: " + (head != null ? head.getName() : "-"));
        System.out.println("ARMS: " + (arms != null ? arms.getName() : "-"));
        System.out.println("LEGS: " + (legs != null ? legs.getName() : "-"));
    }
}