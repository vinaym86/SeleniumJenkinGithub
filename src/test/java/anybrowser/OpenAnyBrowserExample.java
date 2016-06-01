package anybrowser;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class OpenAnyBrowserExample {

	WebDriver driver;

	@Test(priority = 0)
	public void open_chrome_browser() {

		CommonBrowserFunction.startbrowser("chrome", driver);

	}

	@Test(priority = 1)
	public void open_firefox_browser() {

		CommonBrowserFunction.startbrowser("firefox", driver);

	}

}
