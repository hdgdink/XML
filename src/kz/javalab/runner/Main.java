package runner;

/**
 Определить иерархию амуниции. Экипировать мотоцикли-
 ста. Подсчитать стоимость. Провести сортировку амуниции на основе веса.
 Найти элементы амуниции, соответствующие заданному диапазону пара-
 метров цены.
 */

import creator.EquipsCreator;
import logic.Operation;
import parse.SAXParser;
import parse.Validation;
import substance.biker.Biker;
import substance.equipment.Equip;

import java.io.IOException;
import java.util.List;

public class Main {
    final static   String NAME = "Name of biker: ";
    final static String FULL_PRISE = "Full prise of equipment list: ";
    final static String FILTERED_BY_GAP = "Filtered equipment list by prise gap:";
    final static String SORTED_LIST_BY_WEIGHT = "Get sorted list of equipments by weight: ";

    public static void main(String[] args) throws IOException {

        double sum = 0;
/*
        EquipsCreator list = new EquipsCreator();
        Biker biker = list.creatEquip();
        System.out.println(NAME + biker.getName());
        List<Equip> equipList = biker.getEquipList();

        for (int i = 0; i < equipList.size(); i++) {
            System.out.println(equipList.get(i));
            sum += equipList.get(i).getPrice();
        }

        System.out.println();
        System.out.println(FULL_PRISE + sum);
        System.out.println();
        System.out.println(FILTERED_BY_GAP);
        Operation.getEquipsByPriceGap(biker, 30, 160);
        System.out.println();
        System.out.println(SORTED_LIST_BY_WEIGHT);
        Operation.sortAmmunitionByWeight(equipList);*/

        Validation validator = new Validation();
         Boolean result = validator.validate("src\\kz\\javalab\\src\\Biker.xml","src\\kz\\javalab\\src\\Biker.xsd");
        System.out.println(result);

        SAXParser parser = new SAXParser();
        parser.parse("src\\kz\\javalab\\src\\Biker.xml");



    }
}
