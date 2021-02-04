package com.arabie;

import com.arabie.models.AddressType;
import com.arabie.models.ObjectFactory;
import com.arabie.models.PersonType;
import jakarta.xml.bind.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * JavaFX App
 */
public class App {


    public static void main(String[] args) throws Exception {

        doLab1();

//        doLab2();

    }


    private static void doLab1() throws JAXBException, IOException {

        JAXBContext context =JAXBContext.newInstance(Product.class);
        Product product = new Product(1,20.0,"Laptop","1/2/2021","ASUS");
        product.getAddressList().add(new Address(1,"Giza","Egypt"));
        product.getAddressList().add(new Address(2,"Cairo","Egypt"));

        doMarshaller(context, product);


//        doUnMarshaller(context);
    }

    private static void doUnMarshaller(JAXBContext context) throws JAXBException, FileNotFoundException {
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Product productFromXML =(Product) unmarshaller.unmarshal(new FileReader("product.xml"));
        System.out.println(productFromXML);
    }

    private static void doMarshaller(JAXBContext context, Product product) throws JAXBException, IOException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(product,new FileWriter("product.xml"));
    }

    private static void doLab2() throws JAXBException, IOException {
        JAXBContext context =JAXBContext.newInstance("com.arabie.models");
        Marshaller marshaller = context.createMarshaller();
        Unmarshaller unmarshaller = context.createUnmarshaller();

        ObjectFactory objectFactory =new ObjectFactory();
        AddressType addressType1 = objectFactory.createAddressType();
        addressType1.setNumber(10);
        addressType1.setStreet("noWhere st");
        AddressType addressType2 = objectFactory.createAddressType();
        addressType2.setNumber(12);
        addressType2.setStreet("noWhere 2 st");

        PersonType personType =objectFactory.createPersonType();
        personType.setName("Ali");
        personType.getAddress().add(addressType1);
        personType.getAddress().add(addressType2);

        JAXBElement<PersonType> person = objectFactory.createPerson(personType);

        marshaller.marshal(person,new FileWriter("person.xml"));

        Object object = unmarshaller.unmarshal(new FileReader("person.xml"));
        if(object instanceof JAXBElement){
            JAXBElement<PersonType> jaxbElement =(JAXBElement<PersonType>) object;
            PersonType unMarshalledPersonType = jaxbElement.getValue();
            System.out.println(unMarshalledPersonType.getName());
            for(AddressType address :unMarshalledPersonType.getAddress()){
                System.out.println(address.getNumber());
                System.out.println(address.getStreet());
            }
        }
    }

}