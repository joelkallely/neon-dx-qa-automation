package stepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.ExcelHelper;
import baseClasses.browserInit;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class productPageSteps extends browserInit {
	WebDriverWait wait = new WebDriverWait(driver, 5);
	public ExcelHelper eh = new ExcelHelper();
	
	@Then("^create single product from sheet \"([^\"]*)\"$")
    public void singleProduct(String sheet) throws AWTException, InterruptedException, IOException {
		eh.setExcelFile("inputData",sheet);
		Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		String name = (String) eh.getCell(1, 0);
		name =  name.replaceAll("[0-9]", "")+n;
		name= n+name;
		eh.setCell(1, 0, name);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1']"))).click();
		Thread.sleep(400);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Product')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Product Name')]/following::input[1]"))).sendKeys(eh.getCell(1, 0));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='textarea']"))).sendKeys(eh.getCell(1, 1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Category')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'"+eh.getCell(1, 2)+"')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Validity')]/following::input[1]"))).sendKeys(eh.getCell(1, 3));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Price')]/following::input[1]"))).sendKeys(eh.getCell(1, 4));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Processing Fee')]/following::input[1]"))).sendKeys(eh.getCell(1, 5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Service Tax')]/following::input[1]"))).sendKeys(eh.getCell(1, 6));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Short Description')]/following::input[1]"))).sendKeys(eh.getCell(1, 7));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Usage Leg')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'"+eh.getCell(1, 8)+"')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Type')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'"+eh.getCell(1, 9)+"')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Value')]/following::input[1]"))).sendKeys(eh.getCell(1, 10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[3]/paper-button[contains(.,'Save')]"))).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='toast']/span[contains(.,'Product saved successfully.')]"))).click();

	
	}
	
	@Then("^create new product from sheet \"([^\"]*)\"$")
    public void newProduct(String sheet) throws AWTException, InterruptedException, IOException {
		eh.setExcelFile("inputData",sheet);
		//String value = "";
		int rows = eh.numRows();
		System.out.println("number of rows:"+rows);
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1']"))).click();
		for(int i=1;i<rows;i++){
			Thread.sleep(3000);
			Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		String name = (String) eh.getCell(i, 0);
		name =  name.replaceAll("[0-9]", "")+n;
		name= n+name;
		eh.setCell(i, 0, name);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Product')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Product Name')]/following::input[1]"))).sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='textarea']"))).sendKeys(eh.getCell(i, 1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Category')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 2)+"')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Validity')]/following::input[1]"))).sendKeys(eh.getCell(i, 3));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Price')]/following::input[1]"))).sendKeys(eh.getCell(i, 4));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Processing Fee')]/following::input[1]"))).sendKeys(eh.getCell(i, 5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Service Tax')]/following::input[1]"))).sendKeys(eh.getCell(i, 6));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Short Description')]/following::input[1]"))).sendKeys(eh.getCell(i, 7));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Usage Leg')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 8)+"')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Type')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 9)+"')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Value')]/following::input[1]"))).sendKeys(eh.getCell(i, 10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[3]/paper-button[contains(.,'Save')]"))).click();
		Thread.sleep(200);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='toast']/span[contains(.,'Product saved successfully.')]"))).click();


		Thread.sleep(2000);
		}
	}
	@Then("^delete product$")
    public void deleteProduct() throws Exception {
		eh.setExcelFile("inputData","singleProductPage");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		Exception e = new Exception("product not deleted");
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='filterForm']/paper-input[1]/paper-input-container/div[1]/../div[2]/div[1]/input[1]"))).sendKeys(eh.getCell(1, 0));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='filterDialog']/div/paper-button[3]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../.."))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='contentWrapper']/div/paper-menu/div/paper-item[2]"))).click();
		Thread.sleep(2000);
		try{
			driver.findElement(By.xpath("//span[contains(.,'"+eh.getCell(1, 0)+"')]/../../data-table-cell[3][contains(.,'"+eh.getCell(1, 8)+"')]/../data-table-cell[2][contains(.,'"+eh.getCell(1, 2)+"')]/../data-table-cell[4][contains(.,'"+eh.getCell(1, 11)+"')]/../data-table-cell[5][contains(.,'"+eh.getCell(1, 4)+"')]/../data-table-cell[6][contains(.,'"+eh.getCell(1, 3)+"')]/../data-table-cell[7][contains(.,'"+eh.getCell(1, 7)+"')]"));
			throw e;
		}catch(Exception exp){
			
		}
	}
	@Then("^enter special characters for name and validate$")
    public void enterSpecialCharacterForName() throws AWTException, InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		char[] specialChars = {'<',';','>','\'','\"'};
		int pass=1;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Product')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='textarea']"))).sendKeys("Checking cross site scripting in creation of new product under CLV Max");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Category')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Combo Vouchers')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Validity')]/following::input[1]"))).sendKeys("31");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Price')]/following::input[1]"))).sendKeys("199");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Processing Fee')]/following::input[1]"))).sendKeys("3");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Service Tax')]/following::input[1]"))).sendKeys("3");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Short Description')]/following::input[1]"))).sendKeys("Checking cross site scripting");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Usage Leg')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Data 2G')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Type')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Data MB')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Value')]/following::input[1]"))).sendKeys("223");
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='style-scope add-product x-scope paper-button-0']"))).click();
	    //Thread.sleep(3000);
		for(int i=0;i<=4;i++){
		try{
		Thread.sleep(1500);
		driver.findElement(By.xpath("//label[contains(.,'Product Name')]/following::input[1]")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "SpecialCharTest"+specialChars[i]);	
		driver.findElement(By.xpath("//*[@id='modal']/div[3]/paper-button[contains(.,'Save')]']")).click();
		if(driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/paper-input[1]/paper-input-container/div[4]/paper-input-error[@invalid='']")).isDisplayed())
		pass=1;
		
		}
		catch(NoSuchElementException e)
		{
			//System.out.println(e.toString());
			pass=0;
		}
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Product Name')]/following::input[1]"))).sendKeys("");
		}
		if(pass==1)
			System.out.println("pass");
		else
			System.out.println("fail");
		
	}
	@Then("^enter valid details and click cancel$")
    public void enterDetailAndCancel() throws AWTException {
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Product')]"))).click();
		driver.findElement(By.xpath("//label[contains(.,'Product Name')]/following::input[1]")).sendKeys("enterDetails-Cancel");	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='textarea']"))).sendKeys("Checking cross site scripting in creation of new product under CLV Max");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Category')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Combo Vouchers')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Validity')]/following::input[1]"))).sendKeys("31");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Price')]/following::input[1]"))).sendKeys("199");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Processing Fee')]/following::input[1]"))).sendKeys("3");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Service Tax')]/following::input[1]"))).sendKeys("3");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Short Description')]/following::input[1]"))).sendKeys("Checking cross site scripting");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Usage Leg')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Data 2G')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Type')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Data MB')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Value')]/following::input[1]"))).sendKeys("223");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[3]/paper-button[contains(.,'Cancel')]"))).click();
		
	}
	@Then("^check if offer is saved$")
    public void checkIfOfferExists() throws AWTException {
		driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")).click();
		driver.findElement(By.xpath("//*[@id='filterForm']/paper-input[1]/paper-input-container/div[1]/../div[2]/div[1]/input[1]")).sendKeys("enterDetails-Cancel");
		driver.findElement(By.xpath("//*[@id='filterDialog']/div/paper-button[3]")).click();
		int pass=0;
		try{
			driver.findElement(By.xpath("//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z/../../..']"));
		}catch(NoSuchElementException e){
			pass=1;
		}
		if(pass==1)
		System.out.println("Product not Saved\n PASS");
		else
			System.out.println("FAIL");
	}
	@Then("^create product having multiple benefits with same usage leg and type combinations$")
    public void productWithMultipleBenefits() throws AWTException, InterruptedException {
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1']"))).click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Product')]"))).click();
		driver.findElement(By.xpath("//label[contains(.,'Product Name')]/following::input[1]")).sendKeys("enterDetails-Cancel");	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='textarea']"))).sendKeys("Checking cross site scripting in creation of new product under CLV Max");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Category')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Combo Vouchers')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Validity')]/following::input[1]"))).sendKeys("31");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Price')]/following::input[1]"))).sendKeys("199");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Processing Fee')]/following::input[1]"))).sendKeys("3");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Service Tax')]/following::input[1]"))).sendKeys("3");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Short Description')]/following::input[1]"))).sendKeys("Checking cross site scripting");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Usage Leg')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Data 2G')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Type')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Data MB')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Value')]/following::input[1]"))).sendKeys("223");
		 
		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/paper-button[contains(.,'Add')]")).click();
		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/benefit-form[2]/form/paper-material/paper-dropdown-menu[1]/paper-menu-button/div[1]/div[1]/paper-input/paper-input-container/div[2]/div[1]/input")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[2]/div[2]/benefit-form[2]/form/paper-material/paper-dropdown-menu/paper-menu-button/iron-dropdown/div[1]/div[1]/paper-listbox/paper-item[1]"))).click();
		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/benefit-form[2]/form/paper-material/paper-dropdown-menu[2]/paper-menu-button/div[1]/div[1]/paper-input/paper-input-container/div[2]/div[1]/input")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[2]/div[2]/benefit-form[2]/form/paper-material/paper-dropdown-menu[2]/paper-menu-button/iron-dropdown/div[1]/div[1]/paper-listbox/paper-item[1]"))).click();
		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/benefit-form[2]/form/paper-material/paper-input")).sendKeys("223");
		int pass=0;
		NoSuchElementException ee = new NoSuchElementException("no element");
		try{
			Thread.sleep(1500);
			if(driver.findElement(By.xpath("//paper-input-error[contains(.,'This field is required') and @invalid='']")).isDisplayed()){
			pass=1;
			}
			System.out.println("inside try"+pass);
			}
			catch(NoSuchElementException e)
			{
				System.out.println(e.toString());
				pass=0;
				System.out.println("inside catch"+pass);
			}
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Product Name')]/following::input[1]"))).sendKeys("");
		System.out.println("outside catch try"+pass);
			if(pass==1)
				System.out.println("pass");
			else{
				System.out.println("fail");
				throw ee;
			}
			
	}
	@Then("^verify saving the product without adding benefits$")
    public void productWithoutBenefits() throws AWTException, InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Product')]"))).click();
		driver.findElement(By.xpath("//label[contains(.,'Product Name')]/following::input[1]")).sendKeys("enterDetails-Cancel");	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='textarea']"))).sendKeys("Checking cross site scripting in creation of new product under CLV Max");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Category')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Combo Vouchers')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Validity')]/following::input[1]"))).sendKeys("31");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Price')]/following::input[1]"))).sendKeys("199");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Processing Fee')]/following::input[1]"))).sendKeys("3");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Service Tax')]/following::input[1]"))).sendKeys("3");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Short Description')]/following::input[1]"))).sendKeys("Checking cross site scripting");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[3]/paper-button[contains(.,'Save')]"))).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//paper-input-error[contains(.,'This field is required') and @invalid='']")).isDisplayed();

	}
	@Then("^saving product with multiple benefits$")
    public void saveProductWithMultipleBenefits() throws AWTException, InterruptedException {
		Random rand = new Random();

		int  n = rand.nextInt(5000) + 1;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1']"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Product')]"))).click();
		driver.findElement(By.xpath("//label[contains(.,'Product Name')]/following::input[1]")).sendKeys("multipleBenefit_Check"+n);	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='textarea']"))).sendKeys("Checking cross site scripting in creation of new product under CLV Max");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Category')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Combo Vouchers')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Validity')]/following::input[1]"))).sendKeys("31");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Price')]/following::input[1]"))).sendKeys("199");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Processing Fee')]/following::input[1]"))).sendKeys("3");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Service Tax')]/following::input[1]"))).sendKeys("3");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Short Description')]/following::input[1]"))).sendKeys("Checking cross site scripting");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Usage Leg')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Data 2G')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Type')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Data MB')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Value')]/following::input[1]"))).sendKeys("223");
		 
		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/paper-button[contains(.,'Add')]")).click();
		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/benefit-form[2]/form/paper-material/paper-dropdown-menu[1]/paper-menu-button/div[1]/div[1]/paper-input/paper-input-container/div[2]/div[1]/input")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[2]/div[2]/benefit-form[2]/form/paper-material/paper-dropdown-menu/paper-menu-button/iron-dropdown/div[1]/div[1]/paper-listbox/paper-item[1]"))).click();
		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/benefit-form[2]/form/paper-material/paper-dropdown-menu[2]/paper-menu-button/div[1]/div[1]/paper-input/paper-input-container/div[2]/div[1]/input")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[2]/div[2]/benefit-form[2]/form/paper-material/paper-dropdown-menu[2]/paper-menu-button/iron-dropdown/div[1]/div[1]/paper-listbox/paper-item[2]"))).click();
		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/benefit-form[2]/form/paper-material/paper-input")).sendKeys("223");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[3]/paper-button[contains(.,'Save')]"))).click();
	}
	@Then("^check field validations under the benefits gridk$")
    public void fieldValidationBenefits() throws AWTException, InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Product')]"))).click();
		driver.findElement(By.xpath("//label[contains(.,'Product Name')]/following::input[1]")).sendKeys("multipleBenefit_Check");	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='textarea']"))).sendKeys("Checking cross site scripting in creation of new product under CLV Max");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Category')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Combo Vouchers')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Validity')]/following::input[1]"))).sendKeys("31");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Price')]/following::input[1]"))).sendKeys("199");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Processing Fee')]/following::input[1]"))).sendKeys("3");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Service Tax')]/following::input[1]"))).sendKeys("3");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Short Description')]/following::input[1]"))).sendKeys("aaaaa11111111111111111111aaaaa11111");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Usage Leg')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Data 2G')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Type')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Data MB')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Value')]/following::input[1]"))).sendKeys("qw223");
		String s = driver.findElement(By.xpath("//label[contains(.,'Value')]/following::input[1]")).getAttribute("value");
		System.out.println(s);
		
	}
	@Then("^verify adding more than 3 benefits for product$")
    public void moreThan3Benefits() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Product')]"))).click();
		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/paper-button[contains(.,'Add')]")).click();
		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/paper-button[contains(.,'Add')]")).click();
		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/paper-button[contains(.,'Add')]")).click();
		boolean disp = driver.findElement(By.xpath("//*[@id='toast']")).isDisplayed();
		Exception noErrorMessage = new Exception("no error message on adding fourth benefit");
		if(disp){
			System.out.println("pass");
		}
		else{
			System.out.println("fail");
			throw noErrorMessage;
		}
	}
	@Then("^clicking on the Add button to add benefits for the product$")
    public void addBenefit() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Product')]"))).click();
		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/paper-button[contains(.,'Add')]")).click();
		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/benefit-form[2]/form/paper-material/paper-dropdown-menu[1]/paper-menu-button/div[1]/div[1]/paper-input/paper-input-container/div[2]/div[1]/input")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[2]/div[2]/benefit-form[2]/form/paper-material/paper-dropdown-menu/paper-menu-button/iron-dropdown/div[1]/div[1]/paper-listbox/paper-item[1]"))).click();
		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/benefit-form[2]/form/paper-material/paper-dropdown-menu[2]/paper-menu-button/div[1]/div[1]/paper-input/paper-input-container/div[2]/div[1]/input")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[2]/div[2]/benefit-form[2]/form/paper-material/paper-dropdown-menu[2]/paper-menu-button/iron-dropdown/div[1]/div[1]/paper-listbox/paper-item[2]"))).click();
		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/benefit-form[2]/form/paper-material/paper-input")).sendKeys("223");
		
	}
	@Then("^saving the products by not adding the mandatory fields$")
    public void saveWithoutMandatoryFields() throws Exception {
		Random r = new Random();
		int n = r.nextInt(5000)+1;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1']"))).click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Product')]"))).click();	
		driver.findElement(By.xpath("//label[contains(.,'Product Name')]/following::input[1]")).sendKeys("multipleBenefit_Check"+n);	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[3]/paper-button[contains(.,'Save')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Category')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Combo Vouchers')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[3]/paper-button[contains(.,'Save')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Validity')]/following::input[1]"))).sendKeys("31");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[3]/paper-button[contains(.,'Save')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Price')]/following::input[1]"))).sendKeys("199");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[3]/paper-button[contains(.,'Save')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Short Description')]/following::input[1]"))).sendKeys("aaaaa11111111111111111111aaaaa11111");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[3]/paper-button[contains(.,'Save')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Usage Leg')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Data 2G')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[3]/paper-button[contains(.,'Save')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Type')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Data MB')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[3]/paper-button[contains(.,'Save')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Value')]/following::input[1]"))).sendKeys("223");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[3]/paper-button[contains(.,'Save')]"))).click();
		Thread.sleep(200);
		try{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='toast']/span[contains(.,'Product saved successfully.')]"))).click();

		}
		catch(Exception e)
		{
			System.out.println("fail");
			throw e;
		}	
	}
	@Then("^field validations for the Basic Information$")
    public void basicFieldValidation() throws Exception {
		String str300 = "";
		for(int i=0;i<500;i++)
			str300+='a';
		for(int i=0;i<100;i++)
			str300+='b';
		String str30 = "";
		for(int i=0;i<30;i++)
			str30+='a';
		for(int i=0;i<10;i++)
			str30+='b';
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Product')]"))).click();
		driver.findElement(By.xpath("//label[contains(.,'Product Name')]/following::input[1]")).sendKeys(str30);	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='textarea']"))).sendKeys(str300);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Category')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Combo Vouchers')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Validity')]/following::input[1]"))).sendKeys("31bbb");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Price')]/following::input[1]"))).sendKeys("bbb199");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Processing Fee')]/following::input[1]"))).sendKeys("bbb3");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Service Tax')]/following::input[1]"))).sendKeys("bbb3");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Short Description')]/following::input[1]"))).sendKeys("aaaaa11111111111111111111aaaaa11111");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Usage Leg')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Data 2G')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Type')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Data MB')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Value')]/following::input[1]"))).sendKeys("2bbb3");
		int pass=0;
		try{
		String nn = driver.findElement(By.xpath("//*[@id='textarea']/../../div[1][contains(.,'b')]")).getText();
		pass=0;
		}
		catch(NoSuchElementException e)
		{
			pass=1;
		}
		try{
			String nn = driver.findElement(By.xpath("//label[contains(.,'Product Name')]/following::input[1]/../../div[1][contains(.,'b')]")).getText();
			pass=0;
			}
			catch(NoSuchElementException e)
			{
				pass=1;
			}
		
		String[] numericCheck={"Price","Validity","Processing Fee","Service Tax","Value"};
		for(int i=0;i<5;i++)
		{
			try{
				String nn = driver.findElement(By.xpath("//label[contains(.,'"+numericCheck[i]+"Value')]/following::input[1]/../../div[1][contains(.,'b')]")).getText();
				pass=0;
				}
				catch(NoSuchElementException e)
				{
					pass=1;
				}
		}
		
		if(pass==0)
		{
			Exception e = new Exception("field validation fail");
			throw e;
		}
	}
	//jgu
	@Then("^scrolling to view the entire product list$")
    public void scrollingInProductGrid() throws Exception {
		eh.setExcelFile("inputData","productPage");
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1']"))).click();
		Thread.sleep(2000);
		Actions clickAction = new Actions(driver);
        WebElement scrollablePane = driver.findElement(By.xpath("//*[@id='productGrid']/div[1]/iron-list"));
        clickAction.moveToElement(scrollablePane).click().build().perform();
        Actions scrollAction = new Actions(driver);
        for(int i=0;i<50;i++){
        scrollAction.sendKeys(Keys.PAGE_DOWN).perform();
        try{
        	driver.findElement(By.xpath("//span[contains(.,'"+eh.getCell(1, 0)+"')]"));
        	break;
        }
        catch(Exception e){
        	//System.out.println("inside catch");
        }
        Thread.sleep(1000);
        }
        driver.findElement(By.xpath("//span[contains(.,'"+eh.getCell(1, 0)+"')]"));
	}
	@Then("^verify product details displayed in the products screen$")
    public void verifyProductsGrid() throws Exception {
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1']"))).click();
		eh.setExcelFile("inputData","singleProductPage");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")).click();
		driver.findElement(By.xpath("//*[@id='filterForm']/paper-input[1]/paper-input-container/div[1]/../div[2]/div[1]/input[1]")).sendKeys(eh.getCell(1, 0));
		driver.findElement(By.xpath("//*[@id='filterDialog']/div/paper-button[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(.,'"+eh.getCell(1, 0)+"')]/../../data-table-cell[3][contains(.,'"+eh.getCell(1, 8)+"')]/../data-table-cell[2][contains(.,'"+eh.getCell(1, 2)+"')]/../data-table-cell[4][contains(.,'"+eh.getCell(1, 11)+"')]/../data-table-cell[5][contains(.,'"+eh.getCell(1, 4)+"')]/../data-table-cell[6][contains(.,'"+eh.getCell(1, 3)+"')]/../data-table-cell[7][contains(.,'"+eh.getCell(1, 7)+"')]"));
	}
	
	@Then("^check if  the filter option is saving data after cancel$")
	public void check_filter_cancel_button() throws Exception{
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")).click();
		driver.findElement(By.xpath("//*[@id='filterForm']/paper-input[1]/paper-input-container/div[1]/../div[2]/div[1]/input[1]")).sendKeys("product_check");
		driver.findElement(By.xpath("//*[@id='filterDialog']/div/paper-button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")).click();
		driver.findElement(By.xpath("//*[@id='filterForm']/paper-input[1]/paper-input-container/div[1]/../div[2]/div[1]/input[1]")).click();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		StringSelection stringSelection = new StringSelection("checkText");
		clipboard.setContents(stringSelection, null);
		driver.findElement(By.xpath("//*[@id='filterForm']/paper-input[1]/paper-input-container/div[1]/../div[2]/div[1]/input[1]")).sendKeys(Keys.CONTROL,"a");
		driver.findElement(By.xpath("//*[@id='filterForm']/paper-input[1]/paper-input-container/div[1]/../div[2]/div[1]/input[1]")).sendKeys(Keys.CONTROL,"c");
		Exception e = new Exception("value stored after cancel  button is pressed");
		
		
		String result = (String) clipboard.getData(DataFlavor.stringFlavor);
		System.out.println("String from Clipboard:" + result);
		if(result.matches("checkText"))
			System.out.println("pass");
		else
			throw e;
	}
	@Then("^create new segmented product from sheet \"([^\"]*)\"$")
    public void newSegmentedProduct(String sheet) throws AWTException, InterruptedException, IOException {
		eh.setExcelFile("inputData",sheet);
		int rows = eh.numRows();
		System.out.println("number of rows:"+rows);
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1']"))).click();
		for(int i=1;i<rows;i++){
			Thread.sleep(3000);
		Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		String name = (String) eh.getCell(i, 0)+n;
		name= n+name;
		eh.setCell(i, 0, name);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Product')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Product Name')]/following::input[1]"))).sendKeys(eh.getCell(i, 0));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='textarea']"))).sendKeys(eh.getCell(i, 1));
		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/paper-radio-group/paper-radio-button[2]/div[2]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Category')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 2)+"')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Validity')]/following::input[1]"))).sendKeys(eh.getCell(i, 3));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Price')]/following::input[1]"))).sendKeys(eh.getCell(i, 4));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Processing Fee')]/following::input[1]"))).sendKeys(eh.getCell(i, 5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Service Tax')]/following::input[1]"))).sendKeys(eh.getCell(i, 6));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Short Description')]/following::input[1]"))).sendKeys(eh.getCell(i, 7));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Usage Leg')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 8)+"')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Type')]/following::input[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'"+eh.getCell(i, 9)+"')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Value')]/following::input[1]"))).sendKeys(eh.getCell(i, 10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[3]/paper-button[contains(.,'Save')]"))).click();
	    Thread.sleep(3000);
		}
	}
	@Then("^check if offer is shown in view offers$")
    public void check_offer_in_view_offer() throws AWTException, InterruptedException {
		eh.setExcelFile("inputData","singleProductPage");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")).click();
		driver.findElement(By.xpath("//*[@id='filterForm']/paper-input[1]/paper-input-container/div[1]/../div[2]/div[1]/input[1]")).sendKeys(eh.getCell(1, 0));
		driver.findElement(By.xpath("//*[@id='filterDialog']/div/paper-button[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../..")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='contentWrapper']/div/paper-menu/div/paper-item[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='offer-view style-scope'][2][contains(.,'"+eh.getCell(1, 12)+"')]"));
		
	}
	@Then("^check duplicate product functionality$")
    public void check_duplicate_product_functionality() throws AWTException, InterruptedException {
		eh.setExcelFile("inputData","singleProductPage");
		Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")).click();
		driver.findElement(By.xpath("//*[@id='filterForm']/paper-input[1]/paper-input-container/div[1]/../div[2]/div[1]/input[1]")).sendKeys(eh.getCell(1, 0));
		driver.findElement(By.xpath("//*[@id='filterDialog']/div/paper-button[3]")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../.."))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='contentWrapper']/div/paper-menu/div/paper-item[3]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Product Name')]/following::input[1]"))).sendKeys("Dupe"+n);
	    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Type')]/following::input[1]"))).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Minutes')]"))).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Value')]/following::input[1]"))).sendKeys("2bbb3");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[3]/paper-button[contains(.,'Save')]"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(.,'"+eh.getCell(1, 0)+"Dupe"+n+"')]/../../data-table-cell[3][contains(.,'"+eh.getCell(1, 8)+"')]/../data-table-cell[2][contains(.,'"+eh.getCell(1, 2)+"')]/../data-table-cell[4][contains(.,'"+eh.getCell(1, 11)+"')]/../data-table-cell[5][contains(.,'"+eh.getCell(1, 4)+"')]/../data-table-cell[6][contains(.,'"+eh.getCell(1, 3)+"')]/../data-table-cell[7][contains(.,'"+eh.getCell(1, 7)+"')]"));

	}
	@Then("^check edit product functionality$")
    public void check_edit_product_functionality() throws AWTException, InterruptedException, IOException {
		eh.setExcelFile("inputData","singleProductPage");
		Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		String name = (String) eh.getCell(1, 0);
		//name =  name.replaceAll("[0-9]", "")+n;
		//name= n+name;
		//eh.setCell(1, 0, name);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")).click();
		driver.findElement(By.xpath("//*[@id='filterForm']/paper-input[1]/paper-input-container/div[1]/../div[2]/div[1]/input[1]")).sendKeys(eh.getCell(1, 0));
		driver.findElement(By.xpath("//*[@id='filterDialog']/div/paper-button[3]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//span[contains(.,'"+eh.getCell(1, 0)+"')]/../../data-table-cell[3][contains(.,'"+eh.getCell(1, 8)+"')]/../data-table-cell[2][contains(.,'"+eh.getCell(1, 2)+"')]/../data-table-cell[4][contains(.,'"+eh.getCell(1, 11)+"')]/../data-table-cell[5][contains(.,'"+eh.getCell(1, 4)+"')]/../data-table-cell[6][contains(.,'"+eh.getCell(1, 3)+"')]/../data-table-cell[7][contains(.,'"+eh.getCell(1, 7)+"')]"));
	
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../.."))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='contentWrapper']/div/paper-menu/div/paper-item[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Product Name')]/following::input[1]"))).sendKeys("Edit"+n);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='textarea']"))).sendKeys("Edit");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Short Description')]/following::input[1]"))).sendKeys("Edit");
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Type')]/following::input[1]"))).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'Minutes')]"))).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Value')]/following::input[1]"))).sendKeys("2bbb3");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal']/div[3]/paper-button[contains(.,'Save')]"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(.,'"+eh.getCell(1, 0)+"Edit"+n+"')]"));

	}
	@Then("^verify clicking on options icon$")
    public void verify_clicking_options_icon() throws Exception {
		Exception e = new Exception("options not found in options menu");
		Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		Thread.sleep(1000);
		List<WebElement> ele = driver.findElements(By.xpath("//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../.."));
		List<WebElement> button1 = driver.findElements(By.xpath("//*[@id='contentWrapper']/div/paper-menu/div/paper-item[1]"));
		List<WebElement> button2 = driver.findElements(By.xpath("//*[@id='contentWrapper']/div/paper-menu/div/paper-item[2]"));
		List<WebElement> button3 = driver.findElements(By.xpath("//*[@id='contentWrapper']/div/paper-menu/div/paper-item[3]"));
		List<WebElement> button4 = driver.findElements(By.xpath("//*[@id='contentWrapper']/div/paper-menu/div/paper-item[4]"));
		
		Iterator<WebElement> iter = ele.iterator();
		Iterator<WebElement> iter1 = button1.iterator();
		Iterator<WebElement> iter2 = button2.iterator();
		Iterator<WebElement> iter3 = button3.iterator();
		Iterator<WebElement> iter4 = button4.iterator();
		int i = 0;
		while(iter.hasNext()) {
			i++;
			Thread.sleep(1000);
		    WebElement we = iter.next();
		    WebElement we1 = iter1.next();
		    WebElement we2 = iter2.next();
		    WebElement we3 = iter3.next();
		    WebElement we4 = iter4.next();
		    we.click();
		    Thread.sleep(1000);
		    if( we1.isDisplayed()  && we2.isDisplayed() && we3.isDisplayed() && we4.isDisplayed()){
		    	
		    }
		    else
		    	 throw e;
		    
		    driver.findElement(By.xpath(".//*[@id='item"+i+"']/div[1]/data-table-cell[3]")).click();
		  
		}
	}
	@Then("^check script in product name field \"([^\"]*)\"$")
    public void check_script_in_product_name_field(String script) throws Exception {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")).click();
		driver.findElement(By.xpath("//*[@id='filterForm']/paper-input[1]/paper-input-container/div[1]/../div[2]/div[1]/input[1]")).sendKeys(script);
		driver.findElement(By.xpath("//*[@id='filterDialog']/div/paper-button[3]")).click();
		Thread.sleep(2000);
		Exception e = new Exception("data displayed after script");
		if(driver.findElement(By.xpath(".//*[@id='item1']/div[1]/data-table-cell[1]/span")).isDisplayed())
			throw e;
		  
	}
}
	



