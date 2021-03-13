package tweetSubmit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import pages.SignUpPage;
import utilities.Helper;

public class TestBase {
	
public static WebDriver driver ; 
SignUpPage signupObject ; 	

	@BeforeSuite 
	public void OpenDriver() 
	{
		System.setProperty("webdriver.chrome.driver", "Source/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://twitter.com/login");
		driver.manage().window().maximize();
	} 

	    
	 @BeforeClass
	 public void UserSignUpWithValidData() throws InterruptedException
	 {
		//user need to sign up before tweet 
		signupObject = new SignUpPage(driver); 
		signupObject.UserSignUp("validemail@gmail.com", "validPassword");
		
		Assert.assertTrue(driver.getCurrentUrl().contains("https://twitter.com/home"));
	 }
	
	@AfterSuite
	public void CloseDriver() 
	{
		driver.quit();
	}
	
	
	// take screenshot for fail test case and add it in the Screenshot folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			Helper.captureScreenshot(driver, result.getName());
		}
	}
}
