package substance.biker;

import substance.equipment.Equip;

import java.util.ArrayList;
import java.util.List;

public class Biker {
    final String BIKER = "Biker ";
    final String NAME = "Name = '";
    final String EQIUPS = "\n List of equips:\n";
    final String SIGN = "\'";
    private String name;

    private List<Equip> equips = new ArrayList<Equip>();

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public void addEquips(Equip equip) {
        equips.add(equip);
    }

    public List<Equip> getEquipList() {
        return equips;
    }

    @Override
    public String toString() {
        return BIKER + NAME + name + SIGN + EQIUPS + equips;
    }
}
