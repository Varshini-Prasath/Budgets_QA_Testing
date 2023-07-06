package PageObject;


import static org.testng.Assert.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;

public class HomePageValid {
	public List<String> expenceType = new ArrayList<String>();
	public WebDriver drivers;
	public HomePageValid(WebDriver driver) {
		this.drivers = driver;
		PageFactory.initElements(driver ,this);
	}
	
	@FindBy(xpath = "//h5[@class=\"card-title\"]")
	WebElement cardTitle;
	@FindBy(css = "span[class=\"card-text\"]")
	WebElement transHeader;
	@FindBy(css = "span[class=\"text-primary\"]")
	WebElement transcation;
	@FindBy(css = "[class=\"tooltip-inner\"]")
	WebElement tooltipBox;
	@FindBy(css = "input[class*= \"form-check\"]")
	WebElement checkBox;
	@FindBy(css = "label[class*= \"form-check\"]")
	WebElement checkBoxLabel;
	@FindBy (css = "input[placeholder=\"Your notes\"]")
	WebElement transNotes;
	@FindBy (css="input[placeholder^=\"Amount\"]")
	WebElement amount;
	
	By plusIcon = By.cssSelector("svg[class$=\"circle-plus\"]");
	By transcationButton = By.xpath("//button[text()='Transaction']");
	By transcationHeaderPage = By.xpath("//div[text()=' Add a new transaction ']");
	By transcationTypeOptions = By.cssSelector("select#transaction-type");
	By category = By.cssSelector("select#transaction-category");
	
	
	public void getCardTitle() {
		String title = cardTitle.getAttribute("innerText");
		assertEquals("Previous update",title);
		System.out.println(title);
	}
	
	public void lastTransDetail() {
		//title
		String transTitle = transHeader.getAttribute("innerText");
		System.out.println(transTitle);
		assertEquals("Last transaction was added at", transTitle);
		//transhover
		Actions action = new Actions(drivers);
		action.moveToElement(transcation).build().perform();
		String getLastTranscation  = tooltipBox.getAttribute("innerText");
		System.out.println(getLastTranscation);	
	}
	public void checkBoxValidation() {
		if(checkBox.isSelected()) {
			String lableName = checkBoxLabel.getAttribute("textContext");
			System.out.println(lableName);
			assertEquals("All of today's updates were added (1:19 PM)" , lableName);
		}
		else {
			String checkBoxName = checkBoxLabel.getAttribute("textContent");
			System.out.println(checkBoxName);
			assertEquals("Wrap up today's updates", checkBoxName);
		}
	}
	
	public void transcationPopUpVisiblity() {
		drivers.findElement(plusIcon).click();
		drivers.findElement(transcationButton).click();
		drivers.findElement(transcationHeaderPage).isDisplayed();
	}
	
	public void transcationTypeDropdown(DataTable datatable) {
		drivers.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Select select = new Select(drivers.findElement(transcationTypeOptions));
		List<WebElement> transOptions = select.getOptions();
		System.out.println(transOptions);
		for(WebElement element: transOptions) {
			String elements = element.getText();
			expenceType.add(elements);
			System.out.println(expenceType);
			}
		List<Map<String,String>> Options = datatable.asMaps(String.class,String.class);
		
		for(Map<String,String> option: Options) {
			expenceType.contains(option.containsValue(option));
			
			System.out.println(expenceType.contains(option.values()));
			System.out.println( option.values() );
			}
		Actions action = new Actions(drivers);
		WebElement element = drivers.findElement(transcationTypeOptions);
		action.moveToElement(element).keyDown(Keys.ARROW_DOWN).click().perform();
		}
	
	public void updateTranscationDetail(String stringName, String string2, int int1)	{
		drivers.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element = drivers.findElement(category);
		Actions action = new Actions(drivers);
		element.sendKeys(stringName);
		transNotes.sendKeys(string2);
		amount.sendKeys(String.valueOf(int1));
	}
	public void accountType() {
		drivers.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		WebDriverWait wait =new WebDriverWait(drivers,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(category))
		drivers.get("https://rahulshettyacademy.com/AutomationPractice/");
		drivers.findElement(By.cssSelector("a[class=\"blinkingText\"]")).click();
		Set<String> window = drivers.getWindowHandles();
		Iterator<String> name = window.iterator();
		String parentWindow = name.next();
		String childWindow = name.next();
		drivers.switchTo().window(parentWindow);
	}
	
	
}
