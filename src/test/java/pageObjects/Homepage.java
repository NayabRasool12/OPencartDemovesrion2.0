package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {

	public Homepage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@title ='My Account']") 
	WebElement myacc;
	
	@FindBy(xpath="//a[normalize-space()='Register']") 
	WebElement myreg;
	
	 @FindBy(xpath="//a[normalize-space()='Login']") 
	 WebElement mylogin;
	
	
	
	public void clickmyaccount() {
		myacc.click();
	}
	
	
	
	public void clickreg() {
		myreg.click();
	}
	
	public void clickmylogin() {
		mylogin.click();
	}
	
	
}
