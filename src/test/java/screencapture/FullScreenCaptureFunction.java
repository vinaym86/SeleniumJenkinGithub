package screencapture;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * 
 * Sample Program = "SampleProgram.java"
 * The methods will automatically create folder in the default directory
 *
 */
public class FullScreenCaptureFunction {

	public static void capture_full_screen(String screenshotName) {
		try {
			Robot robot = new Robot();
			String format = "png";
			// String fileName = "FullScreenshot." + format;

			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit()
					.getScreenSize());
			BufferedImage screenFullImage = robot
					.createScreenCapture(screenRect);
			// ImageIO.write(screenFullImage, format, new File(fileName));

			// making directory in the current project directory
			File theDir = new File("./Screenshots");
			theDir.mkdir();

			ImageIO.write(screenFullImage, format, new File("./Screenshots/"
					+ screenshotName + ".png"));

			System.out.println("A full screenshot saved!");
		} catch (AWTException | IOException ex) {
			System.err.println(ex);
		}
	}

	public static void capture_browser_screen(WebDriver driver,
			String screenshotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(source, new File("./Screenshots/"
					+ screenshotName + ".png"));

			System.out.println("Screenshot taken");
		} catch (Exception e) {

			System.out.println("Exception while taking screenshot "
					+ e.getMessage());
		}
	}

	public static void capture_by_robot_class(String screenshotName)
			throws Exception, Exception {

		BufferedImage image = new Robot().createScreenCapture(new Rectangle(
				Toolkit.getDefaultToolkit().getScreenSize()));

		// making directory in the current project directory
		File theDir = new File("./Screenshots");
		theDir.mkdir();

		// This will store screenshot on Specific location
		ImageIO.write(image, "png", new File("./Screenshots/" + screenshotName
				+ ".png"));

	}

}