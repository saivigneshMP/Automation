package testcomponents;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LoginScreen;

public class BaseTest {
	public WebDriver driver;

	public WebDriver initializeDriver() throws Exception {
		Properties p = new Properties();
		FileInputStream f = new FileInputStream(
				"C:\\Users\\saivignesh\\git\\Automation\\Automation_Project\\src\\main\\java\\resources\\GlobalData.properties");
		p.load(f);
		String browserName = p.getProperty("browser");

		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(p.getProperty("URL"));
		} else if (browserName.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(p.getProperty("URL"));

		} else if (browserName.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(p.getProperty("URL"));

		}
		driver.manage().window().maximize();
		return driver;

	}

	@BeforeMethod(alwaysRun = true)
	public void launchApplication() throws Exception {
		driver = initializeDriver();
	}

	@AfterMethod(alwaysRun = true)
      public void quit() {
		driver.quit();
	}

}
