package mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactoryFinder;

import com.aventstack.extentreports.Status;

public class Login extends MystoreTest {

	
	@FindBy(xpath="//input[@name='email']")WebElement user_name;
	
	@FindBy(xpath="//input[@name='passwd']")WebElement Password;
	
	@FindBy(xpath="//button[@name='SubmitLogin']") WebElement signin;
	
	public void login(String username,String password) throws InterruptedException
	{
		
		user_name.sendKeys(username);
	    Thread.sleep(1000);
	    logger2.log(Status.PASS, "Username got entered successfully");
	
	    Password.sendKeys(password);
		Thread.sleep(1000);
		logger2.log(Status.PASS, "Password got entered successully");
		
	    signin.click();
		Thread.sleep(1000);
		logger2.log(Status.PASS, "Signin done successfully");
		Thread.sleep(4000);
	}

	

}
