package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	
	Properties properties;
	
	public Configuration() {
		loadProperties();
	}
	
	
	private void loadProperties() {
		properties=new Properties();
		InputStream iStream=getClass().getClassLoader().getResourceAsStream("configuration.properties");
		try {
			properties.load(iStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String readProp(String key) {
		return properties.getProperty(key);
	}
	
	
	public int readPropNum(String key) {
		return Integer.parseInt(readProp(key));
	}

}
