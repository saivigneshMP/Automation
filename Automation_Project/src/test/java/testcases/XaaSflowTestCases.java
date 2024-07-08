package testcases;
import org.testng.annotations.Test;
import pageobjects.ApplicationPage;
import pageobjects.LoginScreen;
import pageobjects.Marketizer;
import pageobjects.SubscriptionPlanPage;
import pageobjects.XaaSFlow;
import testcomponents.BaseTest;



public class XaaSflowTestCases extends BaseTest   {
    
	
	@Test
	public void xaasFlow() throws Exception {
		LoginScreen loginscreen = new LoginScreen(driver);
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


