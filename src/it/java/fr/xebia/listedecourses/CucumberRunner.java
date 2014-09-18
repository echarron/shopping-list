package fr.xebia.listedecourses;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = "pretty", features = "src/it/resources/features")
public class CucumberRunner {

}
