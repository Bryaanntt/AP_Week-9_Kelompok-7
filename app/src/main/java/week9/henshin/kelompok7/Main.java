package week9.henshin.kelompok7;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        MedalRepository<CoreMedal> repo = new MedalRepository<>();

        // HEAD
        repo.add(new CoreMedal("Taka", CoreMedal.Slot.HEAD));
        repo.add(new CoreMedal("Kuwagata", CoreMedal.Slot.HEAD));
        repo.add(new CoreMedal("Lion", CoreMedal.Slot.HEAD));
        repo.add(new CoreMedal("Sai", CoreMedal.Slot.HEAD));
        repo.add(new CoreMedal("Shachi", CoreMedal.Slot.HEAD));
        repo.add(new CoreMedal("Ptera", CoreMedal.Slot.HEAD));
        repo.add(new CoreMedal("Cobra", CoreMedal.Slot.HEAD));

        // ARMS
        repo.add(new CoreMedal("Tora", CoreMedal.Slot.ARMS));
        repo.add(new CoreMedal("Kamakiri", CoreMedal.Slot.ARMS));
        repo.add(new CoreMedal("Gorilla", CoreMedal.Slot.ARMS));
        repo.add(new CoreMedal("Unagi", CoreMedal.Slot.ARMS));
        repo.add(new CoreMedal("Kujaku", CoreMedal.Slot.ARMS));
        repo.add(new CoreMedal("Tricera", CoreMedal.Slot.ARMS));
        repo.add(new CoreMedal("Kame", CoreMedal.Slot.ARMS));

        // LEGS
        repo.add(new CoreMedal("Batta", CoreMedal.Slot.LEGS));
        repo.add(new CoreMedal("Cheetah", CoreMedal.Slot.LEGS));
        repo.add(new CoreMedal("Zou", CoreMedal.Slot.LEGS));
        repo.add(new CoreMedal("Tako", CoreMedal.Slot.LEGS));
        repo.add(new CoreMedal("Condor", CoreMedal.Slot.LEGS));
        repo.add(new CoreMedal("Tyranno", CoreMedal.Slot.LEGS));
        repo.add(new CoreMedal("Wani", CoreMedal.Slot.LEGS));

        OOODriver belt = new OOODriver();
        ComboCatalogue catalogue = new ComboCatalogue();
        TransformationEngine engine = new TransformationEngine(catalogue);
        while (true) {
            try {

                System.out.println("\n=== MEDAL YANG TERSEDIA ===");
                printMedals(repo.getAll());

                belt.displayStatus();

                System.out.println("\n=== MENU ===");
                System.out.println("1. Masukkan Medal");
                System.out.println("2. Tilt Belt");
                System.out.println("3. Scan");
                System.out.println("4. Keluarkan Medal");
                System.out.println("5. Keluar");
                System.out.print("Pilihan: ");

                int c = input.nextInt();
                input.nextLine();

                switch (c) {

                    case 1:
                        if (belt.isBeltTilted()) {
                            System.out.println("Tidak dapat memasukkan medal saat belt sedang di tilt!");
                            break;
                        }
                        System.out.print("Masukkan nama medal: ");
                        String inputName = input.nextLine();

                        CoreMedal found = null;

                        for (CoreMedal m : repo.getAll()) {
                            if (m.getName().equalsIgnoreCase(inputName)) {
                                found = m;
                                break;
                            }
                        }

                        if (found == null) {
                            System.out.println("Medal tidak ditemukan!");
                            break;
                        }
                        
                        belt.insert(found);
                        System.out.println("Medal berhasil dimasukkan ke slot " + found.getSlot());
                        break;
                        
                    case 2:
                        belt.tiltBelt();
                        break;
                        
                    case 3:
                        if (!belt.isBeltTilted()) {
                            System.out.println("Belt belum di tilt!");
                            break;
                        }

                        System.out.println("\nScanning...");
                        Thread.sleep(2000);
                        System.out.println(engine.scan(belt));
                        System.out.println("HENSHINNN!!!");
                        break;

                    case 4:
                        if (belt.isBeltTilted()) {
                            System.out.println("Tidak dapat mengeluarkan medal saat belt sedang di tilt!");
                            break;
                        }
                        System.out.println("1. Mengeluarkan HEAD");
                        System.out.println("2. Mengeluarkan ARMS");
                        System.out.println("3. Mengeluarkan LEGS");
                        System.out.println("4. Mengeluarkan ALL");
                        System.out.print("Pilihan: ");
                        int r = input.nextInt();
                        input.nextLine();
                        if (belt.getHead() == null && r == 1 || belt.getArms() == null && r == 2 || belt.getLegs() == null && r == 3) {
                            System.out.println("Slot sudah kosong!");
                            break;
                        }
                        belt.reset(r);
                        break;
                    case 5:
                        input.close();
                        System.out.println("\nMematikan program...");
                        Thread.sleep(2000);
                        System.exit(0);
                    default:
                        System.out.println("Pilihan tidak valid!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.exit(0);
            }
        } 
    }
    private static void printMedals(List<CoreMedal> list) {

        System.out.println("\nHEAD:");
        for (CoreMedal m : list) {
            if (m.getSlot() == CoreMedal.Slot.HEAD) {
                System.out.println("- " + m.getName());
            }
        }
        System.out.println("\nARMS:");
        for (CoreMedal m : list) {
            if (m.getSlot() == CoreMedal.Slot.ARMS) {
                System.out.println("- " + m.getName());
            }
        }
        System.out.println("\nLEGS:");
        for (CoreMedal m : list){
            if (m.getSlot() == CoreMedal.Slot.LEGS){
                System.out.println("- " + m.getName());
            }
        }
    }
}