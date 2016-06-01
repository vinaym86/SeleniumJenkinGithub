package anybrowserbyproperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonFunctions {
	public static WebDriver driver = null;
	public boolean browserAlreadyOpen = false;
	public static Properties SYSPARAM = null;

	// To Initialize .properties file.
	public void initData() throws IOException {
		SYSPARAM = new Properties();
		FileInputStream Ist = new FileInputStream(
				System.getProperty("user.dir")
						+ "//src//test//java//anybrowserbyproperty//SYSPARAM.properties");
		SYSPARAM.load(Ist);
	}

	public void initBrowser() {
		// Check If browser Is already opened during previous test execution.
		if (!browserAlreadyOpen) {
			// Read value of 'BrowserToTestIn' key from SYSPARAM.properties
			// file.
			// If key value Is MMF then execute If statement
			// If key value Is CHRM then execute else statement.
			if (SYSPARAM.getProperty("BrowserToTestIn").equals("MFF")) {
				driver = new FirefoxDriver();
			} else if (SYSPARAM.getProperty("BrowserToTestIn").equals("CHRM")) {
				// Write lines to open chrome browser.
				
				System.setProperty("webdriver.chrome.driver","./src/main/resources/browser_files/chromedriver");
				driver = new ChromeDriver();
			}
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			
			//String Url = SYSPARAM.getProperty("url");
			driver.get(SYSPARAM.getProperty("url"));
			// At last browserAlreadyOpen flag will becomes true to not open new
			// browser when start executing next test.

			browserAlreadyOpen = true;
		}
	}

	// To Close Browser
	public void closeBrowser() {
		driver.quit();
		browserAlreadyOpen = false;
	}

}
