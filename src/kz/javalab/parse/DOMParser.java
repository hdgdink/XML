package parse;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import substance.biker.Biker;
import substance.equipment.Boots;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

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
    private Node root = null;



    public Biker parse(String pathXML) {
        try {
            DocumentBuilder xml = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = xml.parse(new File(pathXML));
            root = doc.getDocumentElement();
            biker = new Biker();

                biker.setName(root.getAttributes().toString());

           // System.out.println(biker.toString());

        } catch (
                Exception e)

        {
            e.printStackTrace();
        }

        return biker;
    }
}
