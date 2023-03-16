package com.epam.mjc.io;

import java.io.File;
import java.io.*;

public class FileReader {

    public Profile getDataFromFile(File file) throws IOException{
        String name = "";
        int age = 0;
        String email = "";
        Long phone = 0L;
        
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        try {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Name:")) {
                    name = line.substring(5).trim();
                } else if (line.startsWith("Age:")) {
                    age = Integer.parseInt(line.substring(4).trim());
                } else if (line.startsWith("Email:")) {
                    email = line.substring(6).trim();
                } else if (line.startsWith("Phone:")) {
                    phone = Long.parseLong(line.substring(6).trim());
                }
            }
        } catch (IOException e) {
            
        } finally {
            br.close();
        }
        return new Profile(name, age, email, phone);
    }
}
