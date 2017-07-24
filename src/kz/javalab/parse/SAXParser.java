package parse;

import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;
import substance.biker.Biker;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created by HdgDink on 24.07.2017.
 */
public class SAXParser extends DefaultHandler {
    private String thisElement = "";
    Biker biker = null;

    public Biker parse(String xmlPath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(false);
            javax.xml.parsers.SAXParser parser = factory.newSAXParser();
            parser.parse(new File(xmlPath),this) ;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
        return biker;
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.thisElement = qName;
        if (thisElement.equals("biker"))
            biker = new Biker();
        if (attributes.getQName(0) != null)
            biker.setName(attributes.getValue("name"));
        System.out.println(biker.getName());
    }


    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {

    }


    @Override
    public void endElement(String s, String s1, String s2) throws SAXException {

    }
}
