package library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static void capturescreenshot(WebDriver wd,String screenshotname)
	{
		try 
		{
			TakesScreenshot ts=(TakesScreenshot)wd;
			
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshot/"+screenshotname+".png"));
		} 
		catch (Exception e) 
		{
		
		  System.out.println("exceeption while taking screenshot "+ e.getMessage());
		}
		
	}
	
	public static String  attachscreenshotreport(WebDriver wd,String screenshotname)
	{
		TakesScreenshot ts=(TakesScreenshot)wd;
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshot/"+screenshotname+".png";
		File destination= new File(path);
		
		
		try
		{
		FileUtils.copyFile(source, destination);
		}
		catch (Exception e)
		{
			
		}
		return path;
		
		
		}

	}

