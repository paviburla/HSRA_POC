package Runner;
import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "features/",glue = "StepDefinitions",
        plugin = {"summary", "pretty", "html:TestReports/CucumberReport/cucumber.html", "json:target/cucumber-report/cucumber.json"},tags = "@all")
public class TestRunner {

}
