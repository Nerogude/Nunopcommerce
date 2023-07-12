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
		
		HomePage hp = new HomePage(driver);
		hp.selectCurrency();
		hp.clickRegisterLink();
		
		RegistrationPage rp = new RegistrationPage(driver);
		rp.setFirstName("zeroc");
		rp.setLastName("xerp");
		rp.selectDayOfBirth();
		rp.setEmail("qaws@mail.com");
		rp.setPassword("qwerty");
		rp.setConfirmPassword("qwerty");
		rp.clickRegisterBtn();
		
		RegistrationValidationPage reg = new RegistrationValidationPage(driver);
		reg.confirmMessage();
		Assert.assertEquals("Your registration completed", reg.confirmMessage());
	}
	
	
}
