package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import scripts.BaseTest;

public class Search_Result extends BaseTest {

	@FindBy(id = "upload-Statussearch")
	private WebElement SrchResltLnk;

	@FindBy(xpath = "//*[@id=\"replace-body\"]/center/div/label[1]/span")
	private WebElement CrEntSrch;

	@FindBy(xpath = "//*[@id=\"replace-body\"]/center/div/label[2]/span")
	private WebElement UpStsSrch;

	@FindBy(id = "entitlementFileName")
	private WebElement FlNmEdtBx;

	@FindBy(id = "fromDate")
	private WebElement FrmDtEdtBx;

	@FindBy(id = "toDate")
	private WebElement EndDtEdtBx;

	@FindBy(id = "searchButton")
	private WebElement SrchBtn;

	public Search_Result(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void ClkSrchLnk() {
		SrchResltLnk.click();
	}

	public void ClkCrtEnt() {

		CrEntSrch.click();
		// Actions action = new Actions(driver);
		// action.moveToElement(CrEntSrch).click().build().perform();

	}

	public void EnterFileName(String FileName) {
		FlNmEdtBx.sendKeys(FileName);
	}

	public void EnterFrmDate(String FromDate) {
		FrmDtEdtBx.sendKeys(FromDate);
		FrmDtEdtBx.click();
		FrmDtEdtBx.sendKeys(Keys.ENTER);
	}

	public void EnterToDate(String ToDate) {
		EndDtEdtBx.sendKeys(ToDate);
	}

	public void ClickSearch() {
		SrchBtn.click();
	}

	public void ClickUpdateStatus() {
		UpStsSrch.click();
	}

}
