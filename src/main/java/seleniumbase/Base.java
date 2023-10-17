package seleniumbase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import frameworkdesign.Browser;

public class Base implements Browser {
	public static RemoteWebDriver driver;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static Logger log = LogManager.getLogger(Base.class);


	public void BrowserInvocation(String browser, String url,String mode) {

		if(mode.equalsIgnoreCase("Y")) {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("headless=true");
			driver = new ChromeDriver(options);
			log.info("Exection started In headless Mode");
			driver.navigate().to(url);
			log.info("Navigated Successfully to the base Url "+url);
			driver.manage().window().maximize();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}

		else if(browser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
			log.info("Chrome Driver is successfully loaded");
			driver.navigate().to(url);
			log.info("Navigated Successfully to the base Url"+url);
			driver.manage().window().maximize();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}

		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			log.info("FireFox Driver is successfully loaded");
			driver.navigate().to(url);
			log.info("Navigated Successfully to the base Url"+url);
			driver.manage().window().maximize();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		else if (browser.equalsIgnoreCase("ie")) {

			driver= new EdgeDriver();
			log.info("Edge Driver is successfully loaded");
			driver.navigate().to(url);
			log.info("Navigated Successfully to the base Url"+url);
			driver.manage().window().maximize();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		}


	}





	public void ReportSetup(String environment,String browser,String Tester_name) {
		extent = new ExtentReports();
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/myReport.html");




		extent.setSystemInfo("Environment",environment);
		extent.setSystemInfo("Browser", browser);
		extent.setSystemInfo("Tester Name", Tester_name);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Extent reporter");
		extent.attachReporter(spark);


	}





	public void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}

	}

	public static WebElement waitUntilClickable(WebDriver driver,By locator) {
		return new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));

	}
}


