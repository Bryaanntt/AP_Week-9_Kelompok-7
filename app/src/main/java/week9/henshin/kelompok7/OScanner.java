package week9.henshin.kelompok7;

public class OScanner {

    private String lastScan = "";

    public boolean isSameScan(String current) {
        return current.equals(lastScan);
    }

    public void updateScan(String current) {
        lastScan = current;
    }
}