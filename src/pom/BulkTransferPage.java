package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BulkTransferPage {
	//test

	@FindBy(id = "uploadBulkTransferOrdersDiffCRSid")
	private WebElement BlkTrnsLnk;

	@FindBy(id = "selectFileBtn")
	private WebElement SelFiltoUp;

	@FindBy(id = "uploadBtn")
	private WebElement TrnsFrUpBtn;
	
	public BulkTransferPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ClickBlkTrnsUpldLnk() {
		BlkTrnsLnk.click();
	}
	public void ClickSelFilUpBtn() {
		SelFiltoUp.click();
	}
	public void ClickBlkTrnsUpldBtn() {
		TrnsFrUpBtn.click();
	}
}
