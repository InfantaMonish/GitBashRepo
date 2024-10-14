package Campaigns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.ValidationAndVerification;
import ObjectRepository.VtigerLoginPage;
import ObjectRepository.WindowSwitingToProductPage;

public class CreateCampaignWithProductUsingPOM {
	public static void main(String[] args) throws Throwable {
		File_Utility flib = new File_Utility();
		 Webdriver_Utility wlib = new Webdriver_Utility();
		 Java_Utility jlib = new Java_Utility();
		 Excel_Utility elib = new Excel_Utility();
		
		 WebDriver driver;
		 String BROWSER = flib.getKeyAndValuePair("browser");
		 if(BROWSER.equalsIgnoreCase("cHRoMe"))
		 {
			  driver=new ChromeDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("fireFox"))
		 {
			 driver=new FirefoxDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("edge"))
		 {
			 driver=new EdgeDriver();
		 }
		 else 
			 
		 {
			 driver=new ChromeDriver();
		 }
		 String URL = flib.getKeyAndValuePair("url");
			String USERNAME = flib.getKeyAndValuePair("username");
			String PASSWORD = flib.getKeyAndValuePair("password");
		
wlib.windowMaximize(driver);
wlib.pageToLoad(driver);
		
driver.get(URL);
VtigerLoginPage login = new VtigerLoginPage(driver);
login.loginToVtiger(USERNAME, PASSWORD);

HomePage home = new HomePage(driver);
int ranNumber = jlib.getRandonNum();
home.clickProLink();
CreateProductPage prdPage = new CreateProductPage(driver);
 prdPage.clickOnPlusSign();
String productData = elib.getExcelData("Products", 0, 0)+ranNumber;
prdPage.enterProductName(productData);
prdPage.clickSaveButton();
home.clickmoreLink();
home.clickCampLink();
CreateCampaignsPage campPage = new CreateCampaignsPage(driver);
campPage.clickCampPlusSign();
String campaignData = elib.getExcelData("Campaigns", 0, 0)+ranNumber;
  campPage.enterCampName(campaignData);
  campPage.clickProductPlusSign();
  wlib.windowSwitching(driver, "Products&action");
  WindowSwitingToProductPage campPrdPage = new WindowSwitingToProductPage(driver);
  campPrdPage.enterProductName(productData);
  campPrdPage.searchPrdName();
  campPrdPage.prdNamePresent(driver, productData);
  wlib.windowSwitching(driver, "Campaigns&action");
  campPage.clickOnSaveButton();
ValidationAndVerification campProdValidation = new ValidationAndVerification(driver);
campProdValidation.campData(driver, campaignData);
campProdValidation.productInCamp(driver, productData);
home.logOutFromApp();

}
}
