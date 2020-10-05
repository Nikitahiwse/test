package mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Failedtestcase extends MystoreTest {

	

	public static void fail_test()
	{
		WebElement sigin=wd.findElement(By.xpath("//div[@class='header_user_info']//a[text()='Sign in']"));
		
		sigin.click();
	}
	

}
