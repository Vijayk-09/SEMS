package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import scripts.BaseTest;

public class ActivationPage extends BaseTest {

	@FindBy(xpath = "//*[@id='activationDiv']/a")
	private WebElement ActLnk;

	@FindBy(xpath = "//div/span[@class=\"selecter-selected\" and  text()=\"Entitlement ID\"]")
	private WebElement DrpDwn;

	@FindBy(xpath = "//input[@id=\"searchInput\"]")
	private WebElement EntrText;

	@FindBy(xpath = "//span[@id=\"searchBtn\"]")
	private WebElement SrchBtn;

	@FindBy(xpath = "//*[@id=\"home-menu\"]/div/a")
	private WebElement HomeBtn;

	@FindBy(xpath = "//div[@class=\"activation-additional\"]")
	private WebElement Actinfdtls;

	@FindBy(xpath = "//*[@id=\"edit-activation\"]")
	private WebElement EditBtn;

	@FindBy(xpath = "//*[@id=\"newReCount\"]")
	private WebElement RehostCont;

	@FindBy(xpath = "//*[@id=\"noteTextArea\"]")
	private WebElement TextNot;

	@FindBy(xpath = "//*[@id=\"save-activation\"]")
	private WebElement SaveBtn;

	public ActivationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public boolean Actvtndtls() {
		boolean flag = false;
		boolean val = Actinfdtls.isDisplayed();
		if (val) {
			return flag = true;
		}
		return flag;
	}

	public void ClickSaveBtn() {
		SaveBtn.click();
	}

	public void EntertextNote() {
		TextNot.sendKeys("testing the rehost count edit");
	}

	public void ClickEditBtn() {
		EditBtn.click();
	}

	public void EnterRehostCount() {
		String text = new String(RehostCont.getText());
		RehostCont.clear();
		int no =0 ;
		if(text== null || text.isEmpty()) {
			no = no + 1;
		} else {
			no = Integer.parseInt(text) + 1;
		}
		RehostCont.sendKeys(String.valueOf(no));
	}

	public void ClickHomeButton() {
		HomeBtn.click();
	}

	public void ClickActivationLink() {
		ActLnk.click();
	}

	public void ClickOptiontoSelect() {

		DrpDwn.click();
	}

	public void SelectTypeofOrder(String orderType) {
		if (orderType.equalsIgnoreCase("Entitlement ID")) {
			driver.findElement(By.xpath("//div/span[@class=\"selecter-item selected\" and @title='" + orderType + "']"))
					.click();

		} else {
			driver.findElement(By.xpath("//div/span[@title='" + orderType + "']")).click();
		}
	}

	public void EnterTexttoSearch(String SearchType) {
		EntrText.sendKeys(SearchType);
	}

	public void ClickSerachIcon() {
		SrchBtn.click();
	}
}
