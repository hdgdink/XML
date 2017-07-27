package parse;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import substance.biker.Biker;
import substance.equipment.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by HdgDink on 24.07.2017.
 */
public class SAXParser extends DefaultHandler {
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
    private static final String EMPTY = "";
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


    public Biker parse(String pathXML) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser parser = factory.newSAXParser();
            parser.parse(new File(pathXML), this);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return biker;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.thisElement = qName;
        if (thisElement.equals(BIKER)) {
            biker = new Biker();
            if (attributes.getQName(0) != null)
                biker.setName(attributes.getValue(NAME));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!String.valueOf(ch, start, length).trim().equals("")) {
            switch (thisElement) {
                case BRAND:
                    this.brand = String.valueOf(ch, start, length);
                    break;
                case TYPE:
                    this.type = String.valueOf(ch, start, length);
                    break;
                case VENTILATION:
                    this.ventilation = Boolean.parseBoolean(String.valueOf(ch, start, length));
                    break;
                case WEIGHT:
                    this.weight = Double.parseDouble(String.valueOf(ch, start, length));
                    break;
                case PRICE:
                    this.price = Double.parseDouble(String.valueOf(ch, start, length));
                    break;
                case SIZE:
                    this.size = Double.parseDouble(String.valueOf(ch, start, length));
                    break;
                case MATERIAL:
                    this.material = String.valueOf(ch, start, length);
                    break;
                case COLOR_OF_VISOR:
                    this.colorOfVisor = String.valueOf(ch, start, length);
                    break;
                case BUILD_IN_PROTECTION:
                    this.buildInProtection = Boolean.parseBoolean(String.valueOf(ch, start, length));
                    break;
            }
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
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

    public Biker getBiker() {
        return biker;
    }
}
