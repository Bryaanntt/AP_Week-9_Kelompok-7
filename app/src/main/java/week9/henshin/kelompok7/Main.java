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

                System.out.println("\n=== AVAILABLE MEDALS ===");
                printMedals(repo.getAll());

                belt.displayStatus();

                System.out.println("\n=== MENU ===");
                System.out.println("1. Insert Medal");
                System.out.println("2. Tilt Belt");
                System.out.println("3. Scan");
                System.out.println("4. Remove Medal");
                System.out.println("5. Exit");
                System.out.print("Choose: ");

                int c = input.nextInt();
                input.nextLine();

                switch (c) {

                    case 1:
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
                            System.out.println("Belt is not tilted!");
                            break;
                        }

                        System.out.println("\nScanning...");
                        Thread.sleep(500);
                        System.out.println(engine.scan(belt));
                        System.out.println("HENSHINNN!!!");
                        break;

                    case 4:
                        System.out.println("1. Remove HEAD");
                        System.out.println("2. Remove ARMS");
                        System.out.println("3. Remove LEGS");
                        System.out.println("4. Remove ALL");
                        System.out.print("Choose: ");
                        int r = input.nextInt();
                        belt.reset(r);
                        break;

                    case 5:
                        System.exit(0);
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // Chekker
    private static void insertMedals(Scanner input, MedalRepository<CoreMedal> repo, OOODriver belt) {
        
    try {
        
        // HEAD
        System.out.print("HEAD: ");
        String headInput = input.nextLine();
    
        CoreMedal h = find(repo.getAll(), headInput, CoreMedal.Slot.HEAD);
        if (h == null) {
            System.out.println("Wrong HEAD!");
            return;
        }
        belt.insert(h);

        // ARMS
        System.out.print("ARMS: ");
        String armsInput = input.nextLine();
    
        CoreMedal a = find(repo.getAll(), armsInput, CoreMedal.Slot.ARMS);
        if (a == null) {
            System.out.println("Wrong ARMS!");
            return;
        }
        belt.insert(a);

        // LEGS 
        System.out.print("LEGS: ");
        String legsInput = input.nextLine();
    
        CoreMedal l = find(repo.getAll(), legsInput, CoreMedal.Slot.LEGS);
        if (l == null) {
            System.out.println("Wrong LEGS!");
            return;
        }
        belt.insert(l);
    
        System.out.println("Semua medal berhasil dimasukkan!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static CoreMedal find(List<CoreMedal> list, String name, CoreMedal.Slot slot) {
        for (CoreMedal m : list) {
            if (m.getName().equalsIgnoreCase(name) && m.getSlot() == slot) {
                return m;
            }
        }
        return null;
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