package Guru99_Login_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Object {
	
	WebDriver driver;
	
	public LoginPage_Object(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email") WebElement email;
	@FindBy(id="passwd") WebElement Password;
	@FindBy(id="SubmitLogin") WebElement LoginButton;
	
	public void enteremailid(String id)
	{
		email.sendKeys(id);
	}
	public void enterpassword(String pswd)
	{
		Password.sendKeys(pswd);
	}
	public void clck()
	{
		LoginButton.click();
	}

}
