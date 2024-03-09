package Utilities;

import java.time.Duration;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	
	public WebDriver driver;
	public Logger log;
	public ExtentSparkReporter htmlreporter;
	public ExtentReports reports;
	public ExtentTest test;
	
	
	
	
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		htmlreporter= new ExtentSparkReporter("extentreport.html");
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
		reports.setSystemInfo("name", "narottam");
		reports.setSystemInfo("machine", "gbre");
		
		htmlreporter.config().setDocumentTitle("This is the title");
		htmlreporter.config().setTheme(Theme.STANDARD);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.guru99.com/test/login.html");
	}
	
	@AfterClass
	public void teardown()
	{
		reports.flush();
		driver.quit();
	}

}
