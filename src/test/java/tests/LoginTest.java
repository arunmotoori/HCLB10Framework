package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	public WebDriver driver = null;
	
	@BeforeMethod
	public void setup() throws IOException {
		
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
	}
	
	@Test(priority=1)
	public void loginWithValidCredentials() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickOnMyAccountDropMenu();
		
		homePage.selectLoginOption();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterEmailAddress(prop.getProperty("validemail"));
		
		loginPage.enterPassword(prop.getProperty("validpassword"));
	
		loginPage.clickOnLoginButton();
		
		AccountPage accountPage = new AccountPage(driver);
		
		Assert.assertTrue(accountPage.isEditYourAccountInfomationOptionPresent());
	
	}
	
	@Test(priority=2)
	public void loginWithInvalidCredentials() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickOnMyAccountDropMenu();
		
		homePage.selectLoginOption();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterEmailAddress("amotoori75abcd"+getTimeStamp()+"@gmail.com");
		
		loginPage.enterPassword(prop.getProperty("invalidpassword"));
	
		loginPage.clickOnLoginButton();
		
		Assert.assertTrue(loginPage.getWarningMessage().contains(prop.getProperty("expectedwarningmessage")));
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}

}
