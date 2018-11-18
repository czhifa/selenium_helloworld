package com.asurion.optimalpath.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
  
  Properties prop = new Properties();
  String filePath = "C://Automation//workspace//OpTest//src//main//resources//propFiles//config.properties";
  
  
  public String ReadPropertiesFileByKey(String key) throws FileNotFoundException{
    
    File file = new File(filePath);
    FileInputStream fis = new FileInputStream(file);	
    try {
      prop.load(fis);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return prop.getProperty(key);
    
    
  }

}