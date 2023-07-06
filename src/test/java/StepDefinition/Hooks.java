package StepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Utilities.testContainer;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks
{
	public static testContainer tc;
	public Hooks(testContainer testContainer) {
		tc = testContainer;
	}
	
	@Before("@Regression")
	public void beforeHooks() {
		tc.driver.get("https://budgets-qa-ee0c6.web.app/");
		System.out.println("check");
	}
	@Before(order=1)
	public void beforeonw() {
		System.out.println("setOut");
	}
	@After
	public void afterHooks() throws IOException {
		tc.driver.close();
		File scr = ((TakesScreenshot)tc.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("/BudgetsQA/target"));
	}
}
