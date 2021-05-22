package org.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseSetUp {
	WebDriver driver = null;
	public static Properties prop;
	
	@BeforeClass
	public void propLoad() throws IOException {
		 prop = new Properties();
		FileInputStream file = null;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+".\\src\\main\\java\\org\\config\\config.Properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			file.close();
		}
		
	}
	
	public WebDriver getDriver()
	{
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromePath"));
		
		   driver = new ChromeDriver();
		  
		   driver.get("https://www.amazon.com/");
		   
		   driver.manage().window().maximize();
		  
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		  
		  return driver;
		  
		 
	}
	@AfterClass
	     public void teardown()
	{
		driver.close();
	}

}
