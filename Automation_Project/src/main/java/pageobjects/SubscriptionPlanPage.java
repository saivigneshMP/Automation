package pageobjects;

import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class SubscriptionPlanPage extends AbstractComponent {
	WebDriver driver;

	public SubscriptionPlanPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@id='AddorEditForm:saasBox_items']/li")
	List<WebElement> saasboxdropdownvalue;

	@FindBy(xpath = "//ul[@id='AddorEditForm:paymentGatewaytype_items']//li")
	List<WebElement> paymentgatewaydropdownvalue;

	@FindBy(xpath = "//ul[@id='AddorEditForm:currencychoose_items']//li")
	List<WebElement> currencydropdownvalue;

	@FindBy(xpath = "//ul[@id='AddorEditForm:recurringTypeid_items']//li")
	List<WebElement> recurringdropdownvalue;
	
	@FindBy(xpath = "//*[text()='Create Subscription Plans']")
	WebElement createSubscriptionPlanText;

	By addSubscriptionPlanIcon = By.xpath("//button[@id='subscriptionPlanForm:subscriptionAddid']/span");
	By subscriptionPlanName = By.xpath("//input[@id='AddorEditForm:productName']");
	By saasBoxDropDown = By.xpath("//div[@id='AddorEditForm:saasBox']//span");
	By paymentGateWayDropdown = By.xpath("//div[@id='AddorEditForm:paymentGatewaytype']//span");
	By currencyDropdown = By.xpath("//div[@id='AddorEditForm:currencychoose']//span");
	By recurringDropdown = By.xpath("//div[@id='AddorEditForm:recurringTypeid']//span");
	By planSaveButton = By.xpath("//button[@id='AddorEditForm:productSaveOrUpdate']/span");
	By planSaveOkButton = By.xpath("//button[@id='SuccessFormsummary:successcloseButn']");

	public void createSubcriptionPlan() throws Exception {
		waitForElementToBeClickable_Click(addSubscriptionPlanIcon, 60);
		waitForElementToBeClickable_SendKeys(subscriptionPlanName, "planname" + random(), 20);
		Thread.sleep(2000);
		pageDown().keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);

		waitForElementToBeClickable_Click(saasBoxDropDown, 20);
		for (WebElement SaaSbox : saasboxdropdownvalue) {
			if (SaaSbox.getText().contains("Default")) {
				SaaSbox.click();
				Thread.sleep(2000);
			}

		}
		waitForElementToBeClickable_Click(paymentGateWayDropdown, 20);
		List<WebElement> paymentGateway = driver
				.findElements(By.xpath("//ul[@id='AddorEditForm:paymentGatewaytype_items']//li"));
		for (WebElement payment : paymentGateway) {
			if (payment.getText().contains("Default")) {
				payment.click();
				Thread.sleep(2000);
			}

		}

		waitForElementToBeClickable_Click(currencyDropdown, 20);
		for (WebElement currency : currencydropdownvalue) {
			if (currency.getText().contains("USD: United States Dollar($)")) {
				currency.click();
				Thread.sleep(2000);
			}

		}
		waitForElementToBeClickable_Click(recurringDropdown, 20);
		for (WebElement recuuring_every : recurringdropdownvalue) {
			if (recuuring_every.getText().contains("Daily")) {
				recuuring_every.click();
				Thread.sleep(2000);
			}
		}
		createSubscriptionPlanText.click();
		fluentWait_Click(planSaveButton);
		waitForElementToBeClickable_Click(planSaveOkButton,20);
	}

}
