package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends Basepage {

	//constructor
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	
	//loctaors
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement myfirstname;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement mylastname;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement myemail;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement myTelephone;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement mypassword;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement mypaswconform;
	@FindBy(xpath="//input[@name='agree']")
	WebElement mycheckpolicy;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement myclickbutton;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement confmsg;
	
	 @FindBy(xpath="//a[normalize-space()='Continue']") 
	 WebElement continues;
	
	
	//action methods
	
	public void myname(String name) {
		myfirstname.sendKeys(name);
	}
	
	public void mylastname(String lastname) {
		
		mylastname.sendKeys(lastname);
	}
	
	public void myemail(String email) {
		myemail.sendKeys(email);
	}
	
	public void mytel(String tel) {
		myTelephone.sendKeys(tel);
	}
	
	public void mypass(String pasw) {
		mypassword.sendKeys(pasw);
	}
	
	
	public void myconfrompass(String confpass) {
		mypaswconform.sendKeys(confpass);
	}
	
	public void mypolicy() {
		mycheckpolicy.click();;
	}
	
	public void mybutton() {
		myclickbutton.submit();
	}
	
	public void continuee() {
		continues.click();
	}
	
	
	
	public String getconformationMsg() {
		try {
			return(confmsg.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
	}
		
}



