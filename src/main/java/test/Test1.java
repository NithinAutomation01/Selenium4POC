package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='oxd-userdropdown-img']")).isDisplayed();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebElement rightclick=driver.findElement(By.xpath("(//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]"));
		action.contextClick(rightclick).perform();
		Thread.sleep(5000);
		System.out.println("rightclick is performed");
		WebElement doubleclick=driver.findElement(By.xpath("(//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[4]"));
		action.contextClick(doubleclick).perform();

		Thread.sleep(2000);
		System.out.println("Execution completed");

	}

}
