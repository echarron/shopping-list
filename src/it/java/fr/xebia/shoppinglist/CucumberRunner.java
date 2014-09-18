package fr.xebia.shoppinglist;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = "pretty", features = "src/it/resources/features", glue = { "fr.xebia.shoppinglist.step_definitions" })
public class CucumberRunner {

}
