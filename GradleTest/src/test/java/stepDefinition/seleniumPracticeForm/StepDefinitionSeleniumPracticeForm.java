package stepDefinition.seleniumPracticeForm;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.AutomationDemoSite;

public class StepDefinitionSeleniumPracticeForm {
    WebDriver driver;
    AutomationDemoSite automationDemoSite;

    @Given("Lucas gets into the Automation Demo Site")
    public void lucas_gets_into_the_Automation_Demo_Site() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\rherrera\\IdeaProjects\\Jar's\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://demo.automationtesting.in/Register.html");
        automationDemoSite = new AutomationDemoSite(driver);
    }

    @When("Lucas fills out the form with his information")
    public void lucas_fills_out_the_form_with_his_information() {
        automationDemoSite.fillFirstName("Rafael");
        automationDemoSite.fillLastName("Herrera");
        automationDemoSite.fillAddress("Natania 6ta");
        automationDemoSite.fillEmailAddress("asd@gmail.com");
        automationDemoSite.fillPhone("3174959308");
        automationDemoSite.selectGender();
        automationDemoSite.selectHobbies();
        automationDemoSite.selectLanguage();
        automationDemoSite.selectSkill("Android");
        automationDemoSite.selectCountry("Albania");
        automationDemoSite.selectSelectCountry("Australia");
        automationDemoSite.selectDateOfBirth("1998","February", "11");
        automationDemoSite.fillPassword("123456");
        automationDemoSite.fillConfirmPassword("123456");
        automationDemoSite.submit();

    }

    @Then("Lucas should see his submit on the WebTable")
    public void lucas_should_see_his_submit_on_the_WebTable() {
        Assert
    }


}
