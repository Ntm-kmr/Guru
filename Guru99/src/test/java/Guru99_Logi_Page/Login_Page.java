package Guru99_Logi_Page;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Guru99_Login_Object.LoginPage_Object;
import Utilities.BaseClass;

public class Login_Page extends BaseClass{
	
	@Test
	public void loginTest() throws InterruptedException
	{
		test=reports.createTest("Login testing...");
		//log=LogManager.getLogger("Login_Page");
	LoginPage_Object loginpage=new LoginPage_Object(driver);
	loginpage.enteremailid("ntm.kmr5150@gmail.com");
	
	loginpage.enterpassword("aduhAnA");

	loginpage.clck();
	System.out.println(driver.getCurrentUrl());
	if(driver.getCurrentUrl().equals("https://demo.guru99.com/test/success.html"))
	{
		System.out.println("Logged in successfully");
		
	}
	else
	{
		System.out.println("Something went wrrong...need to check");
		
	}
	}
	
	@AfterMethod
	public void methodEnd(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+": Fail", ExtentColor.RED));
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getStatus()+": Pass", ExtentColor.GREEN));
		}
	}
}
