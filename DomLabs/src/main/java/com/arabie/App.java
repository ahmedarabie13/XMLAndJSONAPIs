package com.arabie;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;


/**
 * JavaFX App
 */
public class App{


    public static void main(String[] args) throws Exception {

       doDom();
//       createDom();

    }

    private static void createDom() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("person");
        document.appendChild(root);

        Element name = document.createElement("name");

        root.appendChild(name);

        Element firstName = document.createElement("firstname");
        firstName.appendChild(document.createTextNode("ahmed"));
        name.appendChild(firstName);

        Element lastname = document.createElement("lastname");
        lastname.appendChild(document.createTextNode("Arabie"));
        name.appendChild(lastname);

        Element address = document.createElement("address");
        root.appendChild(address);

        Element number = document.createElement("number");
        number.appendChild(document.createTextNode("10"));
        address.appendChild(number);

        Element street = document.createElement("street");
        street.appendChild(document.createTextNode("noWhere highway st"));
        address.appendChild(street);

        traverse(root);
    }

    private static void doDom() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File XMLFile = new File(App.class.getResource("/Data.xml").getPath());
        Document document =builder.parse(XMLFile);
        Element root = document.getDocumentElement();
        traverse(root);
    }

    private static void traverse(Element root) {
        NodeList childs = root.getChildNodes();
        for(int i=0;i<childs.getLength();i++) {
            if (childs.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Node node = childs.item(i).getAttributes().item(0);
                if(node!=null)
                    System.out.println("Menu: "+node.getNodeValue());
                var menuChilds = childs.item(i).getChildNodes();
                System.out.print(childs.item(i).getNodeName()+": ");
                for (int j = 0; j < menuChilds.getLength(); j++) {
                    if (menuChilds.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        System.out.print(menuChilds.item(j).getNodeName()+"\t"+menuChilds.item(j).getTextContent()+",\t");
                    }
                }
                System.out.println();

            }
        }
    }

}