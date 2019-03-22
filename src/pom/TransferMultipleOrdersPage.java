package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferMultipleOrdersPage{

	@FindBy(id = "transferMultipleOrders")
	private WebElement TrnsMulOrdsLnk;

	@FindBy(id = "listOfHpOrderNumber")
	private WebElement LstOfOrdsEdtBx;

	@FindBy(xpath = "//*[@id=\"entInfo\"]/table/tbody/tr/td/div/span[2]")
	private WebElement TrnsUsrsSel;

	@FindBy(xpath = "//span[@title= 'Yes']")
	private WebElement TrnsUsrsSelVal;

	@FindBy(id = "endCustomerCRSID")
	private WebElement EnCoAddId;

	@FindBy(id = "transferBtn")
	private WebElement TrnsBtn;

	public TransferMultipleOrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ClickTransMulOrdsLnk() {
		TrnsMulOrdsLnk.click();
	}
	public void EnterListOforders(String Orders) {
		LstOfOrdsEdtBx.sendKeys(Orders);
	}
	public void ClickTransferUserSel() {
		TrnsUsrsSel.click();
	}
	public void SelTransferUserVal() {
		TrnsUsrsSelVal.click();
	}
	public void EnterEndcoAddressId(String AddressId) {
		EnCoAddId.sendKeys(AddressId);
		EnCoAddId.click();
		EnCoAddId.sendKeys(Keys.TAB);
		
	}
	public void ClickTransferBtn() {
		TrnsBtn.click();
	}
}
