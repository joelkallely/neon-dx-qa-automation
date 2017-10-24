package stepDefinitions;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import baseClasses.ExcelHelper;
import baseClasses.browserInit;


import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;

public class Offer_creation extends browserInit 

{
	public ExcelHelper eh = new ExcelHelper();
	//public WebDriverWait wait = new WebDriverWait(driver, 15);
	
	@Then("^Navigate_to_Offers")
	public void navigate_to_offers() throws Throwable
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym2']"))).click();	    
		Thread.sleep(3000);
	}
	
	@Then("^create new offer for product$")
	public void create_new_Offer() throws Throwable 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
		Thread.sleep(2000);
		eh.setExcelFile("inputData","singleProductPage");
		Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		String name = (String) eh.getCell(1, 12);
		name =  name.replaceAll("[0-9]", "")+n;
		name= n+name;
		eh.setCell(1, 12, name);
//******************Details tab******************:
		
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Offer Name')]"))).click().sendKeys(name).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Description')]"))).click().sendKeys("testing").build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Offer Type')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'Recharge')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Channel')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'SMS')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Category')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'Combo Vouchers')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Currency')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'INR')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Discount')]"))).click().sendKeys("20").build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		Thread.sleep(2000);

		
		
//******************Products tab*****************:
		eh.setExcelFile("inputData.xls","singleProductPage");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='check']/div/iron-pages/offer-products/form/div/div[2]/paper-button"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
		Thread.sleep(2000);
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Product Name')]"))).sendKeys(eh.getCell(1, 0)).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(.,'"+eh.getCell(1, 0)+"')]")))).click();
		actions.moveToElement(driver.findElement(By.xpath("//*[@id='productDialog']/div[2]/paper-button[2]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		Thread.sleep(2000);
		
//******************Creative tab*****************:
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Language')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'English (UK)')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Character Set')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'GSM Characters')]"))).click().build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='smsOp1-0']/paper-input-container/div[2]/div[1]/input[1]")).sendKeys("Bonus_Offer");
		driver.findElement(By.xpath("//*[@id='smsOp2-0']/paper-input-container/div[2]/div[1]/input[1]")).sendKeys("Get bonus for rupees 20 on recharge with 100");
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		Thread.sleep(3000);
		
//******************Track tab*****************:

		actions.moveToElement(driver.findElement(By.xpath("//label[contains(@class,'style-scope paper-input') and contains(text(),'Source')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'recharge_track')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		Thread.sleep(2000);
		
//******************Track tab*****************:
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Save Offer')]"))).click().build().perform();
		Thread.sleep(5000);
	}

	@Then("^Delete_Offer$")
	public void Delete_Offer() throws Throwable 
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='filterForm']/paper-input[1]/paper-input-container/div[1]/../div[2]/div[1]/input[1]")).sendKeys("Offer_to_check_language_select");
		driver.findElement(By.xpath("//*[@id='filterDialog']/div/paper-button[3]")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../..")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='contentWrapper']/div/paper-menu/div/paper-item"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='deleteOffer']/div/paper-button[2]"))).click();
		
	}
	
}
