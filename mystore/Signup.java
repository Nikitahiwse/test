package freecrm;

import java.awt.Window;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.jcommander.Parameter;

public class Signup {
	public static WebDriver wd;
	public static  Initialization initial=new Initialization();
   
	
	public static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./Report/extent.html");
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest logger1;
	public static ExtentTest logger2;
	public static ExtentTest logger3;
	public static ExtentTest logger4;
	public static ExtentTest logger5;
	
	@BeforeSuite
	public void initialization() throws InterruptedException
	{
		extent.attachReporter(htmlReporter);
	    logger1=extent.createTest("SignupTest");
	    logger2=extent.createTest("LoginTest");
	    logger3=extent.createTest("Title Verification Test");
	    logger4=extent.createTest("Initialization Test");
	    logger5=extent.createTest("Home Page Test");
		
	    initial.initialize();
		
	}
	@Test(priority=1)
	public void Title_verification() throws InterruptedException
	{
		initial.title_verification();
		
	
	}
	
	 JavascriptExecutor jse=(JavascriptExecutor)wd;
	
	//@Test
    @Parameters({"title","email","username","lastname","password","date_of_birth","month_of_birth","year_of_birth","company","address1","address2","city","mobile","reference"})
	public void signup(String title,String email,String username,String lastname,String password,String date_of_birth,String month_of_birth,String year_of_birth,String company,String address1,String address2,String city,String mobile,String reference) throws InterruptedException
	{
		Accountcreation account =PageFactory.initElements(wd, Accountcreation.class);
		account.signupclick();
		account.accontcreation(title,email,username,lastname,password,date_of_birth,month_of_birth,year_of_birth,company,address1,address2,city,mobile,reference);
		
	}
	@Test(priority=2)
	@Parameters({"username","password"})
	public void login(String username,String password) throws InterruptedException
	{
		Accountcreation account =PageFactory.initElements(wd, Accountcreation.class);
		account.signupclick();
	    
		Login login=PageFactory.initElements(wd,Login.class);
		login.login(username,password);
		
		
	}
	@Test(priority=3)
	@Parameters("search_item")
	public void home(String searchitem) throws InterruptedException
	{
		Home homepage=PageFactory.initElements(wd, Home.class);
		homepage.homeTest();
		
		homepage.search(searchitem);
				
		
	}
	
	
	@AfterSuite
	public void logout()
	{
		extent.flush();
		wd.close();
		
	}
	
}
