package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	@FindBy(id = "username")
	private WebElement unTB;

	@FindBy(id = "password")
	private WebElement pwTB;

	@FindBy(xpath = "//input[@name='submit']")
	private WebElement logon;

	@FindBy(xpath = "//*[@id=\"content\"]/header/div[1]/div/span/h1")
	private WebElement wlcmsg;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setUsername(String un) {
		unTB.sendKeys(un);
	}

	public void setPassword(String pw) {
		pwTB.sendKeys(pw);
	}

	public void clickLogin() {
		logon.click();
	}

	public void verifyMsg() {
		Assert.assertTrue(wlcmsg.isDisplayed());
	}
}
