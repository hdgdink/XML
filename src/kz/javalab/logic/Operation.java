package logic;

import comparator.EquipComparator;
import substance.biker.Biker;
import substance.equipment.Equip;

import java.util.ArrayList;
import java.util.List;

public class Operation {
    private static final String FULL_PRISE = "Full prise of equipment list: ";

    public static List<Equip> getEquipsByPriceGap(Biker biker, double minPrice, double maxPrice) {
        List<Equip> filteredEquips = new ArrayList<Equip>();
        for (Equip equip : biker.getEquipList()) {
            if (equip.getPrice() <= maxPrice && equip.getPrice() >= minPrice) {
                filteredEquips.add(equip);
                System.out.println(equip);
            }
        }
        return filteredEquips;
    }

    public static List<Equip> sortAmmunitionByWeight(List<Equip> equipList) {
        double sum = 0;
        equipList.sort(new EquipComparator());
        for (int i = 0; i < equipList.size(); i++) {
            System.out.println(equipList.get(i));
            sum += equipList.get(i).getPrice();
        }
        System.out.println();
        System.out.println(FULL_PRISE + sum );
        return equipList;

    }
}


