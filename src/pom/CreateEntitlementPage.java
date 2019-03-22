package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import scripts.Entitlment;

public class CreateEntitlementPage {

	@FindBy(xpath = "//*[@id='entitlementDiv']/a")
	private WebElement mainent;

	@FindBy(id = "create-entitlement")
	private WebElement crtent;

	@FindBy(id = "eon")
	private WebElement orderno;

	@FindBy(id = "pon")
	private WebElement porderno;

	@FindBy(xpath = "//*[@id='entInfo']/table/tbody/tr[3]/td/div/span[2]")
	private WebElement selct;

	@FindBy(xpath = "//*[@id='entNodeDesc']")
	private WebElement nots;

	@FindBy(id = "txtAccountID")
	private WebElement accId;

	@FindBy(id = "search-product-input")
	private WebElement prodserch;

	@FindBy(xpath = "//*[@id='search-product-input-span']/span")
	private WebElement Prodctsercclk;

	@FindBy(xpath = ".//*[@class='add']")
	private WebElement Addprod;

	@FindBy(xpath = "//*[@id=\"search-product-input-span\"]/span[@class='icon-remove-sign']")
	private WebElement remvicon;

	@FindBy(xpath = "//*[@id=\"productTable\"]/tbody/tr[2]/td[7]/input")
	private WebElement qty;

	@FindBy(id = "submitBtn")
	private WebElement SubmitBtn;

	@FindBy(xpath = "//*[@id=\"upload-entitlement\"]")
	private WebElement UpLdEntLnk;

	public CreateEntitlementPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void ClickEntitlment() {
		mainent.click();
	}

	public void CreateEntitlment() {
		crtent.click();
	}

	public void ClkUpEntlnk() {
		UpLdEntLnk.click();
	}

	public void EnterOrderNo(String OrderNo) {
		orderno.sendKeys(Keys.TAB);
		orderno.clear();
		orderno.sendKeys(OrderNo);
	}

	public void EnterPOrderNo(String POrderNo) {
		porderno.sendKeys(POrderNo);
	}

	public void SelectOrderType() {

		selct.click();

	}

	public void EnterNotes() {
		nots.sendKeys(Keys.TAB);
		nots.clear();
		nots.sendKeys("this is for testing");

	}

	public void EnterAccNo(String AccNo) throws InterruptedException {
		accId.sendKeys(AccNo);
		accId.click();
		accId.sendKeys(Keys.TAB);
		Thread.sleep(3000);
	}

	public void ProdEnter(String ProductName) {
		prodserch.sendKeys(ProductName);
		prodserch.sendKeys(Keys.ENTER);

	}

	public void ProdSerchClk() {
		Prodctsercclk.click();
	}

	public void AddClk() {
		Addprod.click();
	}

	public void RemovIconClk() {
		remvicon.click();
	}

	public void EnterQty(String Quantity) {
		qty.sendKeys(Quantity);

	}

	public void Submit() {
		SubmitBtn.click();
	}

}
