package parse;

import substance.biker.Biker;
import substance.equipment.*;

import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by HdgDink on 24.07.2017.
 */
public class StAXParser {
    private static final String BIKER = "biker";
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

    public Biker parse(String pathXML) {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        InputStream inputStream = null;
        XMLStreamReader streamReader = null;
        try {
            inputStream = new FileInputStream(pathXML);
            streamReader = factory.createXMLStreamReader(inputStream);
            process(streamReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return biker;
    }

    private void process(XMLStreamReader streamReader) throws XMLStreamException {
        while (streamReader.hasNext()) {
            int type = streamReader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    thisElement = streamReader.getLocalName();
                    if (thisElement.equals(BIKER))
                        biker = new Biker();
                    if (streamReader.getAttributeValue(0) != null)
                        biker.setName(streamReader.getAttributeValue(0));
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    setEquipList(streamReader.getLocalName());
                    break;
                case XMLStreamConstants.CHARACTERS:
                    getSpecs(thisElement, streamReader);
                    break;
                case XMLStreamConstants.END_DOCUMENT:
                    break;
            }
        }
    }

    private void getSpecs(String thisElement, XMLStreamReader streamReader) {
        if (!streamReader.getText().trim().equals("")) {
            switch (thisElement) {
                case BRAND:
                    this.brand = streamReader.getText();
                    break;
                case TYPE:
                    this.type = streamReader.getText();
                    break;
                case VENTILATION:
                    this.ventilation = Boolean.parseBoolean(streamReader.getText());
                    break;
                case WEIGHT:
                    this.weight = Double.parseDouble(streamReader.getText());
                    break;
                case PRICE:
                    this.price = Double.parseDouble(streamReader.getText());
                    break;
                case SIZE:
                    this.size = Double.parseDouble(streamReader.getText());
                    break;
                case MATERIAL:
                    this.material = streamReader.getText();
                    break;
                case COLOR_OF_VISOR:
                    this.colorOfVisor = streamReader.getText();
                    break;
                case BUILD_IN_PROTECTION:
                    this.buildInProtection = Boolean.parseBoolean(streamReader.getText());
                    break;
            }
        }

    }

    private void setEquipList(String localName) {
        switch (localName) {
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