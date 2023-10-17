package application;

import java.util.Scanner;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.Status;

import orangeCRMpages.LoginPage;
import seleniumbase.Base;

public class ApplicationMethods extends Base {

	String browser;
	String Mode;
	String base_url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeTest
	public void extentconfig() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Is execution to be performed in Headless mode? Y or N ");
		Mode = sc.next();
		if(Mode.equalsIgnoreCase("Y")) {
			System.out.println("Enter the Environment");
			String environment=sc.next();
			System.out.println("Enter the Tester Name who is initiating the testing");
			String qa_tester=sc.next();
			log.info("Execution is done in   "+environment+" by tester   :"+qa_tester+" in  Headless Mode");
			browser="chrome";
			ReportSetup(environment,browser,qa_tester);
			log.info("Reporting initiated for the Headless Execution");

		}
		else {
			System.out.println("Enter the Browser to run the Testcases . Following are the testable browsers chrome,ie,firefox...");
			browser = sc.next();
			System.out.println("Enter the Environment");
			String environment=sc.next();
			System.out.println("Enter the Tester Name who is initiating the testing");
			String qa_tester=sc.next();
			log.info("Execution is done in"+environment+" by tester"+qa_tester+". Browser tested is "+browser);
			ReportSetup(environment, browser,qa_tester);
			log.info("Reporting initiated");
		}
	}

		@BeforeMethod
		public void beforeMethod() {
			if(Mode.equalsIgnoreCase("Y")) {
				
			}
			BrowserInvocation(browser,base_url,Mode);
			takeSnap();


		}


		@AfterMethod(alwaysRun =true)
		public void afterMethod() throws InterruptedException {
			driver.close();
			log.info("driver is closed for the current test instance");
		}
		@AfterTest
		public void teardown() {
			driver.quit();
			log.info("driver is quit");
			extent.flush();
			log.info("Extent report is generated .... Check the url /Selenium4POC/test-output/myReport.html");

		}


	}
