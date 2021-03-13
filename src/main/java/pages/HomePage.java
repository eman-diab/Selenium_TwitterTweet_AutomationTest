package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

private WebDriver driver;
	
 
    private By txt = By.cssSelector("div[data-testid='tweetTextarea_0']");
    private By tweetButton = By.cssSelector("div[data-testid='tweetButtonInline']");
    public  By message = By.cssSelector("div[data-testid='toast']");
    public  By inputField = By.cssSelector("div[data-testid='fileInput']");
    public  By GIFField = By.cssSelector("div[aria-label='Add a GIF' and role='button']");
    public  By pollField = By.cssSelector("div[aria-label='Add poll' and role='button']");
    public  By loaderOfMainPage= By.cssSelector("div[aria-label='Loading timeline']");
    
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void Usertweet(String text)
	{
		// wait until Main page load
		WebDriverWait wait = new WebDriverWait(driver, 10);
	     wait.until(ExpectedConditions.invisibilityOf((driver.findElement(loaderOfMainPage))));
	    //write text to tweet
	     driver.findElement(txt).sendKeys(text);
	}
	
	// click on tweet button to submit 
	public void submitTweet() {
	 driver.findElement(tweetButton).click();
	}
	 
	// successful message after tweet   
	public boolean messageDisplay()
	{
		return driver.findElement(message).isDisplayed();
	}
	
	// check if Tweet button is enable
	public boolean tweetButtonEnable()
	{
		return driver.findElement(tweetButton).isEnabled();
	}
	
   // upload file to twitter
   public void uploadFile(String absolutePathOfFile){
       driver.findElement(inputField).sendKeys(absolutePathOfFile);
   }
   
   // upload file button is enable
   public boolean uploadButtonEnable(){
       return driver.findElement(inputField).isEnabled();
   } 
   
   
   
}
