package abstractcomponents;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElementToBeClickable_SendKeys(By findBy, String name , int second) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(second));
		wait.until(ExpectedConditions.elementToBeClickable(findBy)).sendKeys(name);
	}
	
	public void waitForElementToBeClickable_Click(By findBy, int second) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(second));
		wait.until(ExpectedConditions.elementToBeClickable(findBy)).click();
	}	
	public void fluentWait_SendKeys(By findby, String name) {	
		Wait<WebDriver> fwait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(StaleElementReferenceException.class);
		fwait.until(ExpectedConditions.elementToBeClickable(findby)).sendKeys(name);

	}
	
	public String fluentWait_GetAttribute(By findby, String name) {	
		Wait<WebDriver> fwait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(StaleElementReferenceException.class);
		return fwait.until(ExpectedConditions.elementToBeClickable(findby)).getAttribute(name);

	}
	
	public int random() {
		Random r = new Random();
		return r.nextInt();
		
		
	}
       

}
	
