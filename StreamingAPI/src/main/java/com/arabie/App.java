package com.arabie;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;
import javax.json.stream.JsonParser;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;


/**
 * JavaFX App
 */
public class App {


    public static void main(String[] args) throws Exception {
        consumeJSON();
//        produceJSON();
    }
    public  static  void consumeJSON() throws Exception {

        JsonParser parser = Json.createParser(new FileInputStream("src/main/resources/bookStore.json"));

        while (parser.hasNext()){
            JsonParser.Event event = parser.next();
            switch (event){
                case START_ARRAY:
                    System.out.println("Start of array");
                    break;
                case END_ARRAY:
                    System.out.println("End of array");
                    break;
                case KEY_NAME:
                    System.out.println("Key name: " + parser.getString());
                    break;
                case VALUE_STRING:
                    System.out.println("String value: " + parser.getString());
                    break;
                case VALUE_NUMBER:
                    System.out.println("Number value: " + parser.getBigDecimal());
                    break;
                case VALUE_TRUE:
                    System.out.println("Boolean value: true");
                    break;
                case VALUE_FALSE:
                    System.out.println("Boolean value: false");
                    break;
                case VALUE_NULL:
                    System.out.println("Null value");
                    break;
//
            }
        }
        parser.close();
    }
    public  static  void produceJSON() throws Exception {

        Map<String, Object> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        JsonGeneratorFactory generatorFactory = Json.createGeneratorFactory(config);
        JsonGenerator generator = generatorFactory.createGenerator(System.out);

        generator.writeStartObject()
                    .write("id","20")
                    .write("firstName","Ahmed")
                    .write("lastName","Arabie")
                    .write("age","23")
                    .writeStartArray("address")
                        .writeStartObject()
                            .write("number","17")
                            .write("st","Azeez Fahmy ST")
                            .write("city","quesna")
                            .write("country","Egypt")
                        .writeEnd()
                    .writeEnd()
                .writeEnd();

        generator.close();
    }

}