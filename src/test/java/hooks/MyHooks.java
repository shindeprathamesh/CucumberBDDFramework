package hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testbase.TestBase;

public class MyHooks extends TestBase {

	public static WebDriver driver;

	@Before
	public void setUp() {
		
		System.setProperty("webdriver."+config.getSystemPropertyBrowser()+".driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getImplicitWait()) , TimeUnit.SECONDS);
		
		
	}

	@After
	public void tearDown(Scenario scenario) {
		
		 if (scenario.isFailed()) {
		      // Take a screenshot...
		      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		      scenario.attach(screenshot, "image/png", scenario.getName()); // ... and embed it in the report.
		    }
		driver.quit();
	}

	
	
	public static WebDriver getDriver() {
		
		return driver;
	}
	
	

}
