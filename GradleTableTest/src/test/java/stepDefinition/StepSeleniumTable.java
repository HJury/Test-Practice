package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.SeleniumTable;

public class StepSeleniumTable {
    private WebDriver driver;
    private SeleniumTable seleniumTable;

    @Given("Lucas get into the page")
    public void lucas_get_into_the_page() {
        System.setProperty("webDriver.chrome.driver",
                "C:\\Users\\rherrera\\IdeaProjects\\GitHub\\GradleTableTest\\src\\test\\resources\\webDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        seleniumTable = new SeleniumTable(driver);
    }

    @When("Lucas get the elements of the table")
    public void lucas_get_the_elements_of_the_table() {
        Assert.assertTrue(seleniumTable.getTable());
    }

    @Then("he should print them in the same order")
    public void he_should_print_them_in_the_same_order() {
        seleniumTable.printTable();
    }
}
