package DDT;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class Insert_dataToProperties_File {

	public static void main(String[] args) throws Throwable {
		Properties pro1=new Properties();
		pro1.setProperty("browser","chrome");
		pro1.setProperty("url","http://localhost:8888/");
		pro1.setProperty("username","admin");
		pro1.setProperty("password","admin");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/PropertiesDatas.properties");
		pro1.store(fos,"CommomDataStore");
		
		FileInputStream fis = new FileInputStream("./src/test/resources/PropertiesDatas.properties");
		Properties pro = new Properties();
		pro.load(fis);
		
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		WebDriver driver;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		
		driver.get(URL);
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

	}
	}
	

