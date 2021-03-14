package tweetSubmit;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;


public class TextTweet extends TestBase {

    HomePage homeObject;
    
    
    @Test
    public void tweetWithValidText280char() 
	{
    	//generate random characters for test character limitation 
    	String generatedString = RandomStringUtils.randomAlphabetic(280);
    	
		//User  can tweet 280 character  
    	homeObject = new HomePage(driver); 
    	homeObject.Usertweet(generatedString); 
    	homeObject.submitTweet();
    	
		Assert.assertTrue(homeObject.messageDisplay());	
	}
    
    @Test
    public void tweetWithValidText1char()
	{
    	//generate random characters for test character limitation 
    	String generatedString = RandomStringUtils.randomAlphabetic(1);
    	
		//User can tweet 1 character  
    	homeObject = new HomePage(driver); 
    	homeObject.Usertweet(generatedString); 
    	homeObject.submitTweet();
    	
		Assert.assertTrue(homeObject.messageDisplay());	
	}
    
    @Test
    public void tweetWithInvalidText281char()
	{
    	//generate random characters for test character limitation 
    	String generatedString = RandomStringUtils.randomAlphabetic(281);
    	
		//User can't tweet 281 character  
    	homeObject = new HomePage(driver); 
    	homeObject.Usertweet(generatedString); 
    	Assert.assertFalse(homeObject.tweetButtonEnable());
    	
    	homeObject.submitTweet();
		Assert.assertFalse(homeObject.messageDisplay());	
	}
    
    @Test
    public void tweetWithInvalidText0char()
	{
		//User can't tweet 0 character  
    	homeObject = new HomePage(driver); 
    	homeObject.Usertweet(""); 
     	Assert.assertFalse(homeObject.tweetButtonEnable());
    	
    	homeObject.submitTweet();
		Assert.assertFalse(homeObject.messageDisplay());	
	}
}
