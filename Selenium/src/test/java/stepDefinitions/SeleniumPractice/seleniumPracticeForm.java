package stepDefinitions.SeleniumPractice;

import PageObject.GitPracticeDownload;
import PageObject.SeleniumPracticePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class seleniumPracticeForm {
    WebDriver driver;
    SeleniumPracticePage page;
    GitPracticeDownload gitPracticeDownload;
    FirefoxProfile prof;

    @Before
    public void gets_into_the_page() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\rherrera\\IdeaProjects\\Jar's\\geckodriver.exe");
        driver = new FirefoxDriver();
        page = new SeleniumPracticePage(driver);
        page.FirefoxConnection();
        page.getDriver().manage().window().maximize();


    }

    //<editor-fold desc="SCENARIO Filling the textBox fields">
    @When("Lucas enters his names and date into the respective field")
    public void lucas_enters_his_names_and_date_into_the_respective_field() {


        page.typeF("My name is Jeff");
        page.typeL("Ramírez");
        page.typeD("11/02/1998");

    }

    @Then("Lucas should see what his names and date on the respective field")
    public void lucas_should_see_what_his_names_and_date_on_the_respective_field() {
        Assert.assertEquals("My name is Jeff", page.AssertF());
        Assert.assertEquals("Ramírez", page.AssertL());
        Assert.assertEquals("11/02/1998", page.AssertD());

    }
    //</editor-fold>

    //<editor-fold desc="SCENARIO Selecting in groupButtoms and checkBoxes">
    @When("Lucas selects and option of the groupButttoms")
    public void lucas_selects_and_option_of_the_groupButttoms() {
        page.clickExp();
        page.clickSex();
    }

    @When("checks all the checkBoxes")
    public void checks_all_the_checkBoxes() {
        page.checkboxP0();
        page.checkboxP1();
        page.checkboxT0();
        page.checkboxT1();
        page.checkboxT2();
    }

    @Then("Lucas should see what he selected and checked")
    public void lucas_should_see_what_he_selected_and_checked() {
        Assert.assertTrue(page.AssertProfession0());
        Assert.assertTrue(page.AssertProfession1());
        Assert.assertTrue(page.AssertTool0());
        Assert.assertTrue(page.AssertTool1());
        Assert.assertTrue(page.AssertTool2());
    }
    //</editor-fold>

    //<editor-fold desc="SCENARIO Selecting into the selectBoxes and the multi-selectBoxes">
    @When("Lucas selects and option from the select box")
    public void lucas_selects_and_option_from_the_select_box() {
        page.SelectBoxContinent("Australia");
    }

    @When("selects an option of the multi-selected box")
    public void selects_an_option_of_the_multi_selected_box() {
        page.SelectBoxCommands("Wait Commands");
    }

    @Then("Lucas should see what he selected")
    public void lucsa_should_see_what_he_selected() {
        page.AssertSelectContinent();
        page.AssertSelectCommands();
    }
    //</editor-fold>

    //<editor-fold desc="SCENARIO Uploading a document">
    @When("Lucas uploads a document")
    public void lucas_uploads_a_document() {
        page.uploadFile("C:\\document.pdf");
    }

    @Then("Lucas Should see the name of the document.")
    public void lucas_Should_see_the_name_of_the_document() {
        page.AssertUploadPhoto();
    }
    //</editor-fold>

    @When("Lucas download a document")
    public void lucas_download_a_document() throws InterruptedException, AWTException {
        page.downloadADocument();
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        gitPracticeDownload = new GitPracticeDownload(driver);
        gitPracticeDownload.downloadRAW();

    }


    @Then("he should see the document")
    public void he_should_see_the_document() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertTrue("this thing doesn't work" , gitPracticeDownload.assertIsDownloadedTheFile("conf.yaml"));

    }

    @When("lucas clicks thousand times on the button")
    public void lucas_clicks_thousand_times_on_the_button() throws InterruptedException, AWTException {
        page.hundredClicksOnThatButtonBecauseIWantToCelebrateThatIFinishTheAutomation();
    }


    @Then("the test should ends.")
    public void the_test_should_ends() {
    }

    @After
    public void quit() {
        page.getDriver().quit();
    }


}
