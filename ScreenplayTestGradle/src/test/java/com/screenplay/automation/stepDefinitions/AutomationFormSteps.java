package com.screenplay.automation.stepDefinitions;

import com.screenplay.automation.tasks.Navigate;
import com.screenplay.automation.userInterface.AutomationDemoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;


public class AutomationFormSteps {
    private WebDriver driver;

    private AutomationDemoPage automationDemoPage;

    @Given("Luisa gets into the automation practice form")
    public void luisaGetsIntoTheAutomationPracticeForm() {

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
