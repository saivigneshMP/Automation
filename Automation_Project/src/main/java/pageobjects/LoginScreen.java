package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen {

	WebDriver driver ;
	
	public LoginScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='loginForm:username' or @name = 'loginForm:username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='loginForm:password' or @name = 'loginForm:password']")
	WebElement password;
	
	@FindBy(xpath="//span[contains(text(),'Sign In')]")
	WebElement signin;
	
	public void goTo() {
		driver.get("https://automationzone.qaops.smartersaas.com:9000/surpaas/#");;
	}
	
	public void loginApplication(String usernames, String passwords) {
		username.sendKeys(usernames);
		password.sendKeys(passwords);
		signin.click();
	}
	
}
