package appium.tutorial.android;

import appium.tutorial.android.util.AppiumTest;
import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.html.impl.SelectableTextInput;

import java.util.ArrayList;
import java.util.List;

import static appium.tutorial.android.util.Helpers.*;

public class AutomatingASimpleActionTest extends AppiumTest {

 	String mailButtonId = "com.cabify.qabify:id/email";
	String passwordButtonId = "com.cabify.qabify:id/password";
	String loginButtonId = "com.cabify.qabify:id/email_sign_in_button";
	String showPasswordId = "com.cabify.qabify:id/text_input_password_toggle";
	String tokenButtonId = "com.cabify.qabify:id/token_button";
	String userLoggedId = "com.cabify.qabify:id/textView";
	
    
	@org.junit.Test
    public void checkUserOneTest() throws Exception {
    	
		
        driver.findElementById(mailButtonId).sendKeys("user1@example.com");
        driver.findElementById(passwordButtonId).sendKeys("password");
        driver.findElementById(loginButtonId).click();
        driver.findElementById(userLoggedId).getText().equals("Hi,User 1");
        
    }
	
	@org.junit.Test
    public void checkUserAdminTest() throws Exception {
    	
    	
			
            driver.findElementById(mailButtonId).sendKeys("admin@example.com");
            driver.findElementById(passwordButtonId).sendKeys("nmT8bSVJepgWrryx");
            driver.findElementById(loginButtonId).click();
            driver.findElementById(userLoggedId).getText().equals("Hi, Admin");
            
        }

	@org.junit.Test
    public void showPasswordTest() throws Exception {
    	
		
        driver.findElementById(mailButtonId).sendKeys("user1@example.com");
        driver.findElementById(passwordButtonId).sendKeys("password");
        driver.findElementById(showPasswordId).click();
        driver.findElementById(passwordButtonId).getText().equals("password");
        
    }
	
	@org.junit.Test
    public void emptyPasswordTest() throws Exception {
    	
		
        driver.findElementById(mailButtonId).sendKeys("user1@example.com");
        driver.findElementById(loginButtonId).click();
        driver.findElement(By.name("This password is incorrect"));
        
    }
	
	@org.junit.Test
    public void tooShortPasswordTest() throws Exception {
    	
		
        driver.findElementById(mailButtonId).sendKeys("user1@example.com");
        driver.findElementById(passwordButtonId).sendKeys("11=");
        driver.findElementById(loginButtonId).click();
        driver.findElement(By.name("This password is too short"));
       
        
    }
	
	@org.junit.Test
    public void invalidEmailTest() throws Exception {	
		
		driver.findElementById(mailButtonId).sendKeys("user1example.com");
        driver.findElementById(loginButtonId).click();
        driver.findElement(By.name("This email address is invalid"));
        
    }
	
	
	@org.junit.Test
    public void emptyPasswordAndEmailTest() throws Exception {
    	
        driver.findElementById(loginButtonId).click();
        driver.findElement(By.name("This field is required"));
             
    }
	
	
	@org.junit.Test
    public void emptyEmailTest() throws Exception {
    
        driver.findElementById(passwordButtonId).sendKeys("cGFzc3dvcmQ=");
        driver.findElementById(loginButtonId).click();
        driver.findElement(By.name("This field is required"));
        
    }
	
	@org.junit.Test
	public void checkTokenUserOneTest() throws Exception {
		
        driver.findElementById(mailButtonId).sendKeys("user1@example.com");
        driver.findElementById(passwordButtonId).sendKeys("password");
        driver.findElementById(loginButtonId).click();
        driver.findElementById(tokenButtonId).click();
        driver.findElement(By.name("abcdefghi"));
        
	}
	
	@org.junit.Test
	public void checkTokenAdminTest() throws Exception {
		
        driver.findElementById(mailButtonId).sendKeys("admin@example.com");
        driver.findElementById(passwordButtonId).sendKeys("nmT8bSVJepgWrryx");
        driver.findElementById(loginButtonId).click();
        driver.findElementById(tokenButtonId).click();
        driver.findElement(By.name("123456789"));
        
	}
}