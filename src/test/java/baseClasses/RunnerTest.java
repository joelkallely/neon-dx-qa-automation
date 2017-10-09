package baseClasses;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty" , "html:target/html/" },
		features = "src/test/resources"
		)
public class RunnerTest {

}
