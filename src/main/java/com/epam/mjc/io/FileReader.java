package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String fileContent = "";
        Profile profile = new Profile();

        try (BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(file))) {
            fileContent = new String(fileInputStream.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!fileContent.isEmpty()) {
            String[] keyValueArray = fileContent.split("\n");

            if (keyValueArray.length == 4) {
                profile.setName(keyValueArray[0].substring(keyValueArray[0].indexOf(" ")).trim());
                profile.setAge(Integer.parseInt(keyValueArray[1].substring(keyValueArray[1].indexOf(" ")).trim()));
                profile.setEmail(keyValueArray[2].substring(keyValueArray[2].indexOf(" ")).trim());
                profile.setPhone(Long.parseLong(keyValueArray[3].substring(keyValueArray[3].indexOf(" ")).trim()));
            }
        }

        return profile;
    }
}
