package pageObjects;

import interactions.Actions;
import interactions.Exceptions;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ExcelUtils;

import java.text.ParseException;
import java.util.*;

public class NewCampaignPage extends PageObject {

    //<editor-fold desc="@FindBy">
    @FindBy(xpath = "//input[@data-testid = 'campaignName_field']")
    WebElement INPUT_CAMPAIGN_NAME;
    @FindBy(xpath = "//div[@data-testid = 'row-2_startDateInput']//input[@data-testid = 'date-field']")
    WebElement INPUT_START_DATE;
    @FindBy(xpath = "//div[@data-testid = 'row-2_startDateInput']/div/div/button")          //Aqui falta cambiarlo por el testID
            WebElement BUTTON_DATESELECTOR_START_DATE;
    @FindBy(xpath = "//div[@data-testid = 'row-2_endDateInput']//input[@data-testid = 'date-field']")                              //Aqui falta cambiarlo por el testID
            WebElement INPUT_END_DATE;
    @FindBy(xpath = "//div[@data-testid = 'row-2_endDateInput']/div/div/button")            //Aqui falta cambiarlo por el testID
            WebElement DATESELECTOR_END_DATE;
    @FindBy(xpath = "//div[@data-testid = 'row-1_saveButton']/button")                          //Aqui falta cambiarlo por el testID
            WebElement BUTTON_SAVE;
    @FindBy(xpath = "//a[@data-testid = 'row-1_cancelButton']")
    WebElement BUTTON_CANCEL;
    @FindBy(xpath = "//div[@data-testid = 'Search role']//input")
    WebElement INPUT_SEARCH_ROLE;
    @FindBy(xpath = "//div[@data-testid = 'Search project']//input")
    WebElement INPUT_SEARCH_PROJECT;
    @FindBy(xpath = "//div[@data-testid = 'Search requestor']//input")
    WebElement INPUT_SEARCH_REQUESTOR;
    @FindBy(xpath = "//div[@data-testid = 'row-4']//input[@type = 'text']")
    WebElement INPUT_KEYWORDS;
    @FindBy(xpath = "//div[@data-testid = 'row-4']//button[@type = 'submit']")
    WebElement BUTTON_ADD_CHIPS;
    @FindBy(xpath = "//textarea[@data-testid = 'desiredProfile']")
    WebElement TEXTAREA_DESIRED_PROFILE;
    //</editor-fold>

    //<editor-fold desc="Elementos que solo pueden ser alcanzados en tiempo de ejecución">
    String XPATH_CHIPCONTAINER_ELEMENT_LIST = "//div[@data-testid = 'chipContainer']/*[@role]/span";
    String XPATH_ADD_NEW_CAMPAIGN_REDIRECTION_ELEMENT = "//a[@role= 'button']";
    //</editor-fold>

    WebDriver driver;
    Actions actions;

    public NewCampaignPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void fillInformationCorrectly() {
        actions.sendKeys(ExcelUtils.getValue("Campaign name"), INPUT_CAMPAIGN_NAME);
        actions.selectDateFromDateSelector(BUTTON_DATESELECTOR_START_DATE);
        actions.sendKeysOnDateFields(ExcelUtils.getValue("End date"), INPUT_END_DATE);
        actions.sendKeysAutocomplete(ExcelUtils.getValue("Role"), INPUT_SEARCH_ROLE);
        actions.sendKeysAutocomplete(ExcelUtils.getValue("Project"), INPUT_SEARCH_PROJECT);
        actions.sendKeysAutocomplete(ExcelUtils.getValue("Requestor"), INPUT_SEARCH_REQUESTOR);
        actions.sendKeys(ExcelUtils.getValue("Keywords"), INPUT_KEYWORDS);
        BUTTON_ADD_CHIPS.click();
        actions.sendKeys(ExcelUtils.getValue("Desired profile"), TEXTAREA_DESIRED_PROFILE);
    }

    public void fillInformationIncorrectly() {
        actions.sendKeys(ExcelUtils.getValue("Campaign name"), INPUT_CAMPAIGN_NAME);
        actions.selectDateFromDateSelector(BUTTON_DATESELECTOR_START_DATE);
        actions.sendKeysOnDateFields(ExcelUtils.getValue("End date"), INPUT_END_DATE);
        actions.sendKeysAutocomplete(ExcelUtils.getValue("Project"), INPUT_SEARCH_PROJECT);
        actions.sendKeysAutocomplete(ExcelUtils.getValue("Requestor"), INPUT_SEARCH_REQUESTOR);
        actions.sendKeys(ExcelUtils.getValue("Keywords"), INPUT_KEYWORDS);
        BUTTON_ADD_CHIPS.click();
        actions.sendKeys(ExcelUtils.getValue("Desired profile"), TEXTAREA_DESIRED_PROFILE);
    }

    public void fillInformationInvalidIntoCertainFields() throws ParseException {
        actions.sendKeys(ExcelUtils.getValue("Invalid-Campaign name"), INPUT_CAMPAIGN_NAME);
        Assert.assertTrue("Campaign name is too long", INPUT_CAMPAIGN_NAME.getAttribute("value").length() < 255);
        actions.sendKeysOnDateFields(ExcelUtils.getValue("Invalid-Start date"), INPUT_START_DATE);
        actions.sendKeysOnDateFields(ExcelUtils.getValue("Invalid-End date"), INPUT_END_DATE);
        Assert.assertFalse(actions.validationStartDateGreaterThanEndDate(INPUT_START_DATE, INPUT_END_DATE));
        actions.sendKeys(ExcelUtils.getValue("Invalid-keywords"), INPUT_KEYWORDS);
        Assert.assertTrue(actions.findElementsByXpath(XPATH_CHIPCONTAINER_ELEMENT_LIST).size() == 0);
    }

    public boolean validationAllTheMandatoryFieldsAreFilledOut(boolean CorrectlyOrIncorrectly) {
        //<editor-fold desc="Sorting of the lists of Keywords and Chips in order to compare them">
        List<String> keywords = new ArrayList<String>();
        List<String> chips = new ArrayList<String>();
        for (int i = 0; i < ExcelUtils.getValue("Keywords").split(",").length; i++) {
            keywords.add(ExcelUtils.getValue("Keywords").split(",")[i]);
        }
        for (int jumper = 0; jumper < actions.findElementsByXpath(XPATH_CHIPCONTAINER_ELEMENT_LIST).size(); jumper++) {
            chips.add(actions.findElementsByXpath(XPATH_CHIPCONTAINER_ELEMENT_LIST).get(jumper).getText());
        }
        Collections.sort(keywords);
        //</editor-fold>
        try {
            Assert.assertTrue("Campaign name is too long", INPUT_CAMPAIGN_NAME.getAttribute("value").length() <= 255);
            if (CorrectlyOrIncorrectly)  //If "CorrectlyOrIncorrectly is true then it tries to verify all the fields"
                Assert.assertNotEquals("Role is invalid", INPUT_SEARCH_ROLE.getAttribute("value"), "");
            Assert.assertNotEquals("Project is invalid", INPUT_SEARCH_PROJECT.getAttribute("value"), "");
            Assert.assertNotEquals("Requestor is invalid", INPUT_SEARCH_REQUESTOR.getAttribute("value"), "");
            Assert.assertEquals("They are not the same bro", keywords, chips);
            Assert.assertTrue("There is no keywords", actions.findElementsByXpath(XPATH_CHIPCONTAINER_ELEMENT_LIST).size() > 0);
            Assert.assertTrue(actions.validationStartDateGreaterThanEndDate(INPUT_START_DATE, INPUT_END_DATE));
            return true;
        } catch (AssertionError e) {
            Exceptions.exceptionMessage(e);
            return false;
        } catch (Exception e) {
            Exceptions.exceptionMessage(e);
            return false;
        }
    }

    public void validationAllTheMandatoryFieldsAreCorrectlyFilledOut() {
        Assert.assertTrue(validationAllTheMandatoryFieldsAreFilledOut(true));
    }

    public void validationAllTheMandatoryFieldsAreIncorrectlyFilledOut() {
        Assert.assertFalse(validationAllTheMandatoryFieldsAreFilledOut(true));
    }

    public void validationAllTheInformationIsPreserved() {
        Assert.assertTrue(validationAllTheMandatoryFieldsAreFilledOut(false));
    }

    public void validationNoMatchesFoundMessageIsPresent() {
        actions.sendKeys(ExcelUtils.getValue("Invalid-Role"), INPUT_SEARCH_ROLE);
        actions.validationNoMatchesFoundMessageIsPresent();
        actions.sendKeys(ExcelUtils.getValue("Invalid-Project"), INPUT_SEARCH_PROJECT);
        actions.validationNoMatchesFoundMessageIsPresent();
        actions.sendKeys(ExcelUtils.getValue("Invalid-Requestor"), INPUT_SEARCH_REQUESTOR);
        actions.validationNoMatchesFoundMessageIsPresent();
    }

    public void clickOnSaveButton() {
        BUTTON_SAVE.click();
    }

    public void clickOnCancelButton() {
        BUTTON_CANCEL.click();
    }

    public void messageAboutTheCampaignCreationStatus() {
        Assert.assertTrue(actions.messageAboutTheCampaignCreationStatus());
    }

    public void validationRedirectedPage() {
        actions.validationRedirectedPage(XPATH_ADD_NEW_CAMPAIGN_REDIRECTION_ELEMENT);
    }
}
