package PageObject;

import org.openqa.selenium.WebDriver;

import Utilities.testContainer;

public class pageObjectManager {
	
	public testContainer testContainer;
	public static WebDriver driver;

	public pageObjectManager(WebDriver drivers) {
		driver = drivers;
	}
	
	public static  HomePageValid HomePage() {
		HomePageValid homePage = new HomePageValid(driver);
		return homePage;
	}
	
	}
