package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import testBase.BaseClass;


public class TC_001RegistrationTest extends  BaseClass {

	
	
	@Test(groups= {"regression","Master"})
	public void TestRegistartion() throws InterruptedException {
		
		logger.info(" welcome to login registration page");
		
		try {
		
		logger.info(" welcome to HOME PAGE  ");	
		Homepage hp = new Homepage(driver);
		hp.clickmyaccount();
		logger.info(" ---- click my MYACCOUNT ------");
		hp.clickreg();
		
		logger.info(" ---- click my REGISTERACCOUNTPAGE ------ ");
		AccountRegistrationPage ar = new AccountRegistrationPage(driver);
		ar.myname(randomString().toLowerCase());
		ar.mylastname(randomString().toLowerCase());
		ar.myemail(randomString()+"@gmail.com");
		
		String pass = randomAlphaNum();
		ar.mypass(pass);
		ar.myconfrompass(pass);
		ar.mypolicy();
		ar.mytel(randomnum());
		ar.mybutton();
	

		String status = ar.getconformationMsg();
		Assert.assertEquals(status,"Your Account Has Been Created!","account will be miss matched ");
		}
	
		catch(Exception e) {
			logger.info("fail");
			logger.info(" completed ");
			Assert.fail();
			logger.info(" ---- STATUS IS FAIL ------- ");
		}
		
		logger.info(" ---- COMPLETED THE REGISTARTION ACCOUNT FINALLY-------   ");

    }
	
}