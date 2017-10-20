package stepDefinitions;

import java.awt.RenderingHints.Key;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.Set;
import com.steadystate.css.util.ThrowCssExceptionErrorHandler;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import baseClasses.ExcelHelper;
import baseClasses.browserInit;
import net.sourceforge.htmlunit.corejs.javascript.ast.ThrowStatement;

public class Offer_catalogue extends browserInit
{   public ExcelHelper eM = new ExcelHelper(); 
    public WebDriverWait wait = new WebDriverWait(driver, 15);
    public Actions action = new Actions(driver);
    
    
   @Then("^Navigate to Offer Management$")
    public void navigateToOfferManagement() throws Throwable{
    	
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mainContainer']/paper-menu/div/hexagon-icon[4]/label"))).click();
    	
   }
   @Then("^Navigate to Offer Catalogue$")
    public void navigatetoOfferCatalogue() throws Throwable{
	   
	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1' and @icon='app-primary:offer-catalogue']"))).click();
	   Thread.sleep(2000);
    }
   
   @Then("^Create New Offer Catalogue$")
   
   public void createNewOfferCatalogue() throws Throwable{
	   
	   eM.setExcelFile("Sheet1");
	   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='router']/app-route[17]/offer-catalogue-grid/div[1]/div[2]/paper-button")))).click();
	   driver.findElement(By.xpath("//div[2]/paper-input[1]/paper-input-container/div[2]/div/input")).sendKeys(eM.getCell(0, 0));
	   driver.findElement(By.xpath("//paper-input[2]/paper-input-container/div[2]/div/input")).sendKeys("test");
	   driver.findElement(By.xpath("//div[3]/paper-button[2]")).click();
	   Thread.sleep(3000);
	   }
   @Then("^Add offer to Offer Catalogue$")
   public void addOffertoCatalogue() throws Throwable
   {
	   
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//paper-button[contains(text(),'Add Offers')]")).click();
	 Thread.sleep(2000);
	 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")))).click();
	 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//form/paper-input[1]/paper-input-container/div[2]/div/input")))).sendKeys(eM.getCell(1, 0));
	 driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]")).click();
	 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//data-table-cell[text()='"+eM.getCell(1, 0)+"']")))).click();
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[text()='Add to Catalog']"))).click();
	 Thread.sleep(5000);
   }
   @Then("^Delete Created Offer Catalogue$")
   public void deleteOfferCatalogue() throws Throwable
   {
   	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mainContainer']/paper-menu/div/hexagon-icon[4]/label"))).click();
   	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1' and @icon='app-primary:offer-catalogue']"))).click();
   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")))).click();
   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//form/paper-input/paper-input-container/div[2]/div/input")))).sendKeys(eM.getCell(0, 0));
   	driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]")).click();
   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../..")))).click();
   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='contentWrapper']/div/paper-menu/div/paper-item[2]")))).click();
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//paper-button[contains(text(),'Yes')]")))).click();  
   }
   
   @Then("^Cancel the New offer Catalogue$")
   public void cancelnewOfferCatalogue() throws Throwable
   
   {   eM.setExcelFile("Sheet1");
	   //System.out.print(eM.getCell(0, 0));
	   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='router']/app-route[17]/offer-catalogue-grid/div[1]/div[2]/paper-button")))).click();
	   driver.findElement(By.xpath("//div[2]/paper-input[1]/paper-input-container/div[2]/div/input")).sendKeys(eM.getCell(0, 0));
	   driver.findElement(By.xpath("//paper-input[2]/paper-input-container/div[2]/div/input")).sendKeys("test");  
	   driver.findElement(By.xpath(" //*[@id='modal']/div[3]/paper-button[1]")).click();
	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mainContainer']/paper-menu/div/hexagon-icon[4]/label"))).click();
	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1' and @icon='app-primary:offer-catalogue']"))).click();
	   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")))).click();
	   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//form/paper-input/paper-input-container/div[2]/div/input")))).sendKeys(eM.getCell(0, 0));
	   driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]")).click();
	   
	   int pass=0;
	   org.openqa.selenium.NoSuchElementException exx = new org.openqa.selenium.NoSuchElementException("no element");
	   try{
		   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//data-table-cell[text()='"+eM.getCell(0, 0)+"']"))));  
	   }
	   catch (org.openqa.selenium.NoSuchElementException e) {
		   pass=1;
		
	   }
	   if(pass==0){
		   throw exx;
	   }
	   }
   @Then("^Cancel Selected Offer$")
   public void cancelSelectedOffer() throws Throwable
   {
	   Thread.sleep(2000);
		 driver.findElement(By.xpath("//paper-button[contains(text(),'Add Offers')]")).click();
		 Thread.sleep(2000);
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//form/paper-input[1]/paper-input-container/div[2]/div/input")))).sendKeys(eM.getCell(1, 0));
		 driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]")).click();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//data-table-cell[text()='"+eM.getCell(1, 0)+"']")))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[2]/paper-button[2]")))).click();
		 int verify=0;
		 org.openqa.selenium.NoSuchElementException exception = new org.openqa.selenium.NoSuchElementException("No Elemnet");
		 try
		 {
			 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//catalogue-offer-listing/iron-data-table/div/iron-list/div/div/data-table-row/div[1]/data-table-cell[text()='"+eM.getCell(1, 0)+"']"))));
		 }
		 catch (org.openqa.selenium.NoSuchElementException e) {
			 
			 verify=1;
			
		}
		 if(verify==0)
		 {
			 throw exception;
		 }
   }
   
   @Then("^Add offers to Offer Catalogue$")
  public void addOffersToCatalogue() throws Throwable
  {
	   Thread.sleep(2000);
		 driver.findElement(By.xpath("//paper-button[contains(text(),'Add Offers')]")).click();
		 Thread.sleep(2000);
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//form/paper-input[1]/paper-input-container/div[2]/div/input")))).sendKeys(eM.getCell(1, 0));
		 driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]")).click();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//iron-list/div/div[1]/data-table-row/div[1]/data-table-cell[1]")))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//iron-list/div/div[2]/data-table-row/div[1]/data-table-cell[1]")))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//iron-list/div/div[3]/data-table-row/div[1]/data-table-cell[1]")))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[text()='Add to Catalog']"))).click();
		 Thread.sleep(4000);
	   
  }
   @Then("^Select Multiple Offers$")
   public void selectMultipleOffers() throws Throwable
   {
	   Thread.sleep(2000);
		 driver.findElement(By.xpath("//paper-button[contains(text(),'Add Offers')]")).click();
		 Thread.sleep(2000);
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//form/paper-input[1]/paper-input-container/div[2]/div/input")))).sendKeys(eM.getCell(1, 0));
		 driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]")).click();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//iron-list/div/div[1]/data-table-row/div[1]/data-table-checkbox")))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//iron-list/div/div[2]/data-table-row/div[1]/data-table-checkbox")))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//iron-list/div/div[3]/data-table-row/div[1]/data-table-checkbox")))).click();  
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[2]/paper-button[2]")))).click();
   }
   @Then("^Search Offers with Combination of details$")
   public void searchOffersUsingCobination() throws Throwable
   {
	   
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//paper-button[contains(text(),'Add Offers')]")).click();
		 Thread.sleep(2000);
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//form/paper-input[1]/paper-input-container/div[2]/div/input")))).sendKeys(eM.getCell(1, 0));
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//form/paper-input[2]/paper-input-container/div[2]/div/input")))).sendKeys(eM.getCell(2, 0));
		 driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]")).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]/data-table-row/div[1]/data-table-cell[2]/span[contains(.,'"+eM.getCell(2, 0)+"')]")));
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//paper-dialog/iron-data-table/div/iron-list/div/div[1]/data-table-row/div[1]/data-table-cell[contains(.,'"+eM.getCell(1, 0)+"')]"))));
		 Thread.sleep(4000);
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[2]/paper-button[2]")))).click();
		 
   }
   @Then("^Search Offers Using Service leg$")
   public void searchOffersUsingServiceLeg() throws Throwable
   {
	   //eM.setExcelFile("Sheet1");
	   Thread.sleep(2000);
		 driver.findElement(By.xpath("//paper-button[contains(text(),'Add Offers')]")).click();
		 Thread.sleep(2000);
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")))).click();
		 action.moveToElement(driver.findElement(By.xpath("//form/paper-input[3]/paper-input-container/div[2]/div/input"))).click().build().perform();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//form/paper-input[3]/paper-input-container/div[2]/div/input")))).sendKeys(eM.getCell(3, 0));
		// driver.findElement(By.xpath("//form/paper-input[3]/paper-input-container/div[2]/div/input")).sendKeys(eM.getCell(3, 0));
		 driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]")).click(); 
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div/div[1]/data-table-row/div[1]/data-table-cell[4]/span[contains(.,'"+eM.getCell(3, 0)+"')]"))));
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[2]/paper-button[2]")))).click();
   }
   @Then("^Cancel Selected Offers$")
   public void cancelSelectedOffers() throws Throwable
   {
	   Thread.sleep(2000);
		 driver.findElement(By.xpath("//paper-button[contains(text(),'Add Offers')]")).click();
		 Thread.sleep(2000);
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//form/paper-input[1]/paper-input-container/div[2]/div/input")))).sendKeys(eM.getCell(1, 0));
		 driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]")).click();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//iron-list/div/div[1]/data-table-row/div[1]/data-table-checkbox")))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//iron-list/div/div[2]/data-table-row/div[1]/data-table-checkbox")))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//iron-list/div/div[3]/data-table-row/div[1]/data-table-checkbox")))).click();  
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[2]/paper-button[2]")))).click();
		 int verifyoffers=0;
		 org.openqa.selenium.NoSuchElementException exception = new org.openqa.selenium.NoSuchElementException("No Elemnet");
		 try
		 {
			 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//catalogue-offer-listing/iron-data-table/div/iron-list/div/div/data-table-row/div[1]/data-table-cell[text()='"+eM.getCell(1, 0)+"']"))));
		 }
		 catch (org.openqa.selenium.NoSuchElementException e) {
			 
			 verifyoffers=1;
			
		}
		 if(verifyoffers==0)
		 {
			 throw exception;
		 }
  
   }
   @Then("^Select Offers Using Product Name$")
   public void selectUsingProductName() throws Throwable
   {

		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//paper-button[contains(text(),'Add Offers')]")).click();
		 Thread.sleep(2000);
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//form/paper-input[2]/paper-input-container/div[2]/div/input")))).sendKeys(eM.getCell(2, 0));
		 driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]")).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]/data-table-row/div[1]/data-table-cell[2]/span[contains(.,'"+eM.getCell(2, 0)+"')]")));
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[2]/paper-button[2]")))).click();
		 
   }
   
   @Then("^Search Offer Using Price$")
   public void searchUsingPrice() throws Throwable
   {
	   Thread.sleep(2000);
		 driver.findElement(By.xpath("//paper-button[contains(text(),'Add Offers')]")).click();
		 Thread.sleep(2000);
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div/paper-input[3]/paper-input-container/div[2]/div/input")))).sendKeys("49");
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div/paper-input[6]/paper-input-container/div[2]/div/input")))).sendKeys("51");
		 driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]")).click();
   }
   @Then("^Verify Added Catalogue$")
   public void verifyAddedCatalogue() throws Throwable
   {
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mainContainer']/paper-menu/div/hexagon-icon[4]/label"))).click();
	   	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1' and @icon='app-primary:offer-catalogue']"))).click();
	   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")))).click();
	   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//form/paper-input/paper-input-container/div[2]/div/input")))).sendKeys(eM.getCell(0, 0));
	   	driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]")).click();
	   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//iron-list/div/div[1]/data-table-row/div[1]/data-table-cell[contains(.,'"+eM.getCell(0, 0)+"')]"))));
   }
   @Then("^Validate Catalogue Name$")
   public void validateCatalogueName() throws Throwable
   {
	   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='router']/app-route[17]/offer-catalogue-grid/div[1]/div[2]/paper-button")))).click();
	   driver.findElement(By.xpath("//div[3]/paper-button[2]")).click();
	   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//paper-input-container/div[4]/paper-input-error[contains(.,'This field is required.')]"))));
   }
   @Then("^Add fifty more offers to Offer Catalogue$")
   public void addFiftyMoreOffers() throws Throwable
   {
	   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//paper-button[contains(text(),'Add Offers')]")))).click();
		 Thread.sleep(2000);
		 for (int i = 1; i < 14; i++) {
			 
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//iron-list/div/div["+i+"]/data-table-row/div[1]/data-table-cell[1]")))).click();
			
		}
		 
		 Thread.sleep(2000);
		 
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//iron-list/div/div[14]/data-table-row/div[1]/data-table-cell[1]")))).click();
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//iron-data-table[@id='selectOfferGrid']/div[1]/iron-list[1]")))).sendKeys(Keys.ARROW_UP);
		WebElement target= driver.findElement(By.xpath("//iron-list/div/div[14]/data-table-row/div[1]/data-table-cell[1]"));
		action.sendKeys(target, Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		for(int j=1; j<14; j++){
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//iron-list/div/div["+j+"]/data-table-row/div[1]/data-table-cell[1]")))).click();
		}
		Thread.sleep(2000);
		WebElement target1= driver.findElement(By.xpath("//iron-list/div/div[14]/data-table-row/div[1]/data-table-cell[1]"));
		action.sendKeys(target1, Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		for(int k=1; k<14; k++){
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//iron-list/div/div["+k+"]/data-table-row/div[1]/data-table-cell[1]")))).click();
		}
		Thread.sleep(2000);
		WebElement target2= driver.findElement(By.xpath("//iron-list/div/div[14]/data-table-row/div[1]/data-table-cell[1]"));
		action.sendKeys(target2, Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		for(int l=1; l<14; l++){
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//iron-list/div/div["+l+"]/data-table-row/div[1]/data-table-cell[1]")))).click();
		}
		Thread.sleep(2000);
		//WebElement target3= driver.findElement(By.xpath("//iron-list/div/div[14]/data-table-row/div[1]/data-table-cell[1]"));
		//action.sendKeys(target3, Keys.PAGE_DOWN).build().perform();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[text()='Add to Catalog']"))).click();
		 Thread.sleep(4000); 
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mainContainer']/paper-menu/div/hexagon-icon[4]/label"))).click();
		   	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1' and @icon='app-primary:offer-catalogue']"))).click();
		   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")))).click();
		   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//form/paper-input/paper-input-container/div[2]/div/input")))).sendKeys(eM.getCell(0, 0));
		   	driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]")).click();
		   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//iron-list/div/div[1]/data-table-row/div[1]/data-table-cell[contains(.,'54')]"))));
   }
   @Then("^Delete Offer from Catalogue$")
   public void deleteOffer() throws Throwable
   {
    Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[1]/data-table-cell[6]/paper-icon-button/iron-icon")))).click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mainContainer']/paper-menu/div/hexagon-icon[4]/label"))).click();
   	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1' and @icon='app-primary:offer-catalogue']"))).click();
   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")))).click();
   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//form/paper-input/paper-input-container/div[2]/div/input")))).sendKeys(eM.getCell(0, 0));
   	driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]")).click();
   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//iron-list/div/div[1]/data-table-row/div[1]/data-table-cell[contains(.,'0')]"))));
   }
   @Then("^Verify Help Of Offer Catalogue$")
   public void verifyHelp() throws Throwable
   {   
	   
	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//flytxt-context-help/paper-icon-button/iron-icon/img")))).click();
	   Thread.sleep(1500);
	   String secondUrl = driver.findElement(By.xpath("//paper-scroll-header-panel/div[1]/div/app-router/app-route[17]/offer-catalogue-grid/div[1]/div[1]/div/flytxt-context-help/paper-dialog/div/object")).getAttribute("data");
	   ((JavascriptExecutor)driver).executeScript("window.open()");
	   ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    driver.get(secondUrl);
	    driver.switchTo().frame(1);
	    try{
	    driver.findElement(By.xpath("//*[@id='topic_content']/h1[1]/span/span[contains(text(),'Offer Catalogs')]"));
	    driver.close();
	    driver.switchTo().window(tabs2.get(0));
	    }
	    catch (Exception e) {
	    	driver.close();
		    driver.switchTo().window(tabs2.get(0));
		    throw e;
		}
	   
	   driver.findElement(By.xpath("//offer-catalogue-grid/div[1]/div[1]/div/flytxt-context-help/paper-dialog/iron-icon")).click();
	   System.out.println(secondUrl);
	   
	   
   }
   @Then("^verify sql injection in offer catalogue$")
   public void verifysqlinjectionOfferCatalog() throws Throwable
   {
	   eM.setExcelFile("Sheet1");
	   try{
	   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")))).click();
	   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//form/paper-input/paper-input-container/div[2]/div/input")))).sendKeys(eM.getCell(4, 0));
	   	driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]")).click();
	   }
	   catch (Exception e) {
		throw e;
		
	}
	   int pass=0;
	   org.openqa.selenium.NoSuchElementException exx = new org.openqa.selenium.NoSuchElementException("no element");
	   try{
		   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//data-table-cell[text()='"+eM.getCell(4, 0)+"']"))));  
	   }
	   catch (org.openqa.selenium.NoSuchElementException e) {
		   pass=1;
		
	   }
	   if(pass==0){
		   throw exx;
	   }
	   	
   }
   @Then("^verify Cross site scripting in offer catalogue$")
   public void verifyCrossSiteScripting() throws Throwable
   {
	   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")))).click();
	   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//form/paper-input/paper-input-container/div[2]/div/input")))).sendKeys("<script>alert(document.cookies)</script>");
	   	driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]")).click();
   
   
   int pass=0;
   org.openqa.selenium.NoSuchElementException exx = new org.openqa.selenium.NoSuchElementException("no element");
   
   try{
	   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//data-table-cell[text()='<script>alert(document.cookies)</script>']"))));  
   }
   catch (org.openqa.selenium.NoSuchElementException e) {
	   pass=1;
	
   }
   if(pass==0){
	   throw exx;
   }
   
}
   @Then("^Verify Edit Offer Catalog$")
   public void verifyEditOfferCatalog()
   {
	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mainContainer']/paper-menu/div/hexagon-icon[4]/label"))).click();
	   	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1' and @icon='app-primary:offer-catalogue']"))).click();
	   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")))).click();
	   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//form/paper-input/paper-input-container/div[2]/div/input")))).sendKeys(eM.getCell(0, 0));
	   	driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]")).click();
	   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../..")))).click();
	   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='contentWrapper']/div/paper-menu/div/paper-item[1]")))).click();
	   	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//create-offer-catalogue/form/paper-dialog/div[2]/paper-input[1]/paper-input-container/div[2]/div/input")))).sendKeys("Cancel");
   }
}

