package scripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.naming.ldap.ExtendedRequest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.Configuration;
import org.testng.xml.XmlTest;

import com.aventstack.extentreports.ExtentReporter;

import generics.Utility;

public class BaseTest {

	public static WebDriver driver;

	@BeforeMethod
	public void preCondition(XmlTest x) throws IOException {
		// String v = x.getParameter("browser");
		String v = "chrome";
		// Reporter.log(v, true);
		if (v.equals("chrome")) {
			// -------------------CHROME----------------------
			System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
			driver = new ChromeDriver();

			// -----------------IE-----------------------
			// System.setProperty("webdriver.ie.driver", "C:/Selenium/IEDriverServer.exe");
			// DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			// caps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
			// driver=new InternetExplorerDriver(caps);

			driver.manage().window().maximize();

		} else {
			System.setProperty("webdriver.gecko.driver", "C:/Selenium/geckodriver.exe");
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("marionette", false);
			driver = new FirefoxDriver(desiredCapabilities);
			driver.manage().window().maximize();

		}

		driver.navigate().to("https://semsui-sit-llb.itcs.softwaregrp.net/semsui/home");

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		boolean status = element.isDisplayed();
		if (status) {
			System.out.println("URL loaded");

		} else {
			System.out.println("URL not loaded");

		}

	}

	@AfterMethod
	public void postCondition() {

		//driver.close();

		// driver.get("C:\\Selenium\\Sems\\Reports\\Sems_Automation_Report.html");
	}
}
