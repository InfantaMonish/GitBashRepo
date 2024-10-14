package TestNGPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;

public class DataProviderEx3OrgUsingxl {
	@Test(dataProvider="readData")
	
	public void Organisation(String orgname, String phnNum, String email) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
			driver.findElement(By.name("accountname")).sendKeys(orgname);
			driver.findElement(By.id("phone")).sendKeys(phnNum);
			driver.findElement(By.id("email1")).sendKeys(email);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
			driver.findElement(By.linkText("Sign Out")).click();
			driver.quit();
		
	}
@DataProvider
	
	public Object[][] readData() throws Throwable
	{
		Object[][] objArr = new Object[3][3];
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandonNum();
		
		Excel_Utility elib = new Excel_Utility();
		
		 String orgname = elib.getExcelDataUsingDataFormatter("Organization", 0, 0)+ranNum;
		 String phnNum = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
		 String email = elib.getExcelDataUsingDataFormatter("Organization", 2, 0);
		
		//Random ran = new Random();
		//int ranNum = ran.nextInt(1000);
		
		objArr[0][0]="sss"+ranNum;
		objArr[0][1]="14544666";
		objArr[0][2]="add@gmail.com";
		
		objArr[1][0]="sas"+ranNum;
		objArr[1][1]="145446664";
		objArr[1][2]="add1@gmail.com";
		
		objArr[2][0]="ssa"+ranNum;
		objArr[2][1]="145446264";
		objArr[2][2]="avd1@gmail.com";
		return objArr;
		
		
	
}

}
