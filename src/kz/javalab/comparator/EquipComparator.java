package comparator;

import substance.equipment.Equip;

import java.util.Comparator;

public class EquipComparator implements Comparator<Equip> {

    public int compare(Equip o1, Equip o2) {
        double mWeight1 = o1.getWeight();
        double mWeight2 = o2.getWeight();
        if(mWeight1 < mWeight2){
            return -1;
        }else if (mWeight1 == mWeight2){
            return 0;
        }else{
            return 1;
        }    }
}
