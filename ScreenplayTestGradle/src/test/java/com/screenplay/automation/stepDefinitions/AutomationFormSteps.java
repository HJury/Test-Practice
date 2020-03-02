package com.screenplay.automation.stepDefinitions;

import com.screenplay.automation.tasks.Navigate;
import com.screenplay.automation.userInterface.AutomationDemoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutomationFormSteps {
    private WebDriver driver;
    private Actor actor = new Actor("User");
    private AutomationDemoPage automationDemoPage;

    @Given("Luisa gets into the automation practice form")
    public void luisaGetsIntoTheAutomationPracticeForm() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rherrera\\IdeaProjects\\GitHub\\ScreenplayTestGradle\\src\\test\\resources\\webDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        automationDemoPage = new AutomationDemoPage(driver);
       // actor.attemptsTo(Navigate.to(Open.url(AutomationDemoPage)));
    }

    @When("Luisa enters the information needed")
    public void luisaEntersTheInformationNeeded() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("She should see his profile in the webTable")
    public void sheShouldSeeHisProfileInTheWebTable() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
