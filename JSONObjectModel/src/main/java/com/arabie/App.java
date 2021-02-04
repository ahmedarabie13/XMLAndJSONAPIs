package com.arabie;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.json.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class App{


    public static void main(String[] args) throws Exception {
        produceJSON();
//        consumeJSON();
    }
    public static  void produceJSON()throws Exception{


        JsonArray cast = Json.createArrayBuilder()
                .add("AlPacino")
                .add("Cameron Diaz").build();

        JsonObject  obj= Json.createObjectBuilder()
                .add("title", "Any given Sunday")
                .add("cast", cast)
                .add("year",1999)
                .build();

        JsonWriter writer = Json.createWriter(new FileWriter("movie.json"));
        writer.writeObject(obj);
        writer.close();

    }
    public  static  void consumeJSON()throws Exception {

        JsonReaderFactory factory = Json.createReaderFactory(null);
        JsonReader JSONReader = factory.createReader(new FileReader("movie.json"));
        JsonObject jsonObject = JSONReader.readObject();

        JsonArray jsonArray = jsonObject.getJsonArray("cast");

        System.out.print("Cast: ");
        for(JsonValue jsonValue :jsonArray){
            System.out.print(jsonValue+"\t");
        }
        System.out.println();
        JsonNumber year =jsonObject.getJsonNumber("year");
        System.out.println("year: "+year.bigDecimalValue());
        System.out.println("title: "+jsonObject.getString("title"));
    }

}