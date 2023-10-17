package test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

import java.time.Duration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import application.ApplicationMethods;
import frameworkdesign.*;



public class BrowserInvoke  extends ApplicationMethods{



	@Test
	public void validate() {
		ExtentTest test1 = extent.createTest("Orange ORM validation");
		takeSnap();
		log.info("Logged into Orange ORM Login page");
		pause(2000);
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		pause(2000);
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		pause(2000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		pause(2000);
		driver.findElement(By.xpath("(//*[@class='oxd-main-menu-item'])[6]")).click();
		pause(4000);
		driver.findElement(By.xpath("//*[@name='firstName']")).sendKeys("Nithin");
		pause(2000);
		driver.findElement(By.xpath("//*[@name='middleName']")).sendKeys("karthik");
		pause(2000);
		driver.findElement(By.xpath("//*[@name='lastName']")).sendKeys("SA");
		pause(10000);




	}


}


