package Product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import ObjectRepository.VtigerLoginPage;

public class CreateProductUsingUtility {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		
        File_Utility file = new File_Utility();
		String URL = file.getKeyAndValuePair("url");
		String USERNAME = file.getKeyAndValuePair("username");
		String PASSWORD = file.getKeyAndValuePair("password");
		
	    driver.get(URL);
		//driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToVtiger(USERNAME, PASSWORD);
		
		driver.findElement(By.linkText("Products")).click();
		
		driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandonNum();

		Excel_Utility elib = new Excel_Utility();
		String ProName = elib.getExcelData("Products", 0, 0) + ranNum;
		System.out.println(ProName);


			driver.findElement(By.name("productname")).sendKeys(ProName);
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			Thread.sleep(2000);
String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

if(actData.contains(ProName))
{
System.out.println("Product name is created");
}
else
{
System.out.println("Product name not created");
}

driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
driver.findElement(By.linkText("Sign Out")).click();
}

}
