package com.consubanco.qa.utils;

import java.io.*;
import java.util.*;

public class DataToFeatures {

    private static List<String> setJsonDataToFeature(File featureFile) throws IOException {
        List<String> fileData = new ArrayList<>();
        String resourcesDataPath = "src/test/resources/data";
        try (BufferedReader buffReader = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                new FileInputStream(featureFile)), "UTF-8"))) {

            String line;
            boolean featureData = false;
            List<Map<String, String>> jsonData = null;

            while ((line = buffReader.readLine()) != null) {
                String trimmedLine = line.trim();

                if (trimmedLine.contains("#Data:")) {
                    String jsonFilePath = trimmedLine.substring(trimmedLine.indexOf(":") + 1, trimmedLine.lastIndexOf("|")).trim();
                    fileData.add(line);

                    File jsonFile = new File(resourcesDataPath, jsonFilePath);

                    jsonData = LectorJson.getData(jsonFile.getPath());
                    for (Map<String, String> row : jsonData) {
                        StringBuilder cellData = new StringBuilder();
                        for (String value : row.values()) {
                            cellData.append("|").append(value);
                        }
                        cellData.append("|");
                        if (cellData.toString().replace("|", "").trim().length() > 2) {
                            fileData.add(cellData.toString());
                        }
                    }
                    featureData = true;
                    continue;
                }

                if (trimmedLine.startsWith("|") && trimmedLine.endsWith("|")) {
                    if (featureData) {
                        continue;
                    } else {
                        fileData.add(line);
                        continue;
                    }
                } else {
                    featureData = false;
                }
                fileData.add(line);
            }
        }
        return fileData;
    }

    private static List<File> listOfFeatureFiles(File folder) {
        List<File> featureFiles = new ArrayList<>();
        File[] files = folder.listFiles();
        if (files != null) {
            for (File fileEntry : files) {
                if (fileEntry.isDirectory()) {
                    featureFiles.addAll(listOfFeatureFiles(fileEntry));
                } else if (fileEntry.isFile() && fileEntry.getName().endsWith(".feature")) {
                    featureFiles.add(fileEntry);
                }
            }
        }
        return featureFiles;
    }

    public static void overrideFeatureFiles(String featuresDirectoryPath) throws IOException {
        List<File> featureFiles = listOfFeatureFiles(new File(featuresDirectoryPath));
        for (File featureFile : featureFiles) {
            List<String> featureWithJsonData = setJsonDataToFeature(featureFile);
            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(featureFile), "UTF-8"))) {
                for (String line : featureWithJsonData) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        }
    }
}