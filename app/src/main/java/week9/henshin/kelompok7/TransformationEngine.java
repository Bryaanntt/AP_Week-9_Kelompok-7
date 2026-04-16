package week9.henshin.kelompok7;

public class TransformationEngine {

    private ComboCatalogue catalogue;
    private OScanner scanner = new OScanner();
    private boolean lastWasCombo = false;

    public TransformationEngine(ComboCatalogue catalogue) {
        this.catalogue = catalogue;
    }

    public TransformationResult scan(OOODriver d) throws Exception {

        if (!d.isComplete()) {
            throw new Exception("Slot belum lengkap!");
        }

        String current = d.getHead().getName()
                + d.getArms().getName()
                + d.getLegs().getName();

        // Scanner Charge
        if (scanner.isSameScan(current)) {
            if (lastWasCombo) {
                return new TransformationResult(
                        TransformationResult.Status.CHARGE, null);
            } else {
                return new TransformationResult(
                        TransformationResult.Status.MIXED, null);
            }
        }

        scanner.updateScan(current);

        // Cek combo
        for (ComboRule c : catalogue.getCombos()) {
            if (c.match(d.getHead(), d.getArms(), d.getLegs())) {
                lastWasCombo = true;
                return new TransformationResult(
                        TransformationResult.Status.COMBO,
                        c.getName());
            }
        }

        lastWasCombo = false;
        return new TransformationResult(
                TransformationResult.Status.MIXED, null);
    }
}