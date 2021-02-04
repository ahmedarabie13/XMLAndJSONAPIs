package com.arabie;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.w3c.dom.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.*;


class Handler extends DefaultHandler{
    private static final String Menu = "menu";
    private static final String MenuItem = "menuitem";

    private String elementVal="";
    private MenuBar menuBar =new MenuBar();
    private Menu menu;
    private MenuItem menuItem;

    public MenuBar getMenuBar(){
        return menuBar;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName){
            case Menu:
                menu =new Menu();
                menu.setText(attributes.getValue(0));
                menuBar.getMenus().add(menu);
                break;
            case MenuItem:
                menuItem =new MenuItem();
                menu.getItems().add(menuItem);
                break;
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
       switch (qName){
            case MenuItem:
              menuItem.setText(elementVal);
                break;
        }
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementVal=new String(ch,start,length);

    }
}
/*
*
* sax iterate store
* transformation with/out inst
* xpath
*
*
* */
public class App extends Application {

    private MenuBar menus=new MenuBar();

    @Override
    public void start(Stage stage) throws ParserConfigurationException, IOException, SAXException {
//        doDom();
        doSAX();
        var scene = new Scene(new Pane(menus), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    private void doSAX() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        Handler handler= new Handler();
        File XMLFile = new File(getClass().getResource("/com.arabie/Data.xml").getPath());
        saxParser.parse(XMLFile,handler);
        menus = handler.getMenuBar();
    }

    private void doDom() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File XMLFile = new File(getClass().getResource("/com.arabie/Data.xml").getPath());
        Document document =builder.parse(XMLFile);
        Element root = document.getDocumentElement();
        NodeList childs =root.getChildNodes();
        for(int i=0;i<childs.getLength();i++) {
            if (childs.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Menu menu = new Menu();
                Node node = childs.item(i).getAttributes().item(0);

                menu.setText(node.getNodeValue());
                var menuChilds = childs.item(i).getChildNodes();
                for (int j = 0; j < menuChilds.getLength(); j++) {
                    MenuItem menuItem = new MenuItem();
                    if (menuChilds.item(j).getNodeType() == Node.ELEMENT_NODE) {

                        menuItem.setText(menuChilds.item(j).getTextContent());
                        menu.getItems().add(menuItem);

                    }
                }
                menus.getMenus().add(menu);

            }
        }
    }

    public static void main(String[] args) {
        launch();
    }

}