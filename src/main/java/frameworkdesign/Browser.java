package frameworkdesign;

import org.openqa.selenium.WebDriver;

public interface Browser {
	
	public void BrowserInvocation(String browser, String url,String mode);
	
	public void ReportSetup(String environment,String browser,String Tester_name);
	
	public void takeSnap();
	
	public void pause(int time);
	
	
		

}
