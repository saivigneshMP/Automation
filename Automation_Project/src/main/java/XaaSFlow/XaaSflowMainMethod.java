package XaaSFlow;
import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.ApplicationPage;
import pageobjects.LoginScreen;
import pageobjects.Marketizer;
import pageobjects.SubscriptionPlanPage;
import pageobjects.XaaSFlow;

public class XaaSflowMainMethod {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		LoginScreen loginscreen = new LoginScreen(driver);
		loginscreen.goTo();
		loginscreen.loginApplication("saivignesh@corenttech.com", "Corent@123$#");
		ApplicationPage applicationPage = new ApplicationPage(driver);
		applicationPage.applicationCreation();
		XaaSFlow  xaasflow = new XaaSFlow(driver);
		xaasflow.createArtifact();
		xaasflow.createApplicationProcedure();
		Marketizer marketizer = new Marketizer(driver);
		marketizer.createMarketizer();
		SubscriptionPlanPage subscriptionPlanPage = new SubscriptionPlanPage(driver);
		subscriptionPlanPage.createSubcriptionPlan();
	}

}
