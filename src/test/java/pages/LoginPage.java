package pages;

import org.openqa.selenium.By;
import base.Base;

public class LoginPage extends Base {

	private By id_username = By.id("name");
	private By id_password = By.id("password");
	private By id_login = By.id("login");

	public void enterUsername(String username) {
		driver.findElement(id_username).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(id_password).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(id_login).click();
	}

}
