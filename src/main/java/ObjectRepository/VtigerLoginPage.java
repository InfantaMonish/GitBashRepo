package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerLoginPage {
	public VtigerLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name ="user_name")
	private WebElement userTextField;
	
	@FindBy(name ="user_password")
	private WebElement passwordtextField;
	
	@FindAll({@FindBy(xpath="//input[@type=\"submit\"]"),@FindBy(id="submitButton")})
	private WebElement loginButton;

	public WebElement getUserTextField() {
		return userTextField;
	}

	public WebElement getPasswordtextField() {
		return passwordtextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	public void loginToVtiger(String Username, String Password)
	{
		userTextField.sendKeys(Username);
		passwordtextField.sendKeys(Password);
		loginButton.click();
	}
	

}
