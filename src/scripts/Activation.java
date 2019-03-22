package scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import generics.Excel;
import generics.Utility;
import pom.ActivationPage;
import pom.CreateEntitlementPage;
import pom.LoginPage;

public class Activation extends BaseTest {

	//@Test
	public void VerifyingSearchFunctionalityofActivation() throws InterruptedException, IOException {

		String xlPath = "./excel/testData.xlsx";
		String sheet = "Logintosems";
		String un = Excel.getCellValue(xlPath, sheet, 1, 0);
		String pw = Excel.getCellValue(xlPath, sheet, 1, 1);
		String filePath = "./excel/Orderdtls.xlsx";
		String sheetName = "Sheet1";

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
			System.out.println("SEMS loaded");

		} else {
			System.out.println("SEMS not  loaded");

		}

		Thread.sleep(5000);
		ActivationPage a = new ActivationPage(driver);
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook Wb = null;
		Wb = new XSSFWorkbook(inputStream);
		Sheet WSheet = Wb.getSheet(sheetName);

		int rowCount = WSheet.getLastRowNum() - WSheet.getFirstRowNum();

		for (int i = 1; i < rowCount + 1; i++) {

			Row row = WSheet.getRow(i);

			String orderType = null;
			String value = null;

			orderType = row.getCell(0).getStringCellValue();
			value = row.getCell(1).getStringCellValue();
			a.ClickActivationLink();
			Thread.sleep(3000);
			a.ClickOptiontoSelect();
			Thread.sleep(1000);

			a.SelectTypeofOrder(orderType);

			Thread.sleep(1000);
			a.EnterTexttoSearch(value);
			Thread.sleep(1000);
			a.ClickSerachIcon();
			String xp = "//span[@class=\"dtDetail\"][1]";

			u.DynamicWait(xp);
			if (orderType.equalsIgnoreCase("Entitlement ID")) {
				driver.findElement(By.xpath(xp)).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[@href=\"#targetAndEntitlement\"]")).click();
				if (driver.findElement(By.xpath("//span[@class=\"entitlement-id\" and text()='" + value + "']"))
						.isDisplayed()) {
					System.out.println("Search successful for the type " + orderType);
					// break;
				}
			} else if (orderType.equalsIgnoreCase("Activation ID")) {
				if (driver.findElement(By.xpath("//span[@class=\"dtDetail\" and @title='" + value + "']"))
						.isDisplayed()) {
					System.out.println("Search successful for the type " + orderType);
				}

			} else {

				String sxpath = "//div/table[@id=\"search_result\"]//td[@class=\"center filterInputColumn\" and text()=\'"
						+ value + "']";
				if (driver.findElement(By.xpath(sxpath)).isDisplayed()) {
					System.out.println("Search successful for the type " + orderType);
				} else {
					System.out.println("Search not found");
				}

			}

			a.ClickHomeButton();
			Thread.sleep(1000);
			u.DynamicWait(Xpath);
			Wb.close();
			
		}
		driver.quit();
	}

	// ----------------------------------------------------------------------------------
	@Test
	public void VerifyingtheBasicFunctionalityofActivation() throws InterruptedException {
		String xlPath = "./excel/testData.xlsx";
		String sheet = "ActBscCheck";
		String un = Excel.getCellValue(xlPath, sheet, 1, 0);
		String pw = Excel.getCellValue(xlPath, sheet, 1, 1);
		String orderType = Excel.getCellValue(xlPath, sheet, 1, 2);
		String value = Excel.getCellValue(xlPath, sheet, 1, 3);
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
			System.out.println("SEMS loaded");

		} else {
			System.out.println("SEMS not  loaded");

		}
		Thread.sleep(5000);
		ActivationPage a = new ActivationPage(driver);
		a.ClickActivationLink();
		Thread.sleep(2000);
		a.ClickOptiontoSelect();
		Thread.sleep(1000);
		a.SelectTypeofOrder(orderType);
		Thread.sleep(1000);
		a.EnterTexttoSearch(value);
		Thread.sleep(1000);
		a.ClickSerachIcon();
		String xp = "//span[@class=\"dtDetail\"][1]";
		u.DynamicWait(xp);
		driver.findElement(By.xpath("//span[@class=\"dtDetail\" and @title='" + value + "']")).click();
		if (driver.findElement(By.xpath("//*[@id=\"activation-detail\"]")).isDisplayed()) {
			System.out.println("Activation basic info details are displayed");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href=\"#activationHistory\"]")).click();
		String hxpath = "//table//span[@class=\"accord-icon\"]";
		u.DynamicWait(hxpath);
		if (driver.findElement(By.xpath("//table/tbody[@id=\"activationHistoryTbody\"]")).isDisplayed()) {
			System.out.println("Activation history info details are displayed");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href=\"#targetAndEntitlement\"]")).click();
		if (driver.findElement(By.xpath("//*[@id=\"targetAndEntitlement\"]")).isDisplayed()) {
			System.out.println("Target and Entitlement  info details are displayed");
		}
	}

	/// --------------------------------------------------------------------------------------------
	//@Test
	public void VerifyingthedownloadingOfrighttousedoc() throws InterruptedException {
		String xlPath = "./excel/testData.xlsx";
		String sheet = "ActBscCheck";
		String un = Excel.getCellValue(xlPath, sheet, 1, 0);
		String pw = Excel.getCellValue(xlPath, sheet, 1, 1);
		String orderType = Excel.getCellValue(xlPath, sheet, 1, 2);
		String value = Excel.getCellValue(xlPath, sheet, 1, 3);
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
			System.out.println("SEMS loaded");

		} else {
			System.out.println("SEMS not  loaded");

		}
		Thread.sleep(5000);
		ActivationPage a = new ActivationPage(driver);
		a.ClickActivationLink();
		Thread.sleep(2000);
		a.ClickOptiontoSelect();
		Thread.sleep(1000);
		a.SelectTypeofOrder(orderType);
		Thread.sleep(1000);
		a.EnterTexttoSearch(value);
		Thread.sleep(1000);
		a.ClickSerachIcon();
		String xp = "//span[@class=\"dtDetail\"][1]";
		u.DynamicWait(xp);
		driver.findElement(By.xpath("//span[@class=\"dtDetail\" and @title='" + value + "']")).click();
		if (driver.findElement(By.xpath("//*[@id=\"activation-detail\"]")).isDisplayed()) {
			System.out.println("Activation basic info details are displayed");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class=\"downloadSoftware js_download software_download\"]")).click();
		Thread.sleep(5000);
		// boolean val = u.isFileDownloaded("C:\\Users\\vkumar459\\Downloads\\", "Right
		// To Use Document.pdf");
		// if (val) {
		// System.out.println("file downloaded succefully");
		// } else {
		// System.out.println("File not downloaded");
		// }

		Assert.assertTrue(u.isFileDownloaded("C:\\Users\\vkumar459\\Downloads\\", "Right To Use Document.pdf"),
				"File downloaded successfully");
		u.DeleteFile("C:\\Users\\vkumar459\\Downloads\\", "Right To Use Document.pdf");
	}
	
	/// --------------------------------------------------------------------------------------------
	//@Test
		public void VerifyingActivationinfofunctionality() throws InterruptedException {
			String xlPath = "./excel/testData.xlsx";
			String sheet = "ActBscCheck";
			String un = Excel.getCellValue(xlPath, sheet, 1, 0);
			String pw = Excel.getCellValue(xlPath, sheet, 1, 1);
			String orderType = Excel.getCellValue(xlPath, sheet, 1, 2);
			String value = Excel.getCellValue(xlPath, sheet, 1, 3);
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
				System.out.println("SEMS loaded");

			} else {
				System.out.println("SEMS not  loaded");

			}
			Thread.sleep(5000);
			ActivationPage a = new ActivationPage(driver);
			a.ClickActivationLink();
			Thread.sleep(2000);
			a.ClickOptiontoSelect();
			Thread.sleep(1000);
			a.SelectTypeofOrder(orderType);
			Thread.sleep(1000);
			a.EnterTexttoSearch(value);
			Thread.sleep(1000);
			a.ClickSerachIcon();
			String xp = "//span[@class=\"dtDetail\"][1]";
			u.DynamicWait(xp);
			driver.findElement(By.xpath("//span[@class=\"dtDetail\" and @title='" + value + "']")).click();
			if (driver.findElement(By.xpath("//*[@id=\"activation-detail\"]")).isDisplayed()) {
				System.out.println("Activation basic info details are displayed");
			}
			if (a.Actvtndtls()) {
				System.out.println("Activation details are displayed");
			}
			else {
				System.out.println("Activation details are not displayed");
			}
			a.ClickEditBtn();
			Thread.sleep(2000);
			a.EnterRehostCount();
			a.EntertextNote();
			a.ClickSaveBtn();
		}
}
