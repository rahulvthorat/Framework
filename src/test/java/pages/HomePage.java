package pages;

import org.openqa.selenium.By;
import base.Base;

public class HomePage extends Base {

	private By id_logout = By.id("logout");

	public void checklogoutIsdisplayed() {
		driver.findElement(id_logout).isDisplayed();
	}
}
