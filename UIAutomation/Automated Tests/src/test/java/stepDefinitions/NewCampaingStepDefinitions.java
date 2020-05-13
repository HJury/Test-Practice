package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import interactions.TakeAndSave;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.NewCampaignPage;

import java.io.IOException;
import java.text.ParseException;

public class NewCampaingStepDefinitions {
    /*Un path que permitirá la ejecucion de los test en cualquier maquina*/
    private String path = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\webDriver\\chromedriver.exe";
    private WebDriver driver;


    /*Se definen las páginas que van a pasar por el test.*/
    NewCampaignPage newCampaignPage;
    TakeAndSave takeAndSave;

    @Given("^Lucas login into WeCruitIO and select Create new campaigns$")
    public void lucas_login_into_WeCruitIO_and_select_Create_new_campaigns() throws IOException {
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        newCampaignPage = new NewCampaignPage(driver);
        driver.manage().window().maximize();
        //sdriver.get("http://localhost:3000/campaign");
        driver.get("http://wecruitio.endava.com.s3-website-us-east-1.amazonaws.com/campaign");
        takeAndSave = new TakeAndSave();
        takeAndSave.screenshot(driver, "1. gets in the example site page");
    }


    @When("^Lucas enters information into the mandatory fields$")
    public void lucas_enters_information_into_the_mandatory_fields() {
        newCampaignPage.fillInformationCorrectly();

    }

    @When("^the information is valid$")
    public void the_information_is_valid() {
        newCampaignPage.validationAllTheMandatoryFieldsAreCorrectlyFilledOut();
    }

    @When("^He clicks on the save buttom$")
    public void he_clicks_on_the_save_buttom() {
        newCampaignPage.clickOnSaveButton();
    }

    @Then("^A new campaigns should be created$")
    public void a_new_campaigns_should_be_created() {
        newCampaignPage.messageAboutTheCampaignCreationStatus();
    }

    @Then("^The user should be redirected towards Campaign List$")
    public void the_user_should_be_redirected_towards_Campaign_List() {
        newCampaignPage.validationRedirectedPage();
    }

    @When("^Lucas enters new information into the mandatory fields$")
    public void lucas_enters_new_information_into_the_mandatory_fields() {
        newCampaignPage.fillInformationIncorrectly();
    }

    @When("^The information is invalid$")
    public void the_information_is_invalid() {
        newCampaignPage.validationAllTheMandatoryFieldsAreIncorrectlyFilledOut();
    }

    @Then("^He should see a massagge about the unsuccessfully creation of the campaign$")
    public void he_should_see_a_massagge_about_the_unsuccessfully_creation_of_the_campaign() {
        newCampaignPage.messageAboutTheCampaignCreationStatus();
    }

    @Then("^The labels that contains invalid information should be highlighted on red$")
    public void the_labels_that_contains_invalid_information_should_be_highlighted_on_red() {
    }

    @Then("^The information previously entered should be preserved\\.$")
    public void the_information_previously_entered_should_be_preserved()  {
        newCampaignPage.validationAllTheInformationIsPreserved();
    }


    @When("^Clicks on the cancel buttom$")
    public void clicks_on_the_cancel_buttom() {
        newCampaignPage.clickOnCancelButton();
    }

    @Then("^All the input fields should be cleaned$")
    public void all_the_input_fields_should_be_cleaned() {
        newCampaignPage.validationRedirectedPage();
    }

    @When("^Lucas enters invalid inputs into certain fields$")
    public void lucas_enters_invalid_inputs_into_certain_fields() throws ParseException {
        newCampaignPage.fillInformationInvalidIntoCertainFields();
    }

    @Then("^Lucas should see and invalid input message$")
    public void lucas_should_see_and_invalid_input_message() {
        newCampaignPage.validationNoMatchesFoundMessageIsPresent();
    }

    @After
    public void quit() {
        driver.quit();
    }
}
//div[@data-testid = 'row-3']/div[1]/div/div/div