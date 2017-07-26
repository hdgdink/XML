package runner;

/**
 * Определить иерархию амуниции. Экипировать мотоцикли-
 * ста. Подсчитать стоимость. Провести сортировку амуниции на основе веса.
 * Найти элементы амуниции, соответствующие заданному диапазону пара-
 * метров цены.
 */

import creator.EquipsCreator;
import logic.Operation;
import parse.DOMParser;
import parse.SAXParser;
import parse.StAXParser;
import parse.Validation;
import substance.biker.Biker;
import substance.equipment.Equip;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String NAME = "Name of biker: ";
    private static final String FULL_PRISE = "Full prise of equipment list: ";
    private static final String FILTERED_BY_GAP = "Filtered equipment list by prise gap:";
    private static final String SORTED_LIST_BY_WEIGHT = "Get sorted list of equipments by weight: ";
    private static final String XML_PATH = "src\\kz\\javalab\\src\\Biker.xml";
    private static final String XSD_PATH = "src\\kz\\javalab\\src\\Biker.xsd";
    private static final String RESULT_XSD = "Result of validation by XSD: ";
    private static final String RESULT_SAX_STAX = "Comparison result SAX with StAX: ";

    public static void main(String[] args) throws IOException {
/*
        double sum = 0;

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
        Boolean result = validator.validate(XML_PATH, XSD_PATH);
        System.out.println(RESULT_XSD + result);

        SAXParser parserSax = new SAXParser();
        parserSax.parse(XML_PATH);
        StAXParser parserStax = new StAXParser();
        parserStax.parse(XML_PATH);
        System.out.println(RESULT_SAX_STAX + parserStax.getBiker().equals(parserSax.getBiker()));

        DOMParser parserDom = new DOMParser();
        parserDom.parse(XML_PATH);


        // System.out.println(parserSax.getBiker().toString());
        // System.out.println(parserStax.getBiker().toString());


    }
}
