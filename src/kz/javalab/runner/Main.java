package runner;

/**
 * Определить иерархию амуниции. Экипировать мотоцикли-
 * ста. Подсчитать стоимость. Провести сортировку амуниции на основе веса.
 * Найти элементы амуниции, соответствующие заданному диапазону пара-
 * метров цены.
 */

import logic.Operation;
import parse.DOMParser;
import parse.SAXParser;
import parse.StAXParser;
import parse.Validation;

import java.io.IOException;


public class Main {
    private static final String FILTERED_BY_GAP = "Filtered equipment list by prise gap:";
    private static final String SORTED_LIST_BY_WEIGHT = "Get sorted list of equipments by weight: ";
    private static final String XML_PATH = "src\\kz\\javalab\\src\\Biker.xml";
    private static final String XSD_PATH = "src\\kz\\javalab\\src\\Biker.xsd";
    private static final String RESULT_XSD = "Result of validation by XSD: ";
    private static final String RESULT_SAX_STAX = "Comparison result SAX with StAX: ";
    private static final String RESULT_DOM_SAX = "Comparison result DOM with SAX: ";

    public static void main(String[] args) throws IOException {

        Validation validator = new Validation();
        Boolean result = validator.validate(XML_PATH, XSD_PATH);
        System.out.println(RESULT_XSD + result);

        SAXParser parserSax = new SAXParser();
        parserSax.parse(XML_PATH);
        StAXParser parserStax = new StAXParser();
        parserStax.parse(XML_PATH);
        DOMParser parserDom = new DOMParser();
        parserDom.parse(XML_PATH);
        System.out.println(RESULT_SAX_STAX + parserStax.getBiker().equals(parserSax.getBiker()));
        System.out.println(RESULT_DOM_SAX + parserDom.getBiker().equals(parserSax.getBiker()));


        System.out.println();
        System.out.println(FILTERED_BY_GAP);
        Operation.getEquipsByPriceGap(parserSax.getBiker(), 30, 160);
        System.out.println();
        System.out.println(SORTED_LIST_BY_WEIGHT);
        Operation.sortAmmunitionByWeight(parserSax.getBiker().getEquipList());
    }
}
