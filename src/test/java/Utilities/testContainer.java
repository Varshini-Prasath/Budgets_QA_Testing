package Utilities;

import org.openqa.selenium.WebDriver;

import PageObject.pageObjectManager;


public class testContainer {
	
	public static WebDriver driver;
	public static pageObjectManager pageObject;
	
	public testContainer() {
		driver = webDriver.driver();
		pageObject = new pageObjectManager(driver);
	}
}
