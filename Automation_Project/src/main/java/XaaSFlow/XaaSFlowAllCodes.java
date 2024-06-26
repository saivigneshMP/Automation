package XaaSFlow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XaaSFlowAllCodes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    WebDriverWait wait= new WebDriverWait(driver,Duration.ofMinutes(1));
	    driver.manage().window().maximize();
	    driver.get("https://automationzone.qaops.smartersaas.com:9000/surpaas/#");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginForm:username' or @name = 'loginForm:username']"))).sendKeys("saivignesh@corenttech.com");
	 //   driver.findElement(By.xpath("//input[@id='loginForm:username' or @name = 'loginForm:username']")).sendKeys("saivignesh@corenttech.com");
	    driver.findElement(By.xpath("//input[@id='loginForm:password' or @name = 'loginForm:password']")).sendKeys("Corent@123$#");
	    driver.findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menuCLinkForm:appsaascCmdLink']"))).click();
	}

}
