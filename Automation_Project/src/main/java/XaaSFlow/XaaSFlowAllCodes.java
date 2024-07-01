package XaaSFlow;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XaaSFlowAllCodes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait loginwait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://automationzone.qaops.smartersaas.com:9000/surpaas/#");
		loginwait
				.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//input[@id='loginForm:username' or @name = 'loginForm:username']")))
				.sendKeys("saivignesh@corenttech.com");
		driver.findElement(By.xpath("//input[@id='loginForm:password' or @name = 'loginForm:password']"))
				.sendKeys("Corent@123$#");
		driver.findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menuCLinkForm:appsaascCmdLink']")))
				.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@id='Open_create_application_profile_btn']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='radio-3']/following-sibling::label")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@id='selectsaasprofileFlowForm:create_application_profile_btn_slid1']"))).click();
		Random r = new Random();
		Wait<WebDriver> fwait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(Exception.class);
		fwait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@id='profilecreationForm:existingClustername_input']")))
				.sendKeys("groupname" + r.nextInt());
		fwait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@id='profilecreationForm:existingAppusername_input']")))
				.sendKeys("applicationname" + r.nextInt());
		fwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='profilecreationForm:profilename']")))
				.sendKeys("profilename" + r.nextInt());
		Thread.sleep(3000);
		String applicationName = fwait
				.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//input[@id='profilecreationForm:existingAppusername_input']")))
				.getText();
		String profileName = fwait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='profilecreationForm:profilename']")))
				.getText();
		if (applicationName.isEmpty()) {
			fwait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//input[@id='profilecreationForm:existingAppusername_input']")))
					.sendKeys("applicationname" + r.nextInt());
		} else {

		}
		if (profileName.isEmpty()) {
			fwait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='profilecreationForm:profilename']")))
					.sendKeys("profilename" + r.nextInt());
		} else {

		}

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@id='profilecreationForm:create_application_profile_sidebar']"))).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@id='applicationArtifaactAddEditForm:createartifact']")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='addArtifactForm:displayname']")))
				.sendKeys("test" + r.nextInt(789));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='addArtifactForm:downloadurl']")))
				.sendKeys("https://automationzone.qaops.smartersaas.com:9000/surpaas/#");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='addArtifactForm:description']")))
				.sendKeys("test" + r.nextInt(852));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='addArtifactForm:saveartifact']")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='statusDialogform:Ok']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-chevron-right'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cke_1_contents']")))
				.sendKeys("test" + r.nextInt(985));

	}

}