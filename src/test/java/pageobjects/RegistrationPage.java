package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="#FirstName")
	WebElement firstNameField;
	
	@FindBy(css="#LastName")
	WebElement lastNameField;
	
	@FindBy(css="select[name='DateOfBirthDay']")
	WebElement dayOfBirth;
	
	@FindBy(css="#Email")
	WebElement emailField;
	
	@FindBy(css="#Password")
	WebElement passwordField;
	
	@FindBy(css="#ConfirmPassword")
	WebElement confirmPasswordField;
	
	@FindBy(css="#register-button")
	WebElement registerBtn;
	
	public void setFirstName(String fName) {
		firstNameField.sendKeys(fName);
	}
	public void setLastName(String lName) {
		lastNameField.sendKeys(lName);
	}
	public void selectDayOfBirth() {
		Select day = new Select(dayOfBirth);
		day.selectByVisibleText("28");
	}
	public void setEmail(String email) {
		emailField.sendKeys(email);
	}
	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}
	public void setConfirmPassword(String password) {
		confirmPasswordField.sendKeys(password);
	}
	public void clickRegisterBtn() {
		registerBtn.click();
	}
	

}
