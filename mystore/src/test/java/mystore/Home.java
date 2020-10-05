package mystore;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class Home extends MystoreTest{
	JavascriptExecutor jse=(JavascriptExecutor)wd;
	@FindBy(xpath="//a[@title='Home']") WebElement homebutton;
    @FindBy(xpath="//a[@title='Women']") WebElement Womenbutton;

	public void homeTest() throws InterruptedException
	{

	    jse.executeScript("window.scrollBy(0,300)", "");
	    Thread.sleep(2000);
	    jse.executeScript("window.scrollBy(0,300)", "");
	    Thread.sleep(4000);
	    
		homebutton.click();
		Thread.sleep(3000);
		logger5.log(Status.PASS, "Home button got clicked successfully");
		Womenbutton.click();
		Thread.sleep(2000);
		logger5.log(Status.PASS, "Women button got clicked");
		
		List<WebElement>grower=wd.findElements(By.xpath("//div[@id='categories_block_left']//li//span"));
		for(WebElement grow : grower)
		{
			Thread.sleep(1000);
			grow.click();
		}
		
		List<WebElement>Womendresscategory=wd.findElements(By.xpath("//div[@id='categories_block_left']//li//a"));
		int i=1;
		System.out.println("Total Categories under Women Section are= "+ Womendresscategory.size());
		logger5.log(Status.PASS, "Total Categories under Women Section are= "+ Womendresscategory.size());
		for(WebElement dress : Womendresscategory)
		{
			
			Thread.sleep(2000);
			String dress_category=dress.getText();
			Thread.sleep(2000);
			System.out.println("Category"+ i + "  "+ dress_category);
			logger5.log(Status.PASS, "Category"+ i +"  " + dress_category);
			i++;
		}
	
	}
	
	@FindBy(xpath="//input[@id='search_query_top']") WebElement search;
	@FindBy(xpath="//button[@name='submit_search']") WebElement search_button;
	@FindBy(xpath="//span[@class='heading-counter']") WebElement searchresult;
	
	public void search(String searchitem) throws InterruptedException
	{
		Thread.sleep(3000);
		search.sendKeys(searchitem);
		logger5.log(Status.PASS, "Item name '"+searchitem+ "' interted into search box");
		Thread.sleep(1000);
		search_button.click();
		Thread.sleep(3000);
		logger5.log(Status.PASS, "Search button got clicked");
		String searchresult_message=searchresult.getText();
		if(searchresult_message.equalsIgnoreCase("0 results have been found."))
		{
			System.out.println(searchresult);
			logger5.log(Status.PASS, "For " +searchitem +"--> " +searchresult_message);
		}
		
		else
	  {
		List<WebElement>search_item=wd.findElements(By.xpath("//ul[@class='product_list grid row']//img"));
		for(WebElement item : search_item)
		{
			int searchcount=search_item.size();
			logger5.log(Status.PASS, "For " +searchitem +"--> "+searchresult_message);
			System.out.println("Total number of search images found "+ searchcount);
			logger5.log(Status.PASS, "Total number of search images found " + searchcount);
			String item_title=item.getAttribute("title");
			System.out.println("Title name of item "+ item_title);
			logger5.log(Status.PASS, "Title name of item " + item_title);
		}
	 }
	}

}
