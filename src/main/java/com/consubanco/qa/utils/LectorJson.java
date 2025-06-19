package com.consubanco.qa.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LectorJson {
    public static List<Map<String, String>> getData(String jsonFilePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(jsonFilePath), new TypeReference<List<Map<String, String>>>(){});
    }
}