package appium.tutorial.android;

import appium.tutorial.android.util.AppiumTest;
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
    
	@org.junit.Test
    public void checkUserOneTest() throws Exception {
    	
    	 
        driver.findElementById(mailButtonId).sendKeys("user1@example.com");
        driver.findElementById(passwordButtonId).sendKeys("cGFzc3dvcmQ=");
        driver.findElementById(loginButtonId).click();
        
    }
	
	@org.junit.Test
    public void checkUserAdminTest() throws Exception {
    	
    	
      
            driver.findElementById(mailButtonId).sendKeys("admin@example.com");
            driver.findElementById(passwordButtonId).sendKeys("bm1UOGJTVkplcGdXcnJ5eA==");
            driver.findElementById(loginButtonId).click();
            
        }

	@org.junit.Test
    public void showPasswordTest() throws Exception {
    	
    	
     
        driver.findElementById(mailButtonId).sendKeys("user1@example.com");
        driver.findElementById(passwordButtonId).sendKeys("cGFzc3dvcmQ=");
        driver.findElementById(showPasswordId).click();
        driver.findElementById(passwordButtonId).getText().equals("cGFzc3dvcmQ=");
        
    }
}