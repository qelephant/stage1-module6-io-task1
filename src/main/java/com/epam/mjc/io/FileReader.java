package com.epam.mjc.io;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = "";
        int age = 0;
        String email = "";
        Long phone = "";

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        try {
            while (line != null) {
                if (line.startsWith("Name:")) {
                    name = line.substring(5).trim();
                } else if (line.startsWith("Age:")) {
                    age = Integer.parseInt(line.substring(4).trim());
                } else if (line.startsWith("Email:")) {
                    email = line.substring(6).trim();
                } else if (line.startsWith("Phone:")) {
                    phone = Long.parseLong(line.substring(6).trim());
                }
                line = reader.readLine();
            }
        } finally {
            reader.close();
        }
        return new Profile(name, age, email, phone);
    }
}
