package com.arabie;


import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.*;

/**
 * JavaFX App
 */
public class App{



    public static void main(String[] args)throws Exception {
        doLab6();

        doMappingLab6();

    }

    private static void doMappingLab6() throws IOException {
        User user ;
        Jsonb jsonb = JsonbBuilder.create();

        try (InputStream in = new FileInputStream("user1.json")) {
            user = jsonb.fromJson(in, User.class);
        }
        System.out.println(user);
    }

    private static void doLab6() throws IOException {
        User user1 =new User();

        user1.setId(1);
        user1.setName("user1");
        user1.getAddress().add("address1");
        user1.getAddress().add("address2");
        user1.getAddress().add("address3");
        Jsonb jsonb = JsonbBuilder.create();

        jsonb.toJson(user1,new FileWriter("user1.json"));
    }


}