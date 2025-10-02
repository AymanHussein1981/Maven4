package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Propertie {
	
	static String Browser;
	static String URL;
	
	public static void Prop() {
		
		try {
			InputStream input=new FileInputStream("src\\main\\java\\config\\config.properties");
			Properties prop=new Properties();
			prop.load(input);
			Browser=prop.getProperty("browser");
			URL=prop.getProperty("url");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}


}
