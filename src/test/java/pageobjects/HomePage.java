package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="#customerCurrency")
	WebElement currencyDropdown;
	
	@FindBy(css=".ico-register")
	WebElement registerLinkText;
	
	public void selectCurrency() {
		Select currency = new Select(currencyDropdown);
		currency.selectByVisibleText("Euro");
	}
	public void clickRegisterLink() {
		registerLinkText.click();
	}
	
	

}
