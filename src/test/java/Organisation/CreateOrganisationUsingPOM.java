package Organisation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.VtigerLoginPage;
//@Listeners(Generic_Utility.ListenersImp.class)
public class CreateOrganisationUsingPOM extends BaseClass {
	@Test(groups = "regressionTest")
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
 home.clickOrgLink();

 CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
 orgPage.clickOrgPlusSign();
 int ranNum = jlib.getRandonNum();
 String organizationData = elib.getExcelDataUsingDataFormatter("Organization", 0, 0)+ranNum;
 String phoneNum = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
 String emailId = elib.getExcelDataUsingDataFormatter("Organization", 2, 0); 
 orgPage.orgData(organizationData, phoneNum, emailId);
 orgPage.clickOnSaveButton();
 Thread.sleep(2000);
 home.logOut(driver);
	}
}
