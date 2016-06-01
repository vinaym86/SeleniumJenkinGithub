package screencapture;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SampleProgram {

	public static WebDriver driver;

	@Test
	public void test_screen_capture_function() throws Exception {

		driver = new FirefoxDriver();
		driver.get("https://www.google.co.in");
		FullScreenCaptureFunction.capture_full_screen("full_screen");
		FullScreenCaptureFunction.capture_browser_screen(driver, "newscreen");
		FullScreenCaptureFunction.capture_by_robot_class("robot_class_image");

	}

}
