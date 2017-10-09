package baseClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

public class HttpResponseCode  extends browserInit {

    public static void main(String args[]) {
       init();
    	driver.get("http://www.yahoo.com/");
    	String c = "window.scrollTo(0,document.body.scrollHeight)"; 
    	JavascriptExecutor j = (JavascriptExecutor) driver; j.executeScript(c);
    }
}