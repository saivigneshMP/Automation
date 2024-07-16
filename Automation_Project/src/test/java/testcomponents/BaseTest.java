package testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;

	public WebDriver initializeDriver() throws Exception {
		Properties p = new Properties();
		FileInputStream f = new FileInputStream(
				"C:\\Users\\saivignesh\\git\\Automation\\Automation_Project\\src\\main\\java\\resources\\GlobalData.properties");
		p.load(f);
		String browserName = p.getProperty("browser");

		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
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
	
	public List<HashMap<String, String>> getJsonData(String file) throws IOException {
		String JsonCOntent = FileUtils.readFileToString(new File(file),StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(JsonCOntent, new TypeReference<List<HashMap<String, String>>>() {

		});
		return data;
	}
		
	public String getScreenShot (String testCaseName ,WebDriver driver) throws IOException {
		TakesScreenshot ts =  (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		
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
