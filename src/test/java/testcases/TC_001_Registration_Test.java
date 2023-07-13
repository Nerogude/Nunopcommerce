package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.RegistrationPage;
import pageobjects.RegistrationValidationPage;
import testBase.BaseClass;

public class TC_001_Registration_Test extends BaseClass{
	
	
	
	@Test
	public void test_RegistrationTest() {
		
		try {
			
		log.info("***TC_001_Registration_Test Begins***");
			
		HomePage hp = new HomePage(driver);
		log.info("***select prefered currency***");
		hp.selectCurrency();
		
		
		hp.clickRegisterLink();
		log.info("***register link clicked***");
		
		RegistrationPage rp = new RegistrationPage(driver);
		
		log.info("***enter user details***");
		rp.setFirstName("zeroc");
		rp.setLastName("xerp");
		rp.selectDayOfBirth();
		rp.setEmail(generateRandomString()+"@mail.com");
		rp.setPassword("qwerty");
		rp.setConfirmPassword("qwerty");
		rp.clickRegisterBtn();
		
		RegistrationValidationPage reg = new RegistrationValidationPage(driver);
		reg.confirmMessage();
		Assert.assertEquals("Your registration completed", reg.confirmMessage());
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
	
}
