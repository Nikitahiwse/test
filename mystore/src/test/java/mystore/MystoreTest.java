package mystore;

import java.awt.Window;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;
//import com.relevantcodes.extentreports.LogStatus;



import library.Utility;

public class MystoreTest {
	public static WebDriver wd;
	public static Initialization initial=new Initialization();
    JavascriptExecutor jse=(JavascriptExecutor)wd;
	public static ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./Report/extent.html");
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest logger1,logger2,logger3,logger4,logger5,logger6;
	

	//for initialization
	@BeforeSuite
	public void initialization() throws InterruptedException
	{
		
	  initial.Extent_report_testcase_creation();
	  initial.initialize();
		
	}
	@Test(priority=1)
	public void Title_verification() throws InterruptedException
	{
		
		initial.title_verification();
		
	}
	
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
	
	//@Test(priority=3)
	@Parameters("search_item")
	public void home(String searchitem) throws InterruptedException
	{
		
		Home homepage=PageFactory.initElements(wd, Home.class);
		homepage.homeTest();
		
		homepage.search(searchitem);
				
		
	}
	
	@Test(priority=4)
	public void failtest() throws InterruptedException
	{
		
		Failedtestcase.fail_test();
	
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException
	{
		//To add screenshot in folder
		//if(ITestResult.FAILURE==result.getStatus())
		//	Utility.capturescreenshot(wd, result.getName());
		
		//To add Failed Testcases screenshot in Report
		try {
		if(ITestResult.FAILURE==result.getStatus())
		{
		String temp=Utility.attachscreenshotreport(wd, result.getName());
		//logger6.log("Testcase name "+result.getName());
		logger6.fail("Testcase name"+ result.getName());
		logger6.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	    }}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}
	@AfterSuite
	public void logout()
	{
		extent.flush();
		wd.close();
		
	}
	
}
