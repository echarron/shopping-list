package fr.xebia.listedecourses;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.inject.Inject;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchStepdefs {

    private WebDriver webDriver;

    @Inject
    public GoogleSearchStepdefs(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @After
    public void quitWebDriver() {
        webDriver.close();
    }

    @Given("^an anonyne user connected to google search home page$")
    public void goToGoogleSearchHomePage() {
        webDriver.navigate().to("https://www.google.fr");
    }

    @When("^he makes a search for keyword (\\S+)$")
    public void search(String searchText) {
        webDriver.findElement(By.name("q")).sendKeys(searchText);
        webDriver.findElement(By.name("btnG")).click();
    }

    @Then("^the title of the page is (.*)$")
    public void checkResults(String pageTitle) {
        assertThat(new WebDriverWait(webDriver, 1).until(titleIs(pageTitle))).isTrue();
    }
}
