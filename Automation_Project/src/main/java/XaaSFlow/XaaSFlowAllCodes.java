package XaaSFlow;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XaaSFlowAllCodes {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait loginwait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		Wait<WebDriver> fwait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(StaleElementReferenceException.class);
		Actions a = new Actions(driver);
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
		fwait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@id='profilecreationForm:existingClustername_input']")))
				.sendKeys("groupname" + r.nextInt());
		fwait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@id='profilecreationForm:existingAppusername_input']")))
				.sendKeys("applicationname" + r.nextInt());
		fwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='profilecreationForm:profilename']")))
				.sendKeys("profilename" + r.nextInt());
		Thread.sleep(10000);
		
		String applicationName = fwait
				.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//input[@id='profilecreationForm:existingAppusername_input']")))
				.getAttribute("value");
		String profileName = fwait
				.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//input[@id='profilecreationForm:profilename']")))
				.getAttribute("value");
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
		
				String applicationNameNew = fwait
				.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//input[@id='profilecreationForm:existingAppusername_input']")))
				.getAttribute("value");
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@id='profilecreationForm:create_application_profile_sidebar']"))).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@id='applicationArtifaactAddEditForm:createartifact']")))
				.click();		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='addArtifactForm:displayname']")))
				.sendKeys("test" + r.nextInt(789432));
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='addArtifactForm:downloadurl']")))
				.sendKeys("https://automationzone.qaops.smartersaas.com:9000/surpaas/#");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='addArtifactForm:description']")))
				.sendKeys("test" + r.nextInt(852234));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='addArtifactForm:saveartifact']")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='statusDialogform:Ok']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-chevron-right'])[1]"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']/p")))
				.sendKeys("test" + r.nextInt());
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@id='applicationArtifaactAddEditForm:saveButton']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='statusDialogform:Ok']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-chevron-right'])[4]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menuCLinkForm:appMarketizercCmdLink']")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@id='appandoffersetupHomeListForm:appandoffersetupHomePanel']//button")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='collapse-icon']"))).click();
		List<WebElement> planNames = driver.findElements(By.xpath("//span[@class='gui-inline-header']"));
		for (int i = 0; i < planNames.size(); i++) {
			WebElement element = planNames.get(i);
			if (element.getText().contains("xaasapplication21")) {
				element.click();

			}

		}

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@id='subscriptionPlanForm:subscriptionAddid']/span"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='AddorEditForm:productName']"))).sendKeys("plan"+ r.nextInt());
		WebElement iframe1 = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe1);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']/p"))).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']/p"))).sendKeys("test"+ r.nextInt());
		driver.switchTo().defaultContent();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='AddorEditForm:saasBox']//span"))).click();
		List<WebElement> saasbox = driver.findElements(By.xpath("//ul[@id='AddorEditForm:saasBox_items']/li"));
		for(WebElement SaaSbox : saasbox) {
			if(SaaSbox.getText().contains("Default")) {
				SaaSbox.click();
			}
			
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='AddorEditForm:paymentGatewaytype']//span"))).click();
		List<WebElement> paymentGateway = driver.findElements(By.xpath("//ul[@id='AddorEditForm:paymentGatewaytype_items']//li"));
		for(WebElement payment : paymentGateway) {
			if(payment.getText().contains("Default")) {
				payment.click();
			}
			
		}
	
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='AddorEditForm:currencychoose']//span"))).click();
		List<WebElement> currencies = driver.findElements(By.xpath("//ul[@id='AddorEditForm:currencychoose_items']//li"));
		for(WebElement currency : currencies) {
			if(currency.getText().contains("USD: United States Dollar($)")) {
				currency.click();
			}
			
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='AddorEditForm:recurringTypeid']//span"))).click();
		List<WebElement> recuuring = driver.findElements(By.xpath("//ul[@id='AddorEditForm:recurringTypeid_items']//li"));
		for(WebElement recuuring_every : recuuring) {
			if(recuuring_every.getText().contains("Daily")) {
				recuuring_every.click();
			}
			
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='AddorEditForm:productSaveOrUpdate']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='SuccessFormsummary:successcloseButn']"))).click();
	    String tenantURL = 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='subscriptionSummaryHomeForm:subscriptiondataGridId:0:subscriptiondataGridPanel_content']//a)[1]"))).getAttribute("href");
	    driver.get(tenantURL);
	   System.out.println(driver.getCurrentUrl());
	}
	
	

}