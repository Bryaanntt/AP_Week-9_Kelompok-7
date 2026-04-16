package week9.henshin.kelompok7;

public class TransformationResult {

    public enum Status {
        COMBO,
        MIXED,
        CHARGE
    }

    private Status status;
    private String comboName;

    public TransformationResult(Status status, String comboName) {
        this.status = status;
        this.comboName = comboName;
    }

    @Override
    public String toString() {
        switch (status) {
            case COMBO:
                return "Combo: " + comboName;
            case MIXED:
                return "Mixed Form";
            case CHARGE:
                return "Scanning Charge!";
            default:
                return "";
        }
    }
}