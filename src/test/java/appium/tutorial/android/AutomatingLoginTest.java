package appium.tutorial.android;

import appium.tutorial.android.util.AppiumTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
	@Given("User is on Signup screen")
	public void checkSignupScreen() throws Exception {

		driver.findElement(By.name("SIGN IN OR REGISTER"));

	}

	@org.junit.Test
	@When("User enter user1 details")
	public void addUserOneInfo() throws Exception {

		driver.findElementById(mailButtonId).sendKeys(userOneEmail);
		driver.findElementById(passwordButtonId).sendKeys(userOnePassword);

	}

	@org.junit.Test
	@When("User enter admin details")
	public void addAdminInfo() throws Exception {

		driver.findElementById(mailButtonId).sendKeys(adminEmail);
		driver.findElementById(passwordButtonId).sendKeys(adminPassword);

	}

	@org.junit.Test
	@When("User login")
	public void loginAction() throws Exception {
		driver.findElementById(loginButtonId).click();

	}

	@org.junit.Test
	@Then("Login user1 successfull")
	public void loginUserOneSucess() throws Exception {
		driver.findElementById(userLoggedId).getText().equals("Hi, User1");

	}

	@org.junit.Test
	@Then("Login admin successfull")
	public void loginAdminSucess() throws Exception {
		driver.findElementById(userLoggedId).getText().equals("Hi, Admin");

	}

	@org.junit.Test
	@When("User enter invalid email")
	public void enterInvalidEmail() throws Exception {

		driver.findElementById(mailButtonId).sendKeys("user1example.com");
		driver.findElementById(passwordButtonId).sendKeys(userOnePassword);
	}

	@org.junit.Test
	@Then("Login validation error")
	public void invalidEmailCheck() throws Exception {
		if (driver.findElementById(tokenButtonId).isDisplayed()) {
			throw new Exception("Oops! Impossible login .");
		}
	}

	@org.junit.Test
	@When("User enter password")
	public void emptyEmail() throws Exception {

		driver.findElementById(passwordButtonId).sendKeys(userOnePassword);
	}

	@org.junit.Test
	@When("User enter user1 email")
	public void enterUserOneEmail() throws Exception {

		driver.findElementById(mailButtonId).sendKeys(userOneEmail);
	}

	@When("User show password")
	public void showPassword() throws Exception {

		driver.findElementById(showPasswordId).click();
	}

	@Then("The password is displayed")
	public void checkDisplayedPassword() throws Exception {

		driver.findElement(By.name(userOnePassword));
	}

	@When("User enter short password")
	public void enterTooShortPassword() throws Exception {

		driver.findElementById(passwordButtonId).sendKeys("11=");
	}

	@Given("User1 logged")
	public void userLogged() throws Exception {
		addUserOneInfo();
		loginAction();

	}

	@Given("Admin logged")
	public void adminLogged() throws Exception {
		addAdminInfo();
		loginAction();

	}

	@When("User show token")
	public void userShowToken() throws Exception {
		driver.findElementById(tokenButtonId).click();

	}

	@Then("Admin token its the same")
	public void compareTokenAdmin() throws Exception {
		driver.findElement(By.name("123456789"));

	}

	@Then("User1 token its the same")
	public void compareTokenUserOne() throws Exception {
		driver.findElement(By.name("abcdefghi"));

	}

}