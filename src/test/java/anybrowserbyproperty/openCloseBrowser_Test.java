package anybrowserbyproperty;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class openCloseBrowser_Test extends CommonFunctions {
	@BeforeTest
	public void StartBrowser_NavURL() throws IOException {
		initData();
	}

	@AfterTest
	public void ClosingBrowser() {
		closeBrowser();
	}

	@Test
	public void OpenBrowserAndURL() {
		initBrowser();
		//driver.get("http://only-testing-blog.blogspot.in/");
	}
}