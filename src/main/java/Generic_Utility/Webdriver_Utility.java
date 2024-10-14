package Generic_Utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Webdriver_Utility {
	/**
	 * This 
	 * @param driver
	 */

		public void windowMaximize(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
		/**
		 * waits for elements to get loaded
		 */
		
	public void pageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * cursor move to element
	 * @param driver
	 * @param ele
	 */
	
	public void mouseMoveToElement(WebDriver driver, WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	/**
	 * switching multiple window
	 * @param driver
	 * @param partialTitle
	 */
	public void windowSwitching(WebDriver driver, String partialTitle)
	{
		Set<String> allwins=driver.getWindowHandles();
		
		Iterator<String> it =allwins.iterator();
		
		while(it.hasNext()) {
			String win=it.next();
			driver.switchTo().window(win);
		String title=driver.getTitle();
		
		if(title.contains(partialTitle)) {
			break;
		}
		}
	}
	/**
	 * alert accept
	 * @param driver
	 */
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * alert cancel
	 * @param driver
	 */
	public void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
}
