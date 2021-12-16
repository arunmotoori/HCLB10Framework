package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.SearchPage;
import resources.Base;

public class SearchTest extends Base {
	
	public WebDriver driver;
	
	@Test(priority=1)
	public void searchWithAnExistingProduct() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.enterProductNameIntoSearchBox(prop.getProperty("existingproduct"));
		
		homePage.clickOnSearchButton();
		
		SearchPage searchPage = new SearchPage(driver);
		
		Assert.assertTrue(searchPage.isProductDisplayed());
		
	}
	
	@Test(priority=2)
	public void searchWithNonExistingProduct() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.enterProductNameIntoSearchBox(prop.getProperty("nonexistingproduct"));
		
		homePage.clickOnSearchButton();
		
		SearchPage searchPage = new SearchPage(driver);
		
		Assert.assertTrue(searchPage.getMessage().equals(prop.getProperty("noproductmessage")));
		
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}

}
