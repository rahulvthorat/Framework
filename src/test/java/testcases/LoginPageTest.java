package testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.Log;

public class LoginPageTest extends Base {

	LoginPage loginpage;
	HomePage homepage;

	@BeforeClass
	public void setup() throws InterruptedException {
		Reporter.log("============================Browser Session Started=======================", true);
		initialization();
	}

	@Test(priority = 1)
	public void VerifyUrl() throws Throwable {
		String expectedURL = "https://www.facebook.com/";
		Log.startTestCase("VerifyUrl");
		// Actions.getCurrentURL(driver);
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL, "URL is not matched");
		Log.endTestCase("Url verification Completed");
	}

	@Test(priority = 2)
	public void VerifyTitle() {
		String expectedtitle = "Facebook – log in or sign up";
		Log.startTestCase("verifyTitle");
		String actualtitle = driver.getTitle();
		Assert.assertEquals(actualtitle, expectedtitle, "Title is not matched");
		Log.endTestCase("verifyTitle is Completed");
	}

	@Test(priority = 3)
	public void Login(String username, String password) {
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
	}

	@Test(dependsOnMethods = { "Login" })
	public void LogOutisDispalyed() {
		homepage.checklogoutIsdisplayed();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		Reporter.log("========================Browser Session End==========================", true);
	}
}
