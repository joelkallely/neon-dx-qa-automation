import cucumber.api.java.After;
import baseClasses.browserInit;
public class Hooks extends browserInit{

	@After
	public void afterClass(){
		driver.close();
	}
}
