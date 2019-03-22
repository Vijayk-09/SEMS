package generics;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import scripts.BaseTest;

public class Utility extends BaseTest {

	public WebElement DynamicWait(String dxpath) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dxpath)));
		return element;
	}

	public int generateRandomNumber() {
		Random r = new Random();
		int num = r.nextInt();
		return num;
	}

	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName))
				return flag = true;
		}

		return flag;
	}

	public void DeleteFile(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName))
				dir_contents[i].delete();
		}

	}
}
