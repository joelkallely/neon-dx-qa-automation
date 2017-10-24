import cucumber.api.java.After;
import baseClasses.browserInit;
public class Hooks extends browserInit{
//after all classes
	@After
	public void afterClass(){
		driver.close();
	}
}
