package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpage extends Basepage {

	
	
	public Myaccountpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") 
	WebElement myaccountHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") 
	WebElement myaccountLogout;
	
	
	public void myAccountpagelogout() {
		myaccountLogout.click();
	}
	
	
	//@FindBy(xpath="//*[@id=\"column-right\"]/div/a[13]") 
	//WebElement myaclogout;
	
	
	/*// account logout 
	@FindBy(xpath="//h1[normalize-space()='Account Logout']") 
	WebElement myLogaccountHeading;
	@FindBy(xpath="//a[normalize-space()='Continue']") 
	WebElement myLogaccountlogout;
	*/
	
	//public void mlogout() {
		//myaclogout.click();
	//}
	//public void mylogoutac() {
		//myLogaccountlogout.click();
	//}
	
	/*public boolean acountLogoutexist() {
		try {
			return myLogaccountHeading.isDisplayed();
		}catch
		(Exception e) {
			return false;
		}
	}
	*/

	public boolean myaccountExist() {
		try {
		return myaccountHeading.isDisplayed();	
		}
		catch(Exception e) {
			return false;
		}	
		
	}

}
