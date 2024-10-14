package Product;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateProductAndDelete {

	public static void main(String[] args) throws Throwable {
		//Step1:- Create a object of FileInStream class(connection of physical file path)
		FileInputStream fis = new FileInputStream("./src/test/resources/PropertiesDatas.properties");

		//step2:- load all the keys to Properties class
		Properties pro = new Properties();
		pro.load(fis);
	
		//Step3:- call keys from properties file
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
	    String PASSWORD = pro.getProperty("password");
		
	    WebDriver driver =new ChromeDriver();
	    driver.get(URL);
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		
		driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
		
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);

		//step1:- path connection
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Test_Data.xlsx");

		       //step2:- excel file in read mode
			Workbook book = WorkbookFactory.create(fis1);
			  
			//step3:- get control on sheet
			Sheet sheet = book.getSheet("Products");
			
			//step4:- get control on row
			Row row = sheet.getRow(0);
			
			//step5:- get control on cell
			Cell cell = row.getCell(0);
			
			//step6:-fetching the cell value
			String ProName = cell.getStringCellValue()+ranNum;

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
