package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
	
	private WebDriver driver;
	
    private By usernameField = By.cssSelector("input[name='session[username_or_email]']");
    private By passwordField = By.cssSelector("input[name='session[password]']");
    private By loginButton = By.cssSelector("div[data-testid='LoginForm_Login_Button']");
    private By title = By.cssSelector("h1[role='heading']");
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void UserSignUp(String Email , String Password)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(title),"Log in to Twitter"));

		driver.findElement(usernameField).sendKeys(Email);
		 driver.findElement(passwordField).sendKeys(Password);
		 driver.findElement(loginButton).click();
	}
	
	
}
