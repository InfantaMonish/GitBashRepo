package Product;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import ObjectRepository.VtigerLoginPage;

public class CreateProductAndDeleteUsingUtility {
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
			
			//navigating the product table
			driver.findElement(By.xpath("//a[text()='Products']")).click();
			
//driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='Product Name']/../preceding-sibling::td//input[@type='checkbox']")).click();

			//Dynamic Xpath
driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+ProName+"']/../preceding-sibling::td//input[@type='checkbox']")).click();			

driver.findElement(By.xpath("//input[@value='Delete']")).click();
Webdriver_Utility wlib = new Webdriver_Utility();
wlib.alertAccept(driver);
//driver.switchTo().alert().accept();

List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));

boolean flag=false;
 	 for(WebElement prdName1:productList)
 {
	String actData = prdName1.getText();
	if(actData.contains(ProName))
	{
		flag=true;
		break;
	}
 }
if(flag)
{
	System.out.println("product data is deleted");
}
else
{
	System.out.println("product data not deleted");
}
Thread.sleep(2000);
//wlib.alertAccept(driver);
driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
driver.findElement(By.linkText("Sign Out")).click();
}

}
