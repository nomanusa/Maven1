package org.pageClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//localhost:8080
//java -jar jenkins.war


public class Electronics {

	WebDriver driver;
	public Electronics(WebDriver driver) 
	 {
	 this.driver = driver;                     
	 PageFactory.initElements(driver, this);
	 }
	
	
	@FindBy(xpath = "(//*[contains(text(),'Cell Phones & Accessories')])[4]")
	WebElement CellPhones;
	
	
	
	public void accessoriespagevisibility() 
	{
		assertEquals(CellPhones.isDisplayed(), true);
		//System.out.println(CellPhones.isDisplayed());
	}
}
