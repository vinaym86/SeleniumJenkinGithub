package anybrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonBrowserFunction {

	public CommonBrowserFunction() {
		// TODO Auto-generated constructor stub
	}

	public static void startbrowser(String browser_Name, WebDriver driver) {

		String url = "https://www.google.co.in";

		if (browser_Name.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);

		} else if (browser_Name.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"./src/main/resources/browser_files/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);

		}

	}

}
