package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class browserInit{
	
	public static WebDriver driver;

	public static void init(){
	
	System.setProperty("webdriver.chrome.driver", "browser_files\\chromedriver1.exe");
	driver =  new ChromeDriver();
	driver.manage().window().maximize();  
	}
	public static boolean scroll_Page(WebElement webelement, int scrollPoints)
	{
	    try
	    {               
	        Actions dragger = new Actions(driver);
	        // drag downwards
	        int numberOfPixelsToDragTheScrollbarDown = 10;
	        for (int i = 10; i < scrollPoints; i = i + numberOfPixelsToDragTheScrollbarDown)
	        {
	            dragger.moveToElement(webelement).clickAndHold().moveByOffset(0, numberOfPixelsToDragTheScrollbarDown).release(webelement).build().perform();
	        }
	        Thread.sleep(500);
	        return true;
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	        return false;
	    }
	}
}
