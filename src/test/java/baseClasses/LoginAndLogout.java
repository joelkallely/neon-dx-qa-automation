package baseClasses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


public class LoginAndLogout extends browserInit
{
	
	ExcelHelper eh = new ExcelHelper();
	@Given("^login$")
    public void loginuser() throws InterruptedException {
		init();
		 eh.setExcelFile("login");
		 int rows = eh.numRows();
		 System.out.println(rows);
		 driver.get("http://192.168.150.45/#/login");
    	 driver.findElement(By.xpath("//*[@id='input'and @class='style-scope gold-email-input']")).sendKeys(eh.getCell(1, 0));
		 driver.findElement(By.xpath("//*[@id='input'and @class='style-scope paper-input']")).sendKeys(eh.getCell(1, 1));
		 driver.findElement(By.id("loginButton")).click();
		 // create file named Cookies to store Login Information		
	        File file = new File("Cookies.data");							
	        try		
	        {		
	            // Delete old file if exists
				file.delete();		
	            file.createNewFile();			
	            FileWriter fileWrite = new FileWriter(file);							
	            BufferedWriter Bwrite = new BufferedWriter(fileWrite);							
	            // loop for getting the cookie information 		
	            for(Cookie ck : driver.manage().getCookies())							
	            {		
	                Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));																									
	                Bwrite.newLine();			
	        }		
	            Bwrite.flush();			
	            Bwrite.close();			
	            fileWrite.close();			
	        }catch(Exception ex)					
	        {		
	            ex.printStackTrace();			
	        }		
	    				
     		
		System.out.println("logged in");
        
    }
	@When("^logout$")
    public void logout() {
		
		System.out.println("inside logout and exit");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		 //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='dropdown-trigger style-scope notification-panel x-scope paper-icon-button-0']"))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='trigger']/paper-icon-button"))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='contentWrapper']/div/paper-menu/div/paper-item"))).click();

		 
		System.out.println("logged out");
        
    }
//@BeforeClass
public void LoginWithValidUser(){
    
	 init();
	 //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 driver.get("http://192.168.150.45/#/login");
	 driver.findElement(By.xpath("//*[@id='input'and @class='style-scope gold-email-input']")).sendKeys("flyops@flytxt.com");
		driver.findElement(By.xpath("//*[@id='input'and @class='style-scope paper-input']")).sendKeys("flytxt");
	 driver.findElement(By.id("loginButton")).click();
	 
	 
	// WebDriverWait wait = new WebDriverWait(driver, 60);
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("outLogo")));
	 //driver.findElement(By.id("outLogo")).click();
}

//@AfterClass
public void LogoutandExitBrowser(){
	System.out.println("inside logout and exit");
	WebDriverWait wait = new WebDriverWait(driver, 60);
	 //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='dropdown-trigger style-scope notification-panel x-scope paper-icon-button-0']"))).click();
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='trigger']/paper-icon-button"))).click();
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='contentWrapper']/div/paper-menu/div/paper-item"))).click();

	 
	 //driver.findElement(By.xpath("//*[@d='M7 10l5 5 5-5z']/../../..")).click();
	//driver.findElement(By.xpath("//*[@class='dropdown-trigger style-scope notification-panel x-scope paper-icon-button-0']")).click();
 //driver.findElement(By.xpath("//*[@id='router']/app-route[24]/product-list/div[1]/paper-button")).click();
 //driver.findElement(By.id("outLogo")).click();
 //driver.findElement(By.linkText("Logout")).click();
 //driver.close();
}
}