package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features	= {"src\\main\\resources\\features\\busca.feature", "src\\main\\resources\\features\\fap.feature"},
		glue		= "steps",
		plugin		= {"pretty", "html:target/report.html"},
		monochrome	= true
		)
public class Runner {

}
