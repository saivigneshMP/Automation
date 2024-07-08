package testcases;
import org.testng.annotations.Test;
import pageobjects.LoginScreen;

import testcomponents.BaseTest;



public class SmokeTestCases extends BaseTest   {
    
	@Test(groups={"smoke"})
	public void smoke () throws Exception {
		LoginScreen loginscreen = new LoginScreen(driver);
		loginscreen.loginApplication("saivignesh@corenttech.com", "Corent@123$#");

	}
	
		
	}


