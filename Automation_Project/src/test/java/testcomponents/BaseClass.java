package testcomponents;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LoginScreen;

public class BaseClass {
	public WebDriver driver;

	public WebDriver initializeDriver() throws Exception {
		Properties p = new Properties();
		FileInputStream f = new FileInputStream(
				"C:\\Users\\saivignesh\\git\\Automation\\Automation_Project\\src\\main\\java\\resources\\GlobalData.properties");
		p.load(f);
		String browserName = p.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get(p.getProperty("URL"));
		} 
		  else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			driver.get(p.getProperty("URL"));

		} 
		  else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			WebDriver driver = new EdgeDriver();
			driver.get(p.getProperty("URL"));
		

		}
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public LoginScreen launchApplication() throws Exception {
		driver = initializeDriver();
		LoginScreen loginscreen = new LoginScreen(driver);
		loginscreen.goTo();
		return loginscreen;
		
	}

}
