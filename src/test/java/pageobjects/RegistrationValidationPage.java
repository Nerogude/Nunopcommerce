package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationValidationPage extends BasePage{

	public RegistrationValidationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css=".result")
	WebElement validationMessage;
	
	public String confirmMessage() {
		try {
			return validationMessage.getText();
		}catch(Exception e) {
			return (e.getMessage());
		}
		
	}

}
