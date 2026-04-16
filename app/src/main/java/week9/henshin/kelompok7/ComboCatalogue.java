package week9.henshin.kelompok7;

import java.util.ArrayList;
import java.util.List;


public class ComboCatalogue {

    private List<ComboRule> combos = new ArrayList<>();

    public ComboCatalogue() {
        combos.add(new ComboRule("Tatoba","Taka","Tora","Batta"));
        combos.add(new ComboRule("Gatakiriba","Kuwagata","Kamakiri","Batta"));
        combos.add(new ComboRule("Latorartar","Lion","Tora","Cheetah"));
        combos.add(new ComboRule("Sagohzo","Sai","Gorilla","Zou"));
        combos.add(new ComboRule("Shauta","Shachi","Unagi","Tako"));
        combos.add(new ComboRule("Tajadol","Taka","Kujaku","Condor"));
        combos.add(new ComboRule("Putotyra","Ptera","Tricera","Tyranno"));
        combos.add(new ComboRule("Burakawani","Cobra","Kame","Wani"));
    }

    public List<ComboRule> getCombos() {
        return combos;
    }
}
