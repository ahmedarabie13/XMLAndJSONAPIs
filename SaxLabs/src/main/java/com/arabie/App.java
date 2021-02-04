package com.arabie;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;


/**
 * JavaFX App
 */
public class App {

    public static void main(String[] args)throws Exception {

//        doSAXLab1();
        doSAXLab2();
    }
    private static void doSAXLab1() throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        Handler handler= new Handler();
        File XMLFile = new File(App.class.getResource("/Data.xml").getPath());
        saxParser.parse(XMLFile,handler);
    }

    private static void doSAXLab2() throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        StudentHandler handler= new StudentHandler();
        File XMLFile = new File(App.class.getResource("/students.xml").getPath());
        saxParser.parse(XMLFile,handler);
        System.out.println(handler.getStudents());
    }


}