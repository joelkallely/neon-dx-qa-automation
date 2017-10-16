package baseClasses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


public class LoginAndLogout extends browserInit
{
	
	ExcelHelper eh = new ExcelHelper();
	
	
	@Given("^login$")
    public void loginuser() throws InterruptedException {
		init();
		 eh.setExcelFile("login.xls","Sheet1");
		 int rows = eh.numRows();
		 System.out.println(rows);
		 driver.get("http://192.168.150.45/#/login");
    	 driver.findElement(By.xpath("//*[@id='input'and @class='style-scope gold-email-input']")).sendKeys(eh.getCell(1, 0));
		 driver.findElement(By.xpath("//*[@id='input'and @class='style-scope paper-input']")).sendKeys(eh.getCell(1, 1));
		 driver.findElement(By.id("loginButton")).click();				
     		
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