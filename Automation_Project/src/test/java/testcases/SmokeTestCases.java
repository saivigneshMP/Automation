package testcases;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import pageobjects.LoginScreen;

import testcomponents.BaseTest;




public class SmokeTestCases extends BaseTest  {
    
	@Test(dataProvider ="getdata", groups={"smoke"},retryAnalyzer= testcomponents.Retry.class)
	public void smoke (HashMap<String,String> input) throws Exception {
		LoginScreen loginscreen = new LoginScreen(driver);
		loginscreen.loginApplication(input.get("email"), input.get("password"));

	}
	

@DataProvider(name = "getdata")
public Object[][] getData() throws Exception {
List<HashMap<String,String>> data = getJsonData("C:\\Users\\saivignesh\\git\\Automation\\Automation_Project\\src\\test\\java\\datareader\\datas.json");
return new Object[][] {{data.get(0)}, {data.get(1)},{data.get(2)}};
	
}
}