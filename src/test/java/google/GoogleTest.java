package google;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	private WebDriver driver;

	@Test
	public void googleAssertPass() {

		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile("default");
		driver = new FirefoxDriver(ffprofile);

		// driver = new FirefoxDriver();
		driver.get("http://google.com");

		Boolean isFound = IsElementPresent(driver,
				By.cssSelector("input[value*='Google Search']"));

		Assert.assertTrue(isFound);
	}

	@Test
	public void googleAssertFail() {

		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile("default");
		driver = new FirefoxDriver(ffprofile);

		// driver = new FirefoxDriver();
		driver.get("http://google.com");

		Boolean isFound = IsElementPresent(driver,
				By.cssSelector("input[value*='Googl Search']"));

		Assert.assertTrue(isFound);
	}

	private Boolean IsElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}