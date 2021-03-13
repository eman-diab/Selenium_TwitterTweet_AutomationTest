package tweetSubmit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ImageTweet extends TestBase {

	HomePage homeObject;
	
	
	    @Test
	    public void tweetWith1ImageValid()
		{ 
	    	homeObject = new HomePage(driver); 
	    	homeObject.uploadFile("Source/VOIS.jpeg");
            Assert.assertTrue(homeObject.tweetButtonEnable());
	    	
	    	homeObject.submitTweet();
			Assert.assertTrue(homeObject.messageDisplay());
			
		}
	    
	    @Test
	    public void tweetWith5ImageInvalid()
		{ 
	    	homeObject = new HomePage(driver); 
	    	homeObject.uploadFile("Source/VOIS.jpeg");
	    	homeObject.uploadFile("Source/VOIS.jpeg");
	    	homeObject.uploadFile("Source/VOIS.jpeg");
	    	homeObject.uploadFile("Source/VOIS.jpeg");
	    	homeObject.uploadFile("Source/VOIS.jpeg");
	    	Assert.assertFalse(homeObject.uploadButtonEnable());
	    	
	    	homeObject.submitTweet();
			Assert.assertTrue(homeObject.messageDisplay());
			
		}
}

