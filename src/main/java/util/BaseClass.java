package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class BaseClass extends Propertie{
	
	
	static WebDriver driver;
	

	public static WebDriver init() {
		
		Prop();
		
		System.setProperty("webdriver.edge.driver", "driver\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	

	public static void TearDown() {
		driver.close();
		driver.quit();
	}
	
	
	

}
