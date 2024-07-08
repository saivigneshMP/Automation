package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class XaaSFlow extends AbstractComponent {
	WebDriver driver;
	
	public XaaSFlow(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//input[@id='addArtifactForm:downloadurl']")
	WebElement downloadURL;

	@FindBy(xpath = "//textarea[@id='addArtifactForm:description']")
	WebElement Description;
	
	@FindBy(xpath = "//button[@id='addArtifactForm:saveartifact']")
	WebElement saveArtifact;
	
	@FindBy(xpath = "//iframe[@class='cke_wysiwyg_frame cke_reset']")
	WebElement iframeWebElement;

	By AddArtifactButton = By.xpath("//button[@id='applicationArtifaactAddEditForm:createartifact']");
	By displayname = By.xpath("//input[@id='addArtifactForm:displayname']");
	By popupOkButton = By.xpath("//button[@id='statusDialogform:Ok']");
	By applicationProcedureMenu = By.xpath("(//i[@class='fa fa-chevron-right'])[1]");
	By iframe = By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']");
	By applicationProcedureTextBox = By.xpath("//*[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']/p");
	By applicationProcedureSaveButton = By.xpath("//button[@id='applicationArtifaactAddEditForm:saveButton']");
	By applicationProcedureSaveOkButton = By.xpath("//button[@id='statusDialogform:Ok']");
	
	public void createArtifact() {
		waitForElementToBeClickable_Click(AddArtifactButton, 30);
		waitForElementToBeClickable_SendKeys(displayname,"test" +random(), 20 );
		downloadURL.sendKeys("https://automationzone.qaops.smartersaas.com:9000/surpaas/#");
		Description.sendKeys("test" + random());
		saveArtifact.click();
		waitForElementToBeClickable_Click(popupOkButton,10);
	}
	
	public void createApplicationProcedure() {
		waitForElementToBeClickable_Click(applicationProcedureMenu,10);
		waitForElementToBeClickable(iframe,10);
		iframe(iframeWebElement);
		waitForElementToBeClickable_SendKeys(applicationProcedureTextBox,"test"+random(),20);
		defaultWindow();
		waitForElementToBeClickable_Click(applicationProcedureSaveButton,10);
		waitForElementToBeClickable_Click(applicationProcedureSaveOkButton,10);
	}
}


