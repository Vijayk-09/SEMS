package scripts;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.eclipse.jetty.util.Loader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.util.log.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

import generics.Excel;

import generics.Utility;
import pom.BulkTransferPage;
import pom.CreateEntitlementPage;
import pom.LoginPage;
import pom.Search_Result;
import pom.TransferMultipleOrdersPage;
import pom.UploadEntitlemnt;

public class Entitlment extends BaseTest

{

	//@Test
	public void CreatingEntitlement() throws InterruptedException {

		String xlPath = "./excel/testData.xlsx";
		String sheet = "Logintosems";
		String un = Excel.getCellValue(xlPath, sheet, 1, 0);
		String pw = Excel.getCellValue(xlPath, sheet, 1, 1);

		String sheet1 = "Entitlment";

		String POrderNo = Excel.getCellValue(xlPath, sheet1, 1, 0);
		String OrderType = Excel.getCellValue(xlPath, sheet1, 1, 1);
		String AccNo = Excel.getCellValue(xlPath, sheet1, 1, 2);
		String ProductName = Excel.getCellValue(xlPath, sheet1, 1, 3);
		String Quantity = Excel.getCellValue(xlPath, sheet1, 1, 4);

		LoginPage l = new LoginPage(driver);
		l.setUsername(un);
		l.setPassword(pw);
		l.clickLogin();
		String Xpath = "//*[@id=\"content\"]/header/div[1]/div/span/h1";
		Utility u = new Utility();
		String OrderNo = "O-" + String.valueOf(u.generateRandomNumber());
		u.DynamicWait(Xpath);
		WebElement element = u.DynamicWait(Xpath);
		boolean status = element.isDisplayed();
		if (status) {
			System.out.println("SEMS loaded");
			// logger.log(LogStatus.INFO, "Sems home page loaded");
		} else {
			System.out.println("SEMS not  loaded");

			// logger.log(LogStatus.INFO, "Sems home page not loaded");
		}

		Thread.sleep(5000);
		CreateEntitlementPage c = new CreateEntitlementPage(driver);

		c.ClickEntitlment();
		Thread.sleep(5000);
		c.CreateEntitlment();
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pon")));

		System.out.println("test");
		c.EnterOrderNo(OrderNo);
		Thread.sleep(1000);
		c.EnterPOrderNo(POrderNo);
		Thread.sleep(1000);
		c.SelectOrderType();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@title= '" + OrderType + "']")).click();
		Thread.sleep(2000);
		c.EnterAccNo(AccNo);
		Thread.sleep(2000);
		c.ProdEnter(ProductName);
		Thread.sleep(2000);
		// c.ProdSerchClk();
		String Xpath1 = "//*[@class='add']";
		Utility u1 = new Utility();
		u1.DynamicWait(Xpath1);
		Thread.sleep(2000);
		c.AddClk();
		Thread.sleep(2000);
		c.RemovIconClk();
		Thread.sleep(2000);
		c.EnterQty(Quantity);
		Thread.sleep(2000);
		c.Submit();
		WebDriverWait wait3 = new WebDriverWait(driver, 90);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + OrderNo + "']")));
		boolean flag = driver.findElement(By.xpath("//a[text()='" + OrderNo + "']")).isDisplayed();

		if (flag) {
			System.out.println("order page is loaded");

		} else {
			System.out.println("Order page is not  loaded");

		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='" + OrderNo + "']")).click();
		WebDriverWait wait4 = new WebDriverWait(driver, 90);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='dtDetail']")));
		boolean flag1 = driver.findElement(By.xpath("//tbody/tr/td[text()='" + OrderNo + "'][1]")).isDisplayed();
		if (flag1) {
			System.out.println("URL loaded");

		} else {
			System.out.println("URL loaded");

		}
	}

	// @Test
	public void UploadEntitlementFileCrate() throws InterruptedException, IOException {
		String xlPath = "./excel/testData.xlsx";
		String sheet = "Logintosems";
		String un = Excel.getCellValue(xlPath, sheet, 1, 0);
		String pw = Excel.getCellValue(xlPath, sheet, 1, 1);

		LoginPage l = new LoginPage(driver);
		l.setUsername(un);
		l.setPassword(pw);
		l.clickLogin();
		String Xpath = "//*[@id=\"content\"]/header/div[1]/div/span/h1";
		Utility u = new Utility();
		u.DynamicWait(Xpath);
		WebElement element = u.DynamicWait(Xpath);
		boolean status = element.isDisplayed();
		if (status) {
			System.out.println("Sems Home page is loaded......");
		} else {
			System.out.println("Sems Home page is not loaded");
		}

		Thread.sleep(5000);
		CreateEntitlementPage c = new CreateEntitlementPage(driver);
		c.ClickEntitlment();
		Thread.sleep(2000);
		c.ClkUpEntlnk();
		Thread.sleep(3000);
		UploadEntitlemnt u1 = new UploadEntitlemnt(driver);
		u1.clikUploadEnRdBtn();
		u1.SelUpBtn();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Selenium\\Sems\\winsecurity.exe");
		Thread.sleep(2000);
		u1.ClkUpBtn();
		Thread.sleep(3000);
	} 

	// @Test
	public void UploadUpdateEntitlementStatus() throws InterruptedException, IOException {
		String xlPath = "./excel/testData.xlsx";
		String sheet = "Logintosems";
		String un = Excel.getCellValue(xlPath, sheet, 1, 0);
		String pw = Excel.getCellValue(xlPath, sheet, 1, 1);

		LoginPage l = new LoginPage(driver);
		l.setUsername(un);
		l.setPassword(pw);
		l.clickLogin();
		String Xpath = "//*[@id=\"content\"]/header/div[1]/div/span/h1";
		Utility u = new Utility();
		u.DynamicWait(Xpath);
		WebElement element = u.DynamicWait(Xpath);
		boolean status = element.isDisplayed();
		if (status) {
			System.out.println("Sems Home page is loaded......");
		} else {
			System.out.println("Sems Home page is not loaded");
		}

		Thread.sleep(5000);
		CreateEntitlementPage c = new CreateEntitlementPage(driver);
		c.ClickEntitlment();
		Thread.sleep(2000);
		c.ClkUpEntlnk();
		Thread.sleep(3000);
		UploadEntitlemnt u1 = new UploadEntitlemnt(driver);
		u1.clikUpUpEntStsBtn();
		Thread.sleep(3000);
		u1.SelUpStsBtn();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Selenium\\Sems\\winsecurity.exe");
		Thread.sleep(2000);
		u1.ClkUpStsBtn();
		Thread.sleep(3000);
	}

	// @Test
	public void CreateEntitlementSearch() throws InterruptedException {

		String xlPath = "./excel/testData.xlsx";
		String sheet = "Logintosems";
		String un = Excel.getCellValue(xlPath, sheet, 1, 0);
		String pw = Excel.getCellValue(xlPath, sheet, 1, 1);

		LoginPage l = new LoginPage(driver);
		l.setUsername(un);
		l.setPassword(pw);
		l.clickLogin();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String sheet1 = "CrtEntSrch";
		String FileName = Excel.getCellValue(xlPath, sheet1, 1, 0);
		String FromDate = String.valueOf((formatter.format(date)));
		String ToDate = String.valueOf((formatter.format(date)));
		String Xpath = "//*[@id=\"content\"]/header/div[1]/div/span/h1";
		Utility u = new Utility();
		u.DynamicWait(Xpath);
		WebElement element = u.DynamicWait(Xpath);
		boolean status = element.isDisplayed();
		if (status) {
			System.out.println("Sems Home page is loaded......");
		} else {
			System.out.println("Sems Home page is not loaded");
		}
		Thread.sleep(5000);
		CreateEntitlementPage c = new CreateEntitlementPage(driver);
		c.ClickEntitlment();
		Thread.sleep(2000);
		Search_Result s = new Search_Result(driver);
		s.ClkSrchLnk();
		Thread.sleep(5000);
		s.ClkCrtEnt();
		Thread.sleep(1000);
		s.EnterFileName(FileName);
		s.EnterFrmDate(FromDate);
		Thread.sleep(1000);
		s.EnterToDate(ToDate);
		Thread.sleep(1000);
		s.ClickSearch();
	}

	// @Test
	public void UpdateStatusSearch() throws InterruptedException {

		String xlPath = "./excel/testData.xlsx";
		String sheet = "Logintosems";
		String un = Excel.getCellValue(xlPath, sheet, 1, 0);
		String pw = Excel.getCellValue(xlPath, sheet, 1, 1);

		LoginPage l = new LoginPage(driver);
		l.setUsername(un);
		l.setPassword(pw);
		l.clickLogin();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String sheet1 = "Upsts";
		String FileName = Excel.getCellValue(xlPath, sheet1, 1, 0);
		String FromDate = String.valueOf((formatter.format(date)));
		String ToDate = String.valueOf((formatter.format(date)));
		String Xpath = "//*[@id=\"content\"]/header/div[1]/div/span/h1";
		Utility u = new Utility();
		u.DynamicWait(Xpath);
		WebElement element = u.DynamicWait(Xpath);
		boolean status = element.isDisplayed();
		if (status) {
			System.out.println("Sems Home page is loaded......");
		} else {
			System.out.println("Sems Home page is not loaded");
		}
		Thread.sleep(5000);
		CreateEntitlementPage c = new CreateEntitlementPage(driver);
		c.ClickEntitlment();
		Thread.sleep(2000);
		Search_Result s = new Search_Result(driver);
		s.ClkSrchLnk();
		Thread.sleep(5000);
		s.ClickUpdateStatus();
		Thread.sleep(1000);
		s.EnterFileName(FileName);
		s.EnterFrmDate(FromDate);
		Thread.sleep(1000);
		s.EnterToDate(ToDate);
		Thread.sleep(1000);
		s.ClickSearch();
	}

	// @Test
	public void TransferMultipleOrders() throws InterruptedException {

		String xlPath = "./excel/testData.xlsx";
		String sheet = "Logintosems";
		String un = Excel.getCellValue(xlPath, sheet, 1, 0);
		String pw = Excel.getCellValue(xlPath, sheet, 1, 1);

		LoginPage l = new LoginPage(driver);
		l.setUsername(un);
		l.setPassword(pw);
		l.clickLogin();

		String sheet1 = "TrnsfrMulOrds";
		String Orders = Excel.getCellValue(xlPath, sheet1, 1, 0);
		String AddressId = Excel.getCellValue(xlPath, sheet1, 1, 1);
		Utility u = new Utility();
		String xpath = "//*[@id=\"content\"]/header/div[1]/div/span/h1";
		u.DynamicWait(xpath);
		WebElement element = u.DynamicWait(xpath);
		boolean status = element.isDisplayed();
		if (status) {
			System.out.println("Sems Home page is loaded......");
		} else {
			System.out.println("Sems Home page is not loaded");
		}
		Thread.sleep(5000);
		CreateEntitlementPage c = new CreateEntitlementPage(driver);
		c.ClickEntitlment();
		Thread.sleep(2000);
		TransferMultipleOrdersPage t = new TransferMultipleOrdersPage(driver);
		t.ClickTransMulOrdsLnk();
		Thread.sleep(5000);
		t.EnterListOforders(Orders);
		t.ClickTransferUserSel();
		Thread.sleep(1000);
		t.SelTransferUserVal();
		t.EnterEndcoAddressId(AddressId);
		Thread.sleep(3000);
		t.ClickTransferBtn();

	}

	// @Test
	public void BulkTransferUpload() throws InterruptedException, IOException {

		String xlPath = "./excel/testData.xlsx";
		String sheet = "Logintosems";
		String un = Excel.getCellValue(xlPath, sheet, 1, 0);
		String pw = Excel.getCellValue(xlPath, sheet, 1, 1);

		LoginPage l = new LoginPage(driver);
		l.setUsername(un);
		l.setPassword(pw);
		l.clickLogin();

		Utility u = new Utility();
		String xpath = "//*[@id=\"content\"]/header/div[1]/div/span/h1";
		u.DynamicWait(xpath);
		WebElement element = u.DynamicWait(xpath);
		boolean status = element.isDisplayed();
		if (status) {
			System.out.println("Sems Home page is loaded......");
		} else {
			System.out.println("Sems Home page is not loaded");
		}
		Thread.sleep(5000);
		CreateEntitlementPage c = new CreateEntitlementPage(driver);
		c.ClickEntitlment();
		Thread.sleep(2000);
		BulkTransferPage blkpg = new BulkTransferPage(driver);
		blkpg.ClickBlkTrnsUpldLnk();
		Thread.sleep(3000);
		blkpg.ClickSelFilUpBtn();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Selenium\\Sems\\BlkTrnsUpld.exe");
		Thread.sleep(2000);
		blkpg.ClickBlkTrnsUpldBtn();

	}

}
