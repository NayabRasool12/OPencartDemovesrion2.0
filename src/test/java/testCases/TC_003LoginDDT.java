package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.Dataproviders;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import testBase.BaseClass;

public class TC_003LoginDDT extends BaseClass{

	
	
	@Test(dataProvider="LoginData",dataProviderClass =Dataproviders.class )
	public void TC_003LoginDDT(String username , String password , String ex) {
	
		try {
		Homepage hp = new Homepage(driver);
		hp.clickmyaccount();
	    hp.clickmylogin();
	    
	    Loginpage lp = new Loginpage(driver);
		lp.email(username);
		lp.pass(password);
		lp.loginbutton();
		
		Myaccountpage mc = new Myaccountpage(driver);
		boolean target = mc.acountLogoutexist();
		
		if(ex.equalsIgnoreCase("valid")) {
			if(target==true) {
				mc.mlogout();
			    Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
			
		  } if(ex.equalsIgnoreCase("invalid")){
			if(target==true) {
				mc.mlogout();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		
		  }	
		}catch
		(Exception e) {
			Assert.fail();
		}
		logger.info("--- data driven test is complleted ");
	}
}
