package substance.biker;

import substance.equipment.Equip;

import java.util.ArrayList;
import java.util.List;

public class Biker {
    final String BIKER = "Biker{";
    final String NAME = "mName='";
    final String EQIUPS = ", equips=";
    private String name;

    private List<Equip> equips = new ArrayList<Equip>();

    public String getName() {
        return name;
    }

    public void setName(String mName) {
        this.name = mName;
    }

    public void addEquips(Equip equip) {
        equips.add(equip);
    }

    public List<Equip> getEquipList() {
        return equips;
    }

    @Override
    public String toString() {
        return BIKER +
                NAME + name + '\'' +
                EQIUPS + equips +
                '}';
    }
}
