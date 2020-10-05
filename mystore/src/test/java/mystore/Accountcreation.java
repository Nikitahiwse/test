package mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

public class Accountcreation extends MystoreTest {

JavascriptExecutor jse=(JavascriptExecutor)wd;

   @FindBy(xpath="//div[@class='header_user_info']//a")WebElement signup;
   
public void signupclick() throws InterruptedException
{
	signup.click();
	Thread.sleep(2000);
	logger1.log(Status.PASS, "Signup button got clicked");
	JavascriptExecutor jse=(JavascriptExecutor)wd;
	jse.executeScript("window.scrollBy(0,200)", "");
	Thread.sleep(4000);
}
	@FindBy(xpath="//input[@id='email_create']") WebElement mail;
	
	@FindBy(xpath="//div[@class='submit']//button[@id='SubmitCreate']") WebElement submit;
	
	@FindBy(xpath="//input[@name='id_gender'][@value='1']") WebElement title1;
	
	@FindBy(xpath="//input[@name='id_gender'][@value='2']") WebElement title2;
	
	@FindBy(xpath="//input[@id='customer_firstname']") WebElement user_name;
	
	@FindBy(xpath="//input[@id='customer_lastname']") WebElement last_name;
	
	@FindBy(xpath="//input[@id='email']") WebElement Email;
	
	@FindBy(xpath="//input[@id='passwd']") WebElement pass;
	
	@FindBy(xpath="//select[@id='days']") WebElement sel;
	
	@FindBy(xpath="//select[@id='months']") WebElement selmonth;
	
	@FindBy(xpath="//select[@id='years']") WebElement selyear;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']") WebElement check1;
	
	@FindBy(xpath="//input[@name='optin' and @value='1']") WebElement check2;
	
	@FindBy(xpath="//input[@name='firstname']") WebElement first_name;
	
	@FindBy(xpath="//input[@name='lastname']") WebElement last_name2;
	
	@FindBy(xpath="//input[@name='company']") WebElement company_name;
	
	@FindBy(xpath="//input[@name='address1']") WebElement address_1;
	
	@FindBy(xpath="//input[@name='address2']") WebElement address_2;
	
	@FindBy(xpath="//input[@name='city']") WebElement city_name;
	
	@FindBy(xpath="//select[@name='id_state']") WebElement state;
	
	@FindBy(xpath="//input[@name='postcode']") WebElement postalcode;
	
	@FindBy(xpath="//textarea[@name='other']") WebElement textarea;
	
	@FindBy(xpath="//input[@name='phone_mobile']") WebElement mobile_number;
	
	@FindBy(xpath="//input[@name='alias']") WebElement Reference;
	
	@FindBy(xpath="//button[@name='submitAccount']") WebElement registerbutton;

public void accontcreation(String title,String email,String username,String lastname,String password,String date_of_birth,String month_of_birth,String year_of_birth,String company,String address1,String address2,String city,String mobile,String reference) throws InterruptedException
{
	
	mail.sendKeys(email);
	logger1.log(Status.PASS, "Email got interted successfully");
	submit.click();
    logger1.log(Status.PASS, "Submit button got clicked");
    jse.executeScript("window.scrollBy(0,200)", "");
    Thread.sleep(3000);
    
    //account creation first section
    System.out.println(title);
    if(title.equals("Mr."))
    {
    	title1.click();
    	logger1.log(Status.PASS, title+ " radio button got clicked");
    } 
    else if(title.equals("Mrs."));
    {
    	title2.click();
        logger1.log(Status.PASS, title+ " radio button got clicked");
    }
   
   user_name.sendKeys(username);
   Thread.sleep(1000);
   logger1.log(Status.PASS, username+" username got inserted");
   last_name.sendKeys(lastname);
   Thread.sleep(1000);
   logger1.log(Status.PASS, lastname+" lastname got inserted");
   Email.clear();
   Email.sendKeys(email);
   Thread.sleep(1000);
   logger1.log(Status.PASS, email+ " email got inserted");
   pass.sendKeys(password);
   Thread.sleep(1000);
   
   Select dropdownday= new Select(sel);
   dropdownday.selectByValue(date_of_birth);
   Thread.sleep(1000);
   
   Select dropdownmonth=new Select(selmonth);
   dropdownmonth.selectByValue(month_of_birth);
   Thread.sleep(1000);
   
   Select dropdownyear=new Select(selyear);
   dropdownyear.selectByValue(year_of_birth);
   logger1.log(Status.PASS, "Date of birth got inserted-"+ date_of_birth +"/"+ month_of_birth + "/"+year_of_birth);
   
   check1.click();
   Thread.sleep(1000);
   check2.click();
   jse.executeScript("window.scrollBy(0,200)", "");
   Thread.sleep(3000);
   //section2
   first_name.clear();
   first_name.sendKeys(username);
   Thread.sleep(1000);
   last_name2.clear();
   last_name2.sendKeys(lastname);
   Thread.sleep(1000);
   company_name.sendKeys(company);
   logger1.log(Status.PASS, company+" company name got inserted");
   Thread.sleep(1000);
   address_1.sendKeys(address1);
   logger1.log(Status.PASS, address1+" address inserted");
   Thread.sleep(1000);
   address_2.sendKeys(address2);
   Thread.sleep(1000);
   city_name.sendKeys(city);
   logger1.log(Status.PASS, city+" city name got inserted");
   Thread.sleep(1000);
   Select dropdownstate= new Select(state);
   dropdownstate.selectByValue("2");
   Thread.sleep(1000);
   postalcode.sendKeys("00000");
   Thread.sleep(1000);
   textarea.sendKeys("xyz");
   Thread.sleep(1000);
   mobile_number.sendKeys(mobile);
   logger1.log(Status.PASS, mobile+" mobile number got inserted");
   Thread.sleep(1000);
   Reference.sendKeys(reference);
   Thread.sleep(1000);
   registerbutton.click();
   logger1.log(Status.PASS, "Register button got clicked and account got created successfully");
}


	

		
		
	

}
