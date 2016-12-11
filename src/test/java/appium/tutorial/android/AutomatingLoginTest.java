package appium.tutorial.android;

import appium.tutorial.android.util.AppiumTest;
import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.html.impl.SelectableTextInput;

import java.util.ArrayList;
import java.util.List;

import static appium.tutorial.android.util.Helpers.*;

public class AutomatingLoginTest extends AppiumTest {

 	String mailButtonId = "com.cabify.qabify:id/email";
	String passwordButtonId = "com.cabify.qabify:id/password";
	String loginButtonId = "com.cabify.qabify:id/email_sign_in_button";
	String showPasswordId = "com.cabify.qabify:id/text_input_password_toggle";
	String tokenButtonId = "com.cabify.qabify:id/token_button";
	String userLoggedId = "com.cabify.qabify:id/textView";
	String userOnePassword = "password";
	String userOneEmail = "user1@example.com";
	String adminPassword = "nmT8bSVJepgWrryx";
	String adminEmail = "admin@example.com";
    
	@org.junit.Test
    public void checkUserOneTest() throws Exception {
    	
		
        driver.findElementById(mailButtonId).sendKeys("emailUserOne");
        driver.findElementById(passwordButtonId).sendKeys(userOnePassword);
        driver.findElementById(loginButtonId).click();
        driver.findElementById(userLoggedId).getText().equals("Hi,User 1");
        
    }
	
	@org.junit.Test
    public void checkUserAdminTest() throws Exception {
    	
    	
			
            driver.findElementById(mailButtonId).sendKeys(adminEmail);
            driver.findElementById(passwordButtonId).sendKeys(adminPassword);
            driver.findElementById(loginButtonId).click();
            driver.findElementById(userLoggedId).getText().equals("Hi, Admin");
            
        }

	@org.junit.Test
    public void showPasswordTest() throws Exception {
    	
		
        driver.findElementById(mailButtonId).sendKeys(userOneEmail);
        driver.findElementById(passwordButtonId).sendKeys(userOnePassword);
        driver.findElementById(showPasswordId).click();
        driver.findElementById(passwordButtonId).getText().equals(userOnePassword);
        
        
        
    }
	
	@org.junit.Test
    public void emptyPasswordTest() throws Exception {
    	
		String currentActivity = driver.currentActivity();
        driver.findElementById(mailButtonId).sendKeys(userOneEmail);
        driver.findElementById(loginButtonId).click();
        currentActivity.equals(driver.currentActivity());
        
        	
        
    }
	
	@org.junit.Test
    public void tooShortPasswordTest() throws Exception {
    	
		String currentActivity = driver.currentActivity();
        driver.findElementById(mailButtonId).sendKeys(userOneEmail);
        driver.findElementById(passwordButtonId).sendKeys("11=");
        driver.findElementById(loginButtonId).click();
        currentActivity.equals(driver.currentActivity());
        if (driver.findElementById(tokenButtonId).isDisplayed()) {
    	    throw new Exception("Oops! Impossible show token of invalid password.");
    	  }
       
        
    }
	
	@org.junit.Test
	public void invalidEmailTest() throws Exception
	{
		driver.findElementById(mailButtonId).sendKeys("user1example.com");
        driver.findElementById(passwordButtonId).sendKeys(userOnePassword);
        driver.findElementById(loginButtonId).click();
	  if (driver.findElementById(tokenButtonId).isDisplayed()) {
	    throw new Exception("Oops! Impossible show token of invalid email.");
	  }
	}
	
	
	@org.junit.Test
    public void emptyPasswordAndEmailTest() throws Exception {
    	
        driver.findElementById(loginButtonId).click();
        driver.findElement(By.name("This field is required"));
        if (driver.findElementById(tokenButtonId).isDisplayed()) {
    	    throw new Exception("Oops! Impossible show token of invalid email or password.");
    	  }
             
    }
	
	
	@org.junit.Test
    public void emptyEmailTest() throws Exception {
    
        driver.findElementById(passwordButtonId).sendKeys("cGFzc3dvcmQ=");
        driver.findElementById(loginButtonId).click();
        if (driver.findElementById(tokenButtonId).isDisplayed()) {
    	    throw new Exception("Oops! Impossible show token of invalid email.");
    	  }
        
    }
	
	@org.junit.Test
	public void checkTokenUserOneTest() throws Exception {
		
        driver.findElementById(mailButtonId).sendKeys(userOneEmail);
        driver.findElementById(passwordButtonId).sendKeys(userOnePassword);
        driver.findElementById(loginButtonId).click();
        driver.findElementById(tokenButtonId).click();
        driver.findElement(By.name("abcdefghi"));
        
	}
	
	@org.junit.Test
	public void checkTokenAdminTest() throws Exception {
	
        driver.findElementById(mailButtonId).sendKeys(adminEmail);
        driver.findElementById(passwordButtonId).sendKeys(adminPassword);
        driver.findElementById(loginButtonId).click();
        driver.findElementById(tokenButtonId).click();
        driver.findElement(By.name("123456789"));
        
	}
}