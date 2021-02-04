package com.arabie;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class StudentHandler extends DefaultHandler {
    private static final String Student = "student";
    private static final String Name = "name";
    private static final String Grade = "grade";
    private static final String ClassNo = "class";
    private ArrayList<Student> students= new ArrayList<>();

    private String elementVal="";
    private Student student;
    public ArrayList<Student> getStudents(){
        return students;
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName){
            case Student:
                student=new Student();
                break;
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case Name:
                student.setName(elementVal);
                break;
            case Grade:
                student.setGrade(elementVal);
                break;
            case ClassNo:
                student.setClassNo(Integer.parseInt(elementVal));
                break;
            case Student:
                students.add(student);
                break;
        }
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementVal=new String(ch,start,length);

    }
}
