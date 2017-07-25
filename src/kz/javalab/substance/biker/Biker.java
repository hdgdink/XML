package substance.biker;

import substance.equipment.Equip;

import java.util.ArrayList;
import java.util.List;

public class Biker {
    private static final String BIKER = "Biker ";
    private static final String NAME = "Name = '";
    private static final String EQIUPS = "\n List of equips:\n";
    private static final String SIGN = "\'";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Biker)) return false;

        Biker biker = (Biker) o;

        if (!getName().equals(biker.getName())) return false;
        return equips.equals(biker.equips);
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + equips.hashCode();
        return result;
    }
}
