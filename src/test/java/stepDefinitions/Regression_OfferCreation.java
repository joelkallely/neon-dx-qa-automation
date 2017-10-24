package stepDefinitions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import baseClasses.ExcelHelper;
import cucumber.api.java.en.Then;

public class Regression_OfferCreation extends baseClasses.browserInit {
	public WebDriverWait wait = new WebDriverWait(driver, 15);
	public Actions actions = new Actions(driver);
	
	ExcelHelper eh = new ExcelHelper();

////////********Creating Offers with SMS Channel*******************
	
	@Then("^Create_offers_with_SMS_channel$")
	public void Create_offer_with_SMS_channel() throws Throwable 
	{
		
		eh.setExcelFile("Offer_Creation", "details");
		//int rows = eh.numOFrows();
		for(int i=1;i<8;i++)
		{
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
		
//******************Details tab******************:
					
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Offer Name')]"))).click().sendKeys(eh.getCell(i, 0)).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Description')]"))).click().sendKeys(eh.getCell(i, 1)).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Offer Type')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 2)+"')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Channel')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 3)+"')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Category')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 4)+"')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Currency')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 5)+"')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Discount')]"))).click().sendKeys(eh.getCell(i, 6)).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		Thread.sleep(2000);

		
		
//******************Products tab*****************:
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='check']/div/iron-pages/offer-products/form/div/div[2]/paper-button"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
		Thread.sleep(2000);
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Product Name')]"))).sendKeys(eh.getCell(i, 7)).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(.,'"+eh.getCell(i, 8)+"')]")))).click();
		actions.moveToElement(driver.findElement(By.xpath("//*[@id='productDialog']/div[2]/paper-button[2]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		Thread.sleep(2000);
		
//******************Creative tab*****************:
		String channel = eh.getCell(i, 3).toString();
	
		if ("SMS".equals(channel))
		{		
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Language')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 9)+"')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Character Set')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 10)+"')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Title')]"))).click().sendKeys(eh.getCell(i, 11)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Details')]"))).click().sendKeys(eh.getCell(i, 12)).build().perform(); 
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
			Thread.sleep(2000);
		}
		else if ("Voice Push".equals(channel)) 
		{
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Language')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 9)+"')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Character Set')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 10)+"')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Subject')]"))).click().sendKeys(eh.getCell(i, 13)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Reference')]"))).click().sendKeys(eh.getCell(i, 14)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Optional1')]"))).click().sendKeys(eh.getCell(i, 15)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Optional2')]"))).click().sendKeys(eh.getCell(i, 16)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Optional3')]"))).click().sendKeys(eh.getCell(i, 17)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Optional4')]"))).click().sendKeys(eh.getCell(i, 18)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
			Thread.sleep(2000);
		}
		
		else if ("WAP Push".equals(channel))
		{
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Language')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'English (UK)')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Character Set')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'GSM Characters')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Title')]"))).click().sendKeys(eh.getCell(i, 19)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'URL')]"))).click().sendKeys(eh.getCell(i, 20)).build().perform(); 
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		}		

	
//******************Track tab*****************:
	String offer_type = eh.getCell(i, 2).toString();
		
		if ("Informational".equals(offer_type))
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		
		else
		{
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(@class,'style-scope paper-input') and contains(text(),'Source')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'recharge_track')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		Thread.sleep(2000);
		}
		
//******************Rewards tab*****************:
		
		if("Seeding".equals(offer_type))
		{
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Reward Type')]"))).click().build().perform();
			Thread.sleep(2000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'ApplyPackFlow')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'PlanValue')]"))).click().build().perform();
			Thread.sleep(2000);
			actions.moveToElement(driver.findElement(By.cssSelector("paper-listbox.dropdown-content.style-scope.add-seeding-reward.x-scope.paper-listbox-0 paper-item:nth-child(1)"))).click().build().perform();
			Thread.sleep(2000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Save Offer')]"))).click().build().perform();
			Thread.sleep(4000);	
			
		}
		else
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Save Offer')]"))).click().build().perform();
		Thread.sleep(4000);
		
		}
	}

	@Then("^Delete_SMS_channel_offers$")
	public void Delete_SMS_channel_offers() throws Throwable 
	{	
		eh.setExcelFile("Offer_Creation", "details");
		//int rows = eh.numOFrows();
		for(int i=1;i<8;i++)
		{
			
		driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='filterForm']/paper-input[1]/paper-input-container/div[1]/../div[2]/div[1]/input[1]")).sendKeys(eh.getCell(i, 0));
		driver.findElement(By.xpath("//*[@id='filterDialog']/div/paper-button[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../..")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='contentWrapper']/div/paper-menu/div/paper-item"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='deleteOffer']/div/paper-button[2]"))).click();
		
		}
	}
	
////////********Creating Offers with VOICEpush Channel*******************
	
	@Then("^Create_offers_with_VOICEpush_channel$")
	public void Create_offer_with_VOICEpush_channel() throws Throwable 
	{
			
			eh.setExcelFile("Offer_Creation", "details");
			//int rows = eh.numOFrows();
			for(int i=8;i<15;i++)
			{
	
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
	
//******************Details tab******************:
				
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Offer Name')]"))).click().sendKeys(eh.getCell(i, 0)).build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Description')]"))).click().sendKeys(eh.getCell(i, 1)).build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Offer Type')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 2)+"')]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Channel')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 3)+"')]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Category')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 4)+"')]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Currency')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 5)+"')]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Discount')]"))).click().sendKeys(eh.getCell(i, 6)).build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
				Thread.sleep(2000);

	
	
//******************Products tab*****************:
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='check']/div/iron-pages/offer-products/form/div/div[2]/paper-button"))).click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
				Thread.sleep(2000);
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Product Name')]"))).sendKeys(eh.getCell(i, 7)).build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(.,'"+eh.getCell(i, 8)+"')]")))).click();
				actions.moveToElement(driver.findElement(By.xpath("//*[@id='productDialog']/div[2]/paper-button[2]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
				Thread.sleep(2000);
	
//******************Creative tab*****************:
			String channel = eh.getCell(i, 3).toString();
		
			if ("SMS".equals(channel))
			{		
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Language')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 9)+"')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Character Set')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 10)+"')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Title')]"))).click().sendKeys(eh.getCell(i, 11)).build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Details')]"))).click().sendKeys(eh.getCell(i, 12)).build().perform(); 
				actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
				Thread.sleep(2000);
			}
			else if ("Voice Push".equals(channel)) 
			{
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Language')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 9)+"')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Character Set')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 10)+"')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Subject')]"))).click().sendKeys(eh.getCell(i, 13)).build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Reference')]"))).click().sendKeys(eh.getCell(i, 14)).build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Optional1')]"))).click().sendKeys(eh.getCell(i, 15)).build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Optional2')]"))).click().sendKeys(eh.getCell(i, 16)).build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Optional3')]"))).click().sendKeys(eh.getCell(i, 17)).build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Optional4')]"))).click().sendKeys(eh.getCell(i, 18)).build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
				Thread.sleep(2000);
			}
			
			else if ("WAP Push".equals(channel))
			{
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Language')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'English (UK)')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Character Set')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'GSM Characters')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Title')]"))).click().sendKeys(eh.getCell(i, 19)).build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'URL')]"))).click().sendKeys(eh.getCell(i, 20)).build().perform(); 
				actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
			}		


//******************Track tab*****************:
			String offer_type = eh.getCell(i, 2).toString();
				
				if ("Informational".equals(offer_type))
					actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
				
				else
				{
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(@class,'style-scope paper-input') and contains(text(),'Source')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'recharge_track')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
				Thread.sleep(2000);
				}
	
//******************Rewards tab*****************:
			
			if("Seeding".equals(offer_type))
			{
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Reward Type')]"))).click().build().perform();
				Thread.sleep(2000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'ApplyPackFlow')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'PlanValue')]"))).click().build().perform();
				Thread.sleep(2000);
				actions.moveToElement(driver.findElement(By.cssSelector("paper-listbox.dropdown-content.style-scope.add-seeding-reward.x-scope.paper-listbox-0 paper-item:nth-child(1)"))).click().build().perform();
				Thread.sleep(2000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Save Offer')]"))).click().build().perform();
				Thread.sleep(4000);	
				
			}
			else
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Save Offer')]"))).click().build().perform();
			Thread.sleep(4000);
			
			}
		}
		
		@Then("^Delete_VOICEpush_channel_offers$")
		public void Delete_VOICEpush_channel_offers() throws Throwable 
		{	
			eh.setExcelFile("Offer_Creation", "details");
			//int rows = eh.numOFrows();
			for(int i=8;i<15;i++)
			{
				
			driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id='filterForm']/paper-input[1]/paper-input-container/div[1]/../div[2]/div[1]/input[1]")).sendKeys(eh.getCell(i, 0));
			driver.findElement(By.xpath("//*[@id='filterDialog']/div/paper-button[3]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../..")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='contentWrapper']/div/paper-menu/div/paper-item"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='deleteOffer']/div/paper-button[2]"))).click();
			
			}
		}

////////********Creating Offers with WAPpush Channel*******************

		@Then("^Create_offers_with_WAPpush_channel$")
		public void Create_offer_with_WAPpush_channel() throws Throwable 
		{
				
				eh.setExcelFile("Offer_Creation", "details");
		//int rows = eh.numOFrows();
		for(int i=15;i<22;i++)
		{

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();

//******************Details tab******************:
		
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Offer Name')]"))).click().sendKeys(eh.getCell(i, 0)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Description')]"))).click().sendKeys(eh.getCell(i, 1)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Offer Type')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 2)+"')]"))).click().build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Channel')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 3)+"')]"))).click().build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Category')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 4)+"')]"))).click().build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Currency')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 5)+"')]"))).click().build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Discount')]"))).click().sendKeys(eh.getCell(i, 6)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
			Thread.sleep(2000);



//******************Products tab*****************:
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='check']/div/iron-pages/offer-products/form/div/div[2]/paper-button"))).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
			Thread.sleep(2000);
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Product Name')]"))).sendKeys(eh.getCell(i, 7)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(.,'"+eh.getCell(i, 8)+"')]")))).click();
			actions.moveToElement(driver.findElement(By.xpath("//*[@id='productDialog']/div[2]/paper-button[2]"))).click().build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
			Thread.sleep(2000);

//******************Creative tab*****************:
			String channel = eh.getCell(i, 3).toString();
			
			if ("SMS".equals(channel))
			{		
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Language')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 9)+"')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Character Set')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 10)+"')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Title')]"))).click().sendKeys(eh.getCell(i, 11)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Details')]"))).click().sendKeys(eh.getCell(i, 12)).build().perform(); 
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
			Thread.sleep(2000);
			}
			else if ("Voice Push".equals(channel)) 
			{
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Language')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 9)+"')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Character Set')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 10)+"')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Subject')]"))).click().sendKeys(eh.getCell(i, 13)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Reference')]"))).click().sendKeys(eh.getCell(i, 14)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Optional1')]"))).click().sendKeys(eh.getCell(i, 15)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Optional2')]"))).click().sendKeys(eh.getCell(i, 16)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Optional3')]"))).click().sendKeys(eh.getCell(i, 17)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Optional4')]"))).click().sendKeys(eh.getCell(i, 18)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
			Thread.sleep(2000);
			}

			else if ("WAP Push".equals(channel))
			{
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Language')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'English (UK)')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Character Set')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'GSM Characters')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Title')]"))).click().sendKeys(eh.getCell(i, 19)).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'URL')]"))).click().sendKeys(eh.getCell(i, 20)).build().perform(); 
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
			}		


//******************Track tab*****************:
			String offer_type = eh.getCell(i, 2).toString();
			
			if ("Informational".equals(offer_type))
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
			
			else
			{
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(@class,'style-scope paper-input') and contains(text(),'Source')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'recharge_track')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
			Thread.sleep(2000);
			}

//******************Rewards tab*****************:

			if("Seeding".equals(offer_type))
			{
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Reward Type')]"))).click().build().perform();
			Thread.sleep(2000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'ApplyPackFlow')]"))).click().build().perform();
			Thread.sleep(1000);
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'PlanValue')]"))).click().build().perform();
			Thread.sleep(2000);
			actions.moveToElement(driver.findElement(By.cssSelector("paper-listbox.dropdown-content.style-scope.add-seeding-reward.x-scope.paper-listbox-0 paper-item:nth-child(1)"))).click().build().perform();
			Thread.sleep(2000);
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Save Offer')]"))).click().build().perform();
			Thread.sleep(4000);	
			
			}
			else
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Save Offer')]"))).click().build().perform();
			Thread.sleep(4000);
			
			}
			}
			
			@Then("^Delete_WAPpush_channel_offers$")
			public void Delete_WAPpush_channel_offers() throws Throwable 
			{	
			eh.setExcelFile("Offer_Creation", "details");
			//int rows = eh.numOFrows();
			for(int i=15;i<22;i++)
			{
			
			driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id='filterForm']/paper-input[1]/paper-input-container/div[1]/../div[2]/div[1]/input[1]")).sendKeys(eh.getCell(i, 0));
			driver.findElement(By.xpath("//*[@id='filterDialog']/div/paper-button[3]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../..")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='contentWrapper']/div/paper-menu/div/paper-item"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='deleteOffer']/div/paper-button[2]"))).click();
			
			}
		}
			
			@Then("^Check_Offer_cancel_button$")
			public void Check_cancel_button() throws Throwable
			{
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
				
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Offer Name')]"))).click().sendKeys("name").build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Description')]"))).click().sendKeys("desc").build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Offer Type')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'Balance Deduction')]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Channel')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'SMS')]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Category')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'Balance Top ups')]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Currency')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'INR')]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Discount')]"))).click().sendKeys("20").build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Cancel')]"))).click().build().perform();
				Thread.sleep(2000);
			}

			@Then("^Check_Offer_help_icon$")
			public void Check_Offer_help_icon() throws Throwable
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//flytxt-context-help[@id='Offers']"))).click();
				WebElement help_dialogueBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//object[contains(@data,'./../context-help/Offers.html')]")));
				Thread.sleep(2000);
				try 
				{
					if(help_dialogueBox.isDisplayed())
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M14.59 8L12 10.59 9.41 8 8 9.41 10.59 12 8 14.59 9.41 16 12 13.41 14.59 16 16 14.59 13.41 12 16 9.41 14.59 8zM12 2C6.47 2 2 6.47 2 12s4.47 10 10 10 10-4.47 10-10S17.53 2 12 2zm0 18c-4.41 0-8-3.59-8-8s3.59-8 8-8 8 3.59 8 8-3.59 8-8 8z']/../../.."))).click();
				} 
				catch (Exception e) 
				{
					System.out.println("Help dialogue box is not displayed");
					e.printStackTrace();
					
				}	
			}
			
			@Then("^Check_details_tab_without_entering_details$")
			public void Check_details_tab_without_entering_details() throws Throwable
			{
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
				
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Offer Name')]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Description')]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Offer Type')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'Balance Deduction')]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Channel')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'SMS')]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Category')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'Balance Top ups')]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Currency')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'INR')]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Discount')]"))).click().sendKeys("20").build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
				
				
				//WebElement error_msg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-input-error[contains(.,'This field is required.')]")));
				WebElement error_msg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='paper-input-add-on-6']")));
				
				if(error_msg.isDisplayed())
						actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Cancel')]"))).click().build().perform();
					
				else 
					throw new Exception("Offer created without invalid details tab");
				
			}
			
			@Then("^Check_add_button_in_product_tab$")
			public void Check_add_button_in_product_tab() throws Throwable
			{
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
				
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Offer Name')]"))).click().sendKeys("name").build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Description')]"))).click().sendKeys("desc").build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Offer Type')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'Balance Deduction')]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Channel')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'SMS')]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Category')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'Balance Top ups')]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Currency')]"))).click().build().perform();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'INR')]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Discount')]"))).click().sendKeys("20").build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
				
				WebElement Add_button=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='check']/div/iron-pages/offer-products/form/div/div[2]/paper-button")));
				if(Add_button.isDisplayed())
						actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Cancel')]"))).click().build().perform();
					
				else 
					throw new NoSuchElementException("Add button is not displayed in the products tab");
					
			}
			
			@Then("^Check_filter_operation_in_products_tab$")
			public void Check_filter_operation_in_products_tab() throws Throwable
			{
				String product_name = "prod_2test_filterTab";
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
				Thread.sleep(2000);
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Offer Name')]"))).click().sendKeys("Offer_to_check_language_selec").build().perform();
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
//click on filter button****************
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='check']/div/iron-pages/offer-products/form/div/div[2]/paper-button"))).click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
				Thread.sleep(2000);
//Checking Product name field***********
				actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Product Name')]"))).sendKeys(product_name).build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
				Thread.sleep(2000);
					
				WebElement filtered_offer_1 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[1]/data-table-row/div[1]/data-table-cell[1]/span"));
				WebElement filtered_offer_2 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[2]/data-table-row/div[1]/data-table-cell[1]/span"));
				WebElement filtered_offer_3 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[3]/data-table-row/div[1]/data-table-cell[1]/span"));
				WebElement filtered_offer_4 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[4]/data-table-row/div[1]/data-table-cell[1]/span"));
						
				if(filtered_offer_1.getText().toString().contains(product_name) && 
						filtered_offer_2.getText().toString().contains(product_name) && 
							filtered_offer_3.getText().toString().contains(product_name) && 
								filtered_offer_4.getText().toString().contains(product_name))
				{
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
					Thread.sleep(2000);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
					Thread.sleep(2000);
					actions.moveToElement(driver.findElement(By.xpath("//div[@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[3]"))).click().sendKeys("20").build().perform();
					actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
					Thread.sleep(1000);

					if (!(filtered_offer_1.getText().toString()).equals("prod_2test_filterTab_1"))
					{
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
						Thread.sleep(1000);
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
						Thread.sleep(1000);
						actions.moveToElement(driver.findElement(By.xpath("//div[@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[3]"))).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).build().perform();
						actions.moveToElement(driver.findElement(By.xpath("//div[@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[6]"))).click().sendKeys("30").build().perform();
						actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
						Thread.sleep(1000);
					} 
						if(!(filtered_offer_4.isDisplayed()))
						{
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
							Thread.sleep(1000);
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
							Thread.sleep(1000);
							actions.moveToElement(driver.findElement(By.xpath("//div[@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[6]"))).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).build().perform();
							actions.moveToElement(driver.findElement(By.xpath("//div[2][@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[3]"))).click().sendKeys("22").build().perform();
							actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
							Thread.sleep(1000);
						}
							if(!(filtered_offer_1.getText().toString().equals("prod_2test_filterTab_1")))
							{
								wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
								Thread.sleep(1000);
								wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
								Thread.sleep(1000);
								actions.moveToElement(driver.findElement(By.xpath("//div[2][@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[3]"))).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).build().perform();
								actions.moveToElement(driver.findElement(By.xpath("//div[2][@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[6]"))).click().sendKeys("32").build().perform();
								actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
								Thread.sleep(1000);
							}
						
								if(!(filtered_offer_4.isDisplayed()))
								{
									wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
									Thread.sleep(1000);
									wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
									Thread.sleep(1000);
									actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Service Leg')]"))).click().sendKeys("Data 2G").build().perform();
									actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
									Thread.sleep(2000);
								}
									if(!filtered_offer_2.isDisplayed())
									{
										actions.moveToElement(driver.findElement(By.xpath("//*[@id='productDialog']/div[2]/paper-button[1]"))).click().build().perform();
										actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Cancel')]"))).click().build().perform();
										Thread.sleep(2000);
									}
				}
				
				
			}
			

}
