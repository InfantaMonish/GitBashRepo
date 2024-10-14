package Product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import ObjectRepository.HomePage;
import ObjectRepository.VtigerLoginPage;

public class CreateProductAndDeleteUsingPOM {
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
}}
