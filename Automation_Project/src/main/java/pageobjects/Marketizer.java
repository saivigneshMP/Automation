package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class Marketizer extends AbstractComponent {
	WebDriver driver;

	public Marketizer(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@id='menuCLinkForm:appMarketizercCmdLink']")
	WebElement marketizerMenu;

	@FindBy(xpath = "//span[@class='gui-inline-header']")
	List<WebElement> planNames;

	By createMarketizerMenu = By.xpath("//div[@id='appandoffersetupHomeListForm:appandoffersetupHomePanel']//button");
	By sidemenu = By.xpath("//span[@id='collapse-icon']");


	public void createMarketizer() {
		marketizerMenu.click();
		waitForElementToBeClickable(createMarketizerMenu, 40);
		waitForElementToBeClickable_Click(sidemenu, 20);
		for (int i = 0; i < planNames.size(); i++) {
			WebElement element = planNames.get(i);
			if (element.getText().contains("xaasapplication21")) {
				element.click();

			}

		}

	}

}
