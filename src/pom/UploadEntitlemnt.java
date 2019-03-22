package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadEntitlemnt {

	@FindBy(xpath = "//*[@id=\"replace-body\"]/div[1]/input[1]")
	private WebElement UpLdCrEnt;

	@FindBy(xpath = "//*[@id=\"replace-body\"]/div[1]/input[2]")
	private WebElement UpUpEntSts;

	@FindBy(xpath = "//*[@id=\"selectFileBtn\"]")
	private WebElement SelFilToUpBtn;

	@FindBy(xpath = "//*[@id=\"selectFilestatusBtn\"]")
	private WebElement SelFilToUpStsBtn;

	@FindBy(id = "uploadBtn")
	private WebElement upload;

	@FindBy(id = "uploadstatusBtn")
	private WebElement uploadsts;

	public UploadEntitlemnt(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clikUploadEnRdBtn() {
		UpLdCrEnt.click();
	}

	public void clikUpUpEntStsBtn() {
		UpUpEntSts.click();
	}

	public void SelUpBtn() {
		SelFilToUpBtn.click();
	}

	public void SelUpStsBtn() {
		SelFilToUpStsBtn.click();
	}

	public void ClkUpBtn() {
		upload.click();
	}

	public void ClkUpStsBtn() {
		uploadsts.click();
	}

}
