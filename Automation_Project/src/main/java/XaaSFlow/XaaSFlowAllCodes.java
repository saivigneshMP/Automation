package XaaSFlow;

import java.time.Duration;
import java.util.Random;

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
	    driver.findElement(By.xpath("//input[@id='loginForm:password' or @name = 'loginForm:password']")).sendKeys("Corent@123$#");
	    driver.findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menuCLinkForm:appsaascCmdLink']"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='Open_create_application_profile_btn']"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='radio-3']/following-sibling::label"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='selectsaasprofileFlowForm:create_application_profile_btn_slid1']"))).click();
	    Random r = new Random();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='profilecreationForm:existingClustername_input']"))).sendKeys("XaaSgroup" + r.nextInt(456));
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='profilecreationForm:profilename']"))).sendKeys("XaaSapplication" + r.nextInt(456));
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='profilecreationForm:create_application_profile_sidebar']"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='profilecreationForm:existingAppusername_input']"))).sendKeys("XaaSapplication" + r.nextInt(456));
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='profilecreationForm:profilename']"))).sendKeys("XaaSapplication" + r.nextInt(456));
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='profilecreationForm:create_application_profile_sidebar']"))).click();
	}

}
