package Campaigns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import ObjectRepository.VtigerLoginPage;

public class CreateCampaignsUsingUtility {
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
		
		//VtigerLoginPage login = new VtigerLoginPage(driver);
		//login.getUserTextField().sendKeys(USERNAME);
		//login.getPasswordtextField().sendKeys(PASSWORD);
		//login.getLoginButton().click();
		
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToVtiger(USERNAME, PASSWORD);

		WebElement moreLink = driver.findElement(By.linkText("More"));
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();

		Thread.sleep(2000);
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandonNum();

		Excel_Utility elib = new Excel_Utility();
		String campData = elib.getExcelData("Campaigns", 0, 0) + ranNum;
		System.out.println(campData);

		driver.findElement(By.name("campaignname")).sendKeys(campData);
		driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();

		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();

		if (actData.contains(campData)) {
			System.out.println("campaigns name is created");
		} else {
			System.out.println("campaigns name is not created");
		}

		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	}
}
