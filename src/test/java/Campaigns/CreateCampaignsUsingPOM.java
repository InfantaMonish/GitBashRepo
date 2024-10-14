package Campaigns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.HomePage;
import ObjectRepository.ValidationAndVerification;
import ObjectRepository.VtigerLoginPage;


@Listeners(Generic_Utility.ExtendsReportsImp.class)
public class CreateCampaignsUsingPOM extends BaseClass {
	@Test
	public void main(String[] args) throws Throwable {
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
        home.clickmoreLink();
        home.clickCampLink();
     
        CreateCampaignsPage campPage = new CreateCampaignsPage(driver);
        campPage.clickCampPlusSign();
        
        //Assert.fail("im failing the script");
        int ranNum = jlib.getRandonNum();
        
        String campaginName = elib.getExcelDataUsingDataFormatter("Campaigns", 0, 0)+ranNum;
        campPage.enterCampName(campaginName);
        
        campPage.clickOnSaveButton();

        ValidationAndVerification campvalidate = new ValidationAndVerification(driver);
        campvalidate.campData(driver, campaginName);
    
	   home.logOut(driver);
	}
}
