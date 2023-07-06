package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/java/Feature/HomePageValid.feature",
		glue = "StepDefinition",
		stepNotifications = true,
		monochrome = true
		
)
public class testNgRunner {

}
