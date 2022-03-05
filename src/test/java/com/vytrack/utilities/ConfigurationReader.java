package com.vytrack.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //Create the object of Properties
    private static Properties properties= new Properties();

   static {
       try {
       //We need to open the file in java memory:
       FileInputStream file=new FileInputStream("configuration.properties");

       //load the properties object using  FileInputStream object
           properties.load(file);
           //close the file
           file.close();

       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public static String getProperty(String keyword){
       return properties.getProperty(keyword);


   }



}
