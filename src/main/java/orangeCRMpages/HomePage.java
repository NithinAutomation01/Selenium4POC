package orangeCRMpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumbase.Base;

public class HomePage extends Base {
	
	
	@FindBy(xpath="(//*[@class='oxd-main-menu-item'])[6]")
	WebElement click_profile;
	
	
	@FindBy(xpath="//*[@name='firstName']")
	WebElement FN;
	
	@FindBy(xpath="//*[@name='middleName']")
	WebElement MN;
	
	@FindBy(xpath="//*[@name='lastName']")
	WebElement LN;
	
	

	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	
	public void fill_rep() {
		click_profile.click();
		pause(2000);
		FN.sendKeys("First Name");
		MN.sendKeys("Middle Name");
		LN.sendKeys("Last Name");
		
		
	}

}
