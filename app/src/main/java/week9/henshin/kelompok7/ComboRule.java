package week9.henshin.kelompok7;

public class ComboRule {

    private String name, head, arms, legs;

    public ComboRule(String name, String head, String arms, String legs) {
        this.name = name;
        this.head = head;
        this.arms = arms;
        this.legs = legs;
    }

    public boolean match(CoreMedal h, CoreMedal a, CoreMedal l) {
        return h.getName().equalsIgnoreCase(head)
            && a.getName().equalsIgnoreCase(arms)
            && l.getName().equalsIgnoreCase(legs);
    }

    public String getName() {
        return name;
    }
}