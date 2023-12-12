package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            StringBuilder fileContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
            String[] lines = fileContent.toString().split("\n");
            String name = null, age = null, email = null, phone = null;
            for (String fileLine : lines) {
                if (fileLine.startsWith("Name:")) {
                    name = fileLine.substring("Name:".length()).trim();
                } else if (fileLine.startsWith("Age:")) {
                    age = fileLine.substring("Age:".length()).trim();
                } else if (fileLine.startsWith("Email:")) {
                    email = fileLine.substring("Email:".length()).trim();
                } else if (fileLine.startsWith("Phone:")) {
                    phone = fileLine.substring("Phone:".length()).trim();
                }
            }
            return new Profile(name, Integer.parseInt(age), email, phone);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
