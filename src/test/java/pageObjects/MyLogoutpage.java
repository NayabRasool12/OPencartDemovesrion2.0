package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyLogoutpage extends Basepage {

	public MyLogoutpage(WebDriver driver) {
		super(driver);
	}
	
	
	//myLogoutaccount page
	
	@FindBy(xpath="//h1[normalize-space()='Account Logout']") 
	WebElement myaccountHeading;
	
}
