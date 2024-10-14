package Organisation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import ObjectRepository.VtigerLoginPage;

public class CreateOrganisationUsingUtility {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();

		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

		driver.get(URL);
		//driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToVtiger(USERNAME, PASSWORD);
		
		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();

		int ranNum = jlib.getRandonNum();

		String OrgName = elib.getExcelData("Organization", 0, 0) + ranNum;
		String PhnNum = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
		String email = elib.getExcelDataUsingDataFormatter("Organization", 2, 0);

		driver.findElement(By.name("accountname")).sendKeys(OrgName);

		driver.findElement(By.id("phone")).sendKeys(PhnNum);

		driver.findElement(By.id("email1")).sendKeys(email);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(2000);
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();

		if (actData.contains(OrgName)) {
			System.out.println("Organization name is created");
		} else {
			System.out.println("Organization name not created");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}

