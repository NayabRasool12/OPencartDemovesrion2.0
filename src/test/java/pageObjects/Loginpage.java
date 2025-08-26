package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage {

	
	public Loginpage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(xpath="//input[@id='input-email']") 
	WebElement myemail;
	
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement mypass;
	
     @FindBy(xpath="//input[@value='Login']") 
	 WebElement myloginbutton;
	
	
	 public void email(String email) {
		 myemail.sendKeys(email);
	 }
	 
	 public void pass(String pass) {
		 
		 mypass.sendKeys(pass);
	 }
	
	 public void loginbutton() {
		 myloginbutton.click();
	 }
	 
	
}
 