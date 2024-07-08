package XaaSFlow;
import java.awt.AWTException;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.ApplicationPage;
import pageobjects.LoginScreen;
import pageobjects.Marketizer;
import pageobjects.SubscriptionPlanPage;
import pageobjects.XaaSFlow;
import testcomponents.BaseClass;


public class XaaSflowMainMethod extends BaseClass {
    
	
	public void fullTest() {
		// TODO Auto-generated method stub
		LoginScreen loginscreen = launchApplication();
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
