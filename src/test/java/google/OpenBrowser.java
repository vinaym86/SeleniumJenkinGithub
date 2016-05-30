package google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenBrowser {
	WebDriver driver;

	// WebElement element;

	@Test
	public void assertgoogle() {

		// element//

		driver = new FirefoxDriver();
		driver.get("https://www.google.co.in");

		String title = driver.getTitle();

		System.out.println("The Page title will be : " + title);

		// //input[@value='Google Search']

		if (driver.findElements(By.xpath("//input[@value='Google Searchk']"))
				.size() != 0) {
			System.out.println("Element is Present");
		} else {
			System.out.println("Element is Absent");
		}

		driver.quit();

	}

}