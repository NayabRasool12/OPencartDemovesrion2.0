package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import testBase.BaseClass;



public class TC_002LoginTest extends BaseClass {

	
	
	@Test(groups={"sanity","Master"})
	public void LoginTest() {
		
         try {
       logger.info("--------verifying homepage -------");
		Homepage hp = new Homepage(driver);
		hp.clickmyaccount();
	    hp.clickmylogin();
	    
	    
	    logger.info("---------verifying login ---------");
		Loginpage lp = new Loginpage(driver);
		lp.email(p.getProperty("email"));
		lp.pass(p.getProperty("password"));
		lp.loginbutton();
		
		Myaccountpage mp = new Myaccountpage(driver);
		boolean status = mp.myaccountExist();
		 Assert.assertTrue(status);
		 mp.myAccountpagelogout();
	   }catch
         (Exception e) {
		   Assert.fail();
	   }
	
	}
}