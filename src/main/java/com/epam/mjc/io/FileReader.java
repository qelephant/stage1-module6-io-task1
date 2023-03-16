package com.epam.mjc.io;

import java.io.File;
import java.io.BufferedReader;
import java.util.Scanner;

public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = "";
        int age = 0;
        String email = "";
        Long phone = 0L;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("Name:")) {
                    name = line.substring(5).trim();
                    System.out.println(name);
                } else if (line.startsWith("Age:")) {
                    age = Integer.parseInt(line.substring(4).trim());
                } else if (line.startsWith("Email:")) {
                    email = line.substring(6).trim();
                } else if (line.startsWith("Phone:")) {
                    phone = Long.parseLong(line.substring(6).trim());
                }

            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new Profile(name, age, email, phone);
    }
}
