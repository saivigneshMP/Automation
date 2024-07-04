package XaaSFlow;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LoginScreen;

public class XaaSflowMainMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait loginwait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		Wait<WebDriver> fwait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(StaleElementReferenceException.class);
		Actions a = new Actions(driver);
		driver.manage().window().maximize();	
		LoginScreen loginscreen = new LoginScreen(driver);
		loginscreen.goTo();
		loginscreen.loginApplication("saivignesh@corenttech.com", "Corent@123$#");

	}

}
