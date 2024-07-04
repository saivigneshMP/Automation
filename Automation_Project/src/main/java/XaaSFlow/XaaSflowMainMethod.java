package XaaSFlow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.ApplicationPage;
import pageobjects.LoginScreen;

public class XaaSflowMainMethod {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		LoginScreen loginscreen = new LoginScreen(driver);
		loginscreen.goTo();
		loginscreen.loginApplication("saivignesh@corenttech.com", "Corent@123$#");
		ApplicationPage applicationPage = new ApplicationPage(driver);
		applicationPage.applicationCreation();
		applicationPage.createArtifact();
	}

}
