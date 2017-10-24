package baseClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonSteps extends browserInit {
	@Then("^navigate to products$")
	public void naviagte_to_products() throws Exception{
		driver.findElement(By.xpath("//*[@id='sym1']")).click();
	}
	@Then("^navigate to offers$")
	public void naviagte_to_offers() throws Exception{
		driver.findElement(By.xpath("//*[@id='sym2']")).click();
		Thread.sleep(2000);
	}
	
	@When("^click filter button$")
    public void filter() {
		driver.findElement(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")).click();
	}
	@Then("^navigate to precision marketing$")
    public void precisionMarketing() throws InterruptedException {
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='outLogo']"))).click();
	}
	@Then("^navigate to offer management$")
    public void offerManagement() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mainContainer']/paper-menu/div/hexagon-icon[4]/label"))).click();
	}
	
	@Then("^go to landnig page$")
    public void landingPage() throws InterruptedException {
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='topBar']/a/img")).click();		
	}

	@Then("^close browser$")
    public void closeBrowser() throws InterruptedException {
		driver.close();
	}

}
