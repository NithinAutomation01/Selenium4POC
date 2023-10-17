package orangeCRMpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumbase.Base;

public class LoginPage extends Base {

	@FindBy(name="username")
	WebElement un;

	@FindBy(name="password")
	WebElement pass;

	@FindBy(xpath="//*[@type='submit']")
	WebElement submit;

	public LoginPage() {
		PageFactory.initElements(driver,this);
	}



	public String validateLoginTitle() {
		return driver.getTitle();
	}


	public HomePage login(String username,String password) {

		un.sendKeys(username);
		pass.sendKeys(password);
		pause(2000);
		submit.click();
		return new HomePage();

	}




}
