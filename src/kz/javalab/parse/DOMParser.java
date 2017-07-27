package parse;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import substance.biker.Biker;
import substance.equipment.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by HdgDink on 24.07.2017.
 */
public class DOMParser {
    private static final String BIKER = "biker";
    private static final String NAME = "name";
    private static final String BRAND = "brand";
    private static final String WEIGHT = "weight";
    private static final String PRICE = "price";
    private static final String SIZE = "size";
    private static final String VENTILATION = "ventilation";
    private static final String TYPE = "type";
    private static final String MATERIAL = "material";
    private static final String COLOR_OF_VISOR = "colorOfVisor";
    private static final String BUILD_IN_PROTECTION = "buildInProtection";
    private static final String BOOTS = "boots";
    private static final String GLOVES = "gloves";
    private static final String HELMET = "helmet";
    private static final String JACKET = "jacket";
    private static final String PANTS = "pants";
    private String brand = "";
    private double weight;
    private double price;
    private double size;
    private boolean ventilation;
    private String type = "";
    private String material = "";
    private String colorOfVisor = "";
    private boolean buildInProtection;
    private Biker biker = null;
    private String thisElement = "";
    String tagName = "";
    private Node root = null;
    Document doc = null;

    public Biker parse(String pathXML) {

        try {
            DocumentBuilder xml = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = xml.parse(new File(pathXML));
            root = doc.getDocumentElement();
            thisElement = doc.getDocumentElement().getNodeName();
            if (thisElement == BIKER) {
                thisElement = doc.getDocumentElement().getAttribute(NAME);
                biker = new Biker();
                biker.setName(thisElement);
            }
            NodeList equipList = root.getChildNodes();
            addEquip(equipList, root);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return biker;
    }

    private void addEquip(NodeList equipList, Node root) {
        for (int i = 0; i < equipList.getLength(); i++) {
            tagName = equipList.item(i).getNodeName();
            if (equipList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                NodeList specList = root.getChildNodes().item(i).getChildNodes();
                specsOfEquip(specList);
            }
            switch (tagName) {
                case BOOTS:
                    this.biker.getEquipList().add(new Boots(type, brand, weight, price, size, ventilation));
                    break;
                case GLOVES:
                    this.biker.getEquipList().add(new Gloves(type, material, brand, weight, price, size, ventilation));
                    break;
                case HELMET:
                    this.biker.getEquipList().add(new Helmet(type, colorOfVisor, brand, weight, price, size, ventilation));
                    break;
                case JACKET:
                    this.biker.getEquipList().add(new Jacket(material, buildInProtection, brand, weight, price, size, ventilation));
                    break;
                case PANTS:
                    this.biker.getEquipList().add(new Pants(material, buildInProtection, brand, weight, price, size, ventilation));
                    break;
            }
        }
    }

    private void specsOfEquip(NodeList specList) {
        for (int j = 0; j < specList.getLength(); j++) {
            if (specList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                Node childElement = (Element) specList.item(j);
                switch (childElement.getNodeName()) {
                    case BRAND:
                        this.brand = childElement.getTextContent();
                        break;
                    case TYPE:
                        this.type = childElement.getTextContent();
                        break;
                    case VENTILATION:
                        this.ventilation = Boolean.parseBoolean(childElement.getTextContent());
                        break;
                    case WEIGHT:
                        this.weight = Double.parseDouble(childElement.getTextContent());
                        break;
                    case PRICE:
                        this.price = Double.parseDouble(childElement.getTextContent());
                        break;
                    case SIZE:
                        this.size = Double.parseDouble(childElement.getTextContent());
                        break;
                    case MATERIAL:
                        this.material = childElement.getTextContent();
                        break;
                    case COLOR_OF_VISOR:
                        this.colorOfVisor = childElement.getTextContent();
                        break;
                    case BUILD_IN_PROTECTION:
                        this.buildInProtection = Boolean.parseBoolean(childElement.getTextContent());
                        break;
                }
            }
        }
    }

    public Biker getBiker() {
        return biker;
    }
}
