package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class LoginScreen extends AbstractComponent {

	WebDriver driver ;
	
	public LoginScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;		
		PageFactory.initElements(driver, this);
		
	}

	
	@FindBy(xpath="//span[contains(text(),'Sign In')]")
	WebElement signin;
	
	By username = By.xpath("//input[@id='loginForm:username' or @name = 'loginForm:username']");
	By password = By.xpath("//input[@id='loginForm:password' or @name = 'loginForm:password']");
	
	public void goTo() {
		driver.get("https://automationzone.qaops.smartersaas.com:9000/surpaas/#");
		driver.manage().window().maximize();
	}
	
	public void loginApplication(String usernames, String passwords) {
		waitForElementToBeClickable_SendKeys(username, usernames , 10);
		waitForElementToBeClickable_SendKeys(password, passwords , 10);
		signin.click();
	}
	
}
