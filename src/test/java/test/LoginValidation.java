package test;

import org.testng.annotations.Test;

import application.ApplicationMethods;
import orangeCRMpages.HomePage;
import orangeCRMpages.LoginPage;

public class LoginValidation extends ApplicationMethods{
	LoginPage lp;
	HomePage hp;

	@Test
	public void testORMtitle() {
		lp = new LoginPage();
		lp.validateLoginTitle();
		log.info("Compeleted the First validation");
		

	}



	@Test
	public void validate_LoginFlow() {
		lp = new LoginPage();
		lp.login("Admin", "admin123");
		log.info("Compeleted the Second  validation");

	}
	
	
	
	@Test
	public void validate_pageChaining() {
		lp = new LoginPage();
		hp=new HomePage();
		lp.login("Admin", "admin123");
		pause(3000);
		hp.fill_rep();
		log.info("Compeleted the Third validation");

		

	}
}
