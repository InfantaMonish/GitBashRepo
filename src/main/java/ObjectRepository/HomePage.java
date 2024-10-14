package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.Webdriver_Utility;

public class HomePage {
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText="Products")
	private WebElement proLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campLink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement AdmLink;
	

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getProLink() {
		return proLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampLink() {
		return campLink;
	}

	public WebElement getAdmLink() {
		return AdmLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	//Business logic
	
	public void clickOrgLink()
	{
		orgLink.click();
	}
	
	public void clickProLink()
	{
		proLink.click();
	}
	
	public void clickmoreLink()
	{
		moreLink.click();
	}
	
	public void clickCampLink()
	{
		campLink.click();
	}
	public void clickOnAdmLink()
	{
		AdmLink.click();
	}
	public void ClickSignOutLink()
	{
		signOutLink.click();
	}
	public void naviagteCamp(WebDriver driver)
	{
	
//		Actions act = new Actions(driver);
//		act.moveToElement(moreLink).perform();
		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.mouseMoveToElement(driver, moreLink);
		campLink.click();
	}
	 public void logOutFromApp()
	    {
		 AdmLink.click();
		 signOutLink.click();
	    }
	    public void logOut(WebDriver driver)
	    {
	    	Webdriver_Utility wlib = new Webdriver_Utility();
	    	wlib.mouseMoveToElement(driver, AdmLink);
	    	signOutLink.click();
	    }
}

