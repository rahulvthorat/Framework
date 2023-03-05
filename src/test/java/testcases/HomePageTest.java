package testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Log;
import base.Base;

public class HomePageTest extends Base {

	@BeforeClass
	public void setup() throws InterruptedException {
		Reporter.log("============================Browser Session Started=======================", true);
		initialization();
	}

	@Test
	public void VerifyTitle() {
		String expectedtitle = "Facebook – log in or sign up"; // Wrong title
		Log.startTestCase("verifyTitle");
		String actualtitle = driver.getTitle();
		Assert.assertEquals(actualtitle, expectedtitle, "Title is not matched");
		Log.endTestCase("verifyTitle is Completed");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		Reporter.log("========================Browser Session End==========================", true);
	}
}
