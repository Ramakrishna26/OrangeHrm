package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropertyFileUtil 

{
	public static String getValueforKey(String key) throws Exception, Exception
	{
		Properties configproperties = new Properties();
		
		configproperties.load(new FileInputStream(new File("./PropertiesFile/Environment.properties")));
		
		return configproperties.getProperty(key);
	}

}
