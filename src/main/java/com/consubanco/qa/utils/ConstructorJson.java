package com.consubanco.qa.utils;


import com.consubanco.qa.models.Pet;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;


import java.util.concurrent.ThreadLocalRandom;

public class ConstructorJson {

    static ObjectMapper mapp = new ObjectMapper();

   /* @SneakyThrows
    public static String petJson(String name) {
       return mapp.writeValueAsString(new Pet(
               generarIdNumerico(),
                name,
                "available",
               "[]"
        ));

    }*/

    public static int generarIdNumerico() {
        return ThreadLocalRandom.current().nextInt(1, 1000000);
    }
}