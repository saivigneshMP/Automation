package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abstractcomponents.AbstractComponent;

public class ApplicationPage extends AbstractComponent {

	WebDriver driver;

	public ApplicationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@id='profilecreationForm:create_application_profile_sidebar']")
	WebElement CreateApplicationProfile;

	@FindBy(xpath = "//input[@id='addArtifactForm:displayname']")
	WebElement displayname;

	@FindBy(xpath = "//input[@id='addArtifactForm:downloadurl']")
	WebElement downloadURL;

	@FindBy(xpath = "//textarea[@id='addArtifactForm:description']")
	WebElement Description;
	
	@FindBy(xpath = "//button[@id='addArtifactForm:saveartifact']")
	WebElement saveArtifact;

	By radiobutton = By.xpath("//input[@id='radio-3']/following-sibling::label");
	By SaaSOperation = By.xpath("//a[@id='menuCLinkForm:appsaascCmdLink']");
	By SetupProfile = By.xpath("//button[@id='Open_create_application_profile_btn']");
	By RadioButton = By.xpath("//input[@id='radio-3']/following-sibling::label");
	By clickApplicationProfile = By
			.xpath("//button[@id='selectsaasprofileFlowForm:create_application_profile_btn_slid1']");
	By GroupName = By.xpath("//input[@id='profilecreationForm:existingClustername_input']");
	By applicationName = By.xpath("//input[@id='profilecreationForm:existingAppusername_input']");
	By profileName = By.xpath("//input[@id='profilecreationForm:profilename']");
	By AddArtifactButton = By.xpath("//button[@id='applicationArtifaactAddEditForm:createartifact']");

	public void applicationCreation() throws InterruptedException {
		waitForElementToBeClickable_Click(SaaSOperation, 60);
		waitForElementToBeClickable_Click(SetupProfile, 30);
		waitForElementToBeClickable_Click(RadioButton, 20);
		waitForElementToBeClickable_Click(clickApplicationProfile, 10);
		fluentWait_SendKeys(GroupName, "groupname" + random());
		fluentWait_SendKeys(applicationName, "applicationname" + random());
		fluentWait_SendKeys(profileName, "profilename" + random());
		Thread.sleep(10000);
		String ApplicationName = fluentWait_GetAttribute(applicationName, "value");
		String ProfileName = fluentWait_GetAttribute(profileName, "value");
		if (ApplicationName.isEmpty()) {
			fluentWait_SendKeys(applicationName, "applicationname" + random());
		} else {

		}
		if (ProfileName.isEmpty()) {
			fluentWait_SendKeys(profileName, "profilename" + random());
		} else {

		}
		String applicationNameNew = fluentWait_GetAttribute(applicationName, "value");
		CreateApplicationProfile.click();
	}

	public void createArtifact() {
		waitForElementToBeClickable_Click(AddArtifactButton, 20);
		displayname.sendKeys("test" + random());
		downloadURL.sendKeys("https://automationzone.qaops.smartersaas.com:9000/surpaas/#");
		Description.sendKeys("test" + random());
		saveArtifact.click();
	}
}
