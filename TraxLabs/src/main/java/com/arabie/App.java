package com.arabie;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * JavaFX App
 */
public class App {


    public static void main(String[] args) throws Exception {

//        getXmlFromDOM();

//        getHtmlFromXml();

        doXpath();

    }

    private static void doXpath() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document domDocument = builder.parse(App.class.getResource("/persons.xml").getPath());
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        XPathExpression expression = xPath.compile("//firstname");
        NodeList nodeList = (NodeList) expression.evaluate(domDocument, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);
            System.out.println(item.getTextContent());
        }
    }

    private static void getHtmlFromXml() throws ParserConfigurationException, SAXException, IOException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document xmlDocument = builder.parse(App.class.getResource("/persons.xml").getPath());
        DOMSource xmlDom = new DOMSource(xmlDocument);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder1 = factory.newDocumentBuilder();
        Document xsltDocument = builder1.parse(App.class.getResource("/rules.xslt").getPath());

        DOMSource xsltSource = new DOMSource(xsltDocument);
        StreamResult result = new StreamResult(new File("persons.html"));

        Transformer transformer = transformerFactory.newTransformer(xsltSource);
        transformer.transform(xmlDom,result);
    }

    private static void getXmlFromDOM() throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("persons");
        document.appendChild(root);


        attach(document, root);
        attach(document,root);
        attach(document, root);
        attach(document,root);


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new FileOutputStream("persons.xml"));
        transformer.transform(domSource, streamResult);
    }

    private static void attach(Document document, Element root) {
        Element subRoot = document.createElement("person");
        root.appendChild(subRoot);

        Element name = document.createElement("name");

        subRoot.appendChild(name);

        Element firstName = document.createElement("firstname");
        firstName.appendChild(document.createTextNode("ahmed"));
        name.appendChild(firstName);

        Element lastname = document.createElement("lastname");
        lastname.appendChild(document.createTextNode("Arabie"));
        name.appendChild(lastname);

        Element address = document.createElement("address");
        subRoot.appendChild(address);

        Element number = document.createElement("number");
        number.appendChild(document.createTextNode("10"));
        address.appendChild(number);

        Element street = document.createElement("street");
        street.appendChild(document.createTextNode("noWhere highway st"));
        address.appendChild(street);
    }


}