package com.arabie;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class Handler extends DefaultHandler {
    private static final String Menu = "menu";
    private static final String MenuItem = "menuitem";

    private String elementVal="";




    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        switch (qName){
            case Menu:
                System.out.println("\n"+qName+": "+attributes.getValue(0));
                break;
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case MenuItem:
                System.out.print(qName+": "+elementVal+"\t");
                break;
        }
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementVal=new String(ch,start,length);

    }
}
