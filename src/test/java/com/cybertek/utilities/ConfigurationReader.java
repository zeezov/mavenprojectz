package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;

    static {
        // this is the path to the location of the file
        String path = "configuration.properties";

        try {
            // java cannot read files directly, it needs to inputStremto read files
            // inputStream take the location of the file as constructor
            FileInputStream fileInputStream = new FileInputStream(path);

            // Properties is used to read specificly Properties files, files with key value pairs
            properties = new Properties();

            // file contents are loaded to properties from the inputStream
            properties.load(fileInputStream);

            // all inputSteams must be closed (like Scanner);
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // returns the specific value of specific property
    public static String getProperty(String property) {

        return properties.getProperty(property);

    }

}
