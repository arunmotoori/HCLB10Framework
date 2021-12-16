package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css="a[title='My Account']")
	private WebElement myAccount;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(css="button[class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	public void clickOnMyAccountDropMenu() {
		
		myAccount.click();
		
	}
	
	public void selectLoginOption() {
		
		loginOption.click();
		
	}
	
	public void enterProductNameIntoSearchBox(String productName) {
		
		searchBoxField.sendKeys(productName);
		
	}
	
	public void clickOnSearchButton() {
		
		searchButton.click();
		
	}
	
}
