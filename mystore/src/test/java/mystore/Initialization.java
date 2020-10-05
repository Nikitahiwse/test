package mystore;

import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;


public class Initialization extends MystoreTest {

	
	public void initialize() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//wankh//Downloads//chromedriver_win32 (2)//chromedriver.exe");
		wd=new ChromeDriver();
		wd.get("http://automationpractice.com/index.php");
		Thread.sleep(5000);
		logger4.log(Status.PASS, "Website launch successfully");
		wd.manage().window().maximize();
		logger4.log(Status.PASS, "window got maximize successfully");
		Thread.sleep(3000);
	}

	public void title_verification() throws InterruptedException
	{
		String titlename= wd.getTitle();
		Thread.sleep(3000);
		System.out.println("title name is = "+ titlename);
		logger3.log(Status.PASS, "Title name of website is- "+ titlename);
		Thread.sleep(3000);
		String expectedtitle="My Store";
	    Thread.sleep(3000);
		
	    if(titlename.equals(expectedtitle))
    {
	
    	logger3.log(Status.PASS, "Title is verified of My Store ");
	    System.out.println("Website title verification Testcase is passed");
		
	    }
	    else 
	    {
	    logger3.log(Status.FAIL, "Title is not verified");
	   	System.out.println("Website title verification is failed");
	    }
	}
	public void Extent_report_testcase_creation()
	{
		extent.attachReporter(htmlReporter); 
		logger1=extent.createTest("SignupTest");
		logger2=extent.createTest("LoginTest");
		logger3=extent.createTest("Title Verification Test");
		logger4=extent.createTest("Initialization Test");
		logger5=extent.createTest("Home Page Test");
		logger6=extent.createTest("Failed Test Reeport with Screenshot");
		
	}
}
