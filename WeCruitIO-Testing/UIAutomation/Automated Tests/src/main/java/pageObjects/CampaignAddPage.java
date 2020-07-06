package pageObjects;

import interactions.Exceptions;
import interactions.UserActions;
import interactions.Waits;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import util.JsonReader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;


public class CampaignAddPage {
    WebDriver driver;
    UserActions userActions;

    public enum Attribute {
        VALUE("value"), CLASS("class"), DATA_TESTID("data-testid"), TITLE("title");
        private String value;

        Attribute(String s) {
            this.value = s;
        }

        public String getValue() {
            return value;
        }
    }

    public CampaignAddPage(WebDriver driver) {
        this.driver = driver;
        userActions = new UserActions(driver);
    }

    private enum EnumWebElement {
        INPUT_NOT_FOUND("not found", "WebElement not found"),
        INPUT_CAMPAIGN_NAME("Name", "//input[@data-testid = 'campaignName_field']"),
        INPUT_END_DATE("End date", "//input[@data-testid = 'row-2_endDateInput']"),
        INPUT_START_DATE("Start date", "//input[@data-testid = 'row-2_startDateInput']"),
        INPUT_KEYWORDS("Keywords", "//input[@data-testid = 'inputSearch']"),
        INPUT_SEARCH_REQUESTOR("Role", "//div[@data-testid = 'row-3_inputSelectSearchRole']//input"),
        INPUT_SEARCH_PROJECT("Project", "//div[@data-testid = 'row-3_inputSelectSearchProject']//input"),
        INPUT_SEARCH_ROLE("Requestor", "//div[@data-testid = 'row-3_inputSelectSearchRequestor']//input"),
        BUTTON_SAVE("Save", "//button[@data-testid = 'row-1_saveButton']"),
        BUTTON_CANCEL("Cancel", "//a[@data-testid = 'row-1_cancelButton']"),
        BUTTON_ADD_KEYWORDS("add keywords", "//button[@data-testid = 'addChipButton']"),
        BUTTON_11_DATASELECTOR("selectorDate", "//div[@role = 'dialog']/div[3]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[4]/button"),
        BUTTON_OK_DATASELECTOR("selectorOK", "//div[@role = 'dialog']/div[3]/div/div[2]/button[2]"),
        BUTTON_RIGHT_ARROW("selectorArrow", "//div[@role = 'dialog']/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[2]"),
        BUTTON_CLEAN_PROJECT_FIELD("Clean Project", "//div[@data-testid = 'row-3_inputSelectSearchProject']//button[1]"),
        CHIP_CONTAINER("chipContainer", "//div[@data-testid = 'row-4']//*[@role]/span"),
        CHIP_CONTAINER_CLOSE_BUTTON_LIST("Close ChipContainer", "//div[@data-testid = 'chip']//*[name() = 'svg']"),
        AUTOCOMPLETE_DROPBOX("autocompleteDropbox", "//div[@class = 'MuiPaper-root MuiAutocomplete-paper MuiPaper-elevation1 MuiPaper-rounded']"),
        AUTOCOMPLETE_LIST("autocompleteList", "//div[@class = 'MuiPaper-root MuiAutocomplete-paper MuiPaper-elevation1 MuiPaper-rounded']//ul"),
        AUTOCOMPLETE_NO_MATCHES_FOUND("autocompleteNoMatches", "//div[@class = 'MuiPaper-root MuiAutocomplete-paper MuiPaper-elevation1 MuiPaper-rounded']/div"),
        CAMPAIGN_MESSAGE_POP("messagePop", "//div[@class= 'MuiSnackbar-root MuiSnackbar-anchorOriginTopCenter']/div/div[2]");

        private String name, xpath;

        EnumWebElement(String name, String xpath) {
            this.name = name;
            this.xpath = xpath;
        }

        private String getXpath() {
            return this.xpath;
        }

        private String getName() {
            return this.name;
        }

        static private String getXpathByButtonName(String name) {
            return Stream.of(EnumWebElement.values())
                    .filter(x -> x.getName().equals(name))
                    .findFirst()
                    .orElse(INPUT_NOT_FOUND)
                    .getXpath();
        }
    }

    public String getWebElementXpathByName(String name) {
        return EnumWebElement.getXpathByButtonName(name);
    }

    public WebElement getWebElementByName(String name) {
        return userActions.findElementByXpath(EnumWebElement.getXpathByButtonName(name));
    }

    public List<WebElement> getWebElementsByName(String name) {
        return userActions.findElementsByXpath(EnumWebElement.getXpathByButtonName(name));
    }

    public void fillInformationIntoInputFields(String inputField, String value) {
        userActions.sendKeys(value, getWebElementByName(inputField));
    }

    public void validateInformationFromAField(String name, String expectedValue) {
        Assert.assertTrue(userActions.isTheValueOfThisElementEqualsToByAttribute(getWebElementByName(name), expectedValue, Attribute.VALUE.getValue())
                , "The value on the attribute Value of the element with the name: " + name + "Doesn't match with: " + expectedValue);
    }

    public void fillInformationIntoDatefields(String inputField, String value) {
        cleanAndSendKeys(value, getWebElementByName(inputField));
    }

    public void fillInformationIntoInputAutocompleteFields(String inputField, String value) {
        String autocompleteList = "autocompleteList";
        List<WebElement> list;
        userActions.sendKeys(value, getWebElementByName(inputField));
        Waits.waitUltilIsDisplayed(getWebElementByName("autocompleteDropbox"), driver);
        Waits.waitUltilListGreaterThanZero(EnumWebElement.getXpathByButtonName(autocompleteList), driver);
        list = getWebElementsByName(autocompleteList);
        list.get(0).click();
    }

    public void validateInformationFromDate(String startDate, String endDate) {
        Assert.assertTrue(validationStartDateGreaterThanEndDate(getWebElementByName(startDate), getWebElementByName(endDate))
                , "End Date it's  greater than Start Date");
    }

    public void invalidInformationFromAField(String name, String expectedValue) {
        Assert.assertFalse(userActions.isTheValueOfThisElementEqualsToByAttribute(getWebElementByName(name), expectedValue, Attribute.VALUE.getValue())
                , "The values match when they shouldn't");
    }

    public void clickOnButton(String button) {
        getWebElementByName(button).click();
    }

    public void validateInformationFromChipContainer(String inputField, String value) {
        List<String> keywords = new ArrayList<String>();
        List<String> chips = new ArrayList<String>();
        for (int i = 0; i < value.split(",").length; i++) {
            keywords.add(value.split(",")[i]);
        }
        for (int jumper = 0; jumper < getWebElementsByName(inputField).size(); jumper++) {
            chips.add(getWebElementsByName(inputField).get(jumper).getText());
        }
        Collections.sort(keywords);
        Collections.sort(chips);
        Assert.assertEquals(chips, keywords, "The keyword list don't match the expected");
    }

    public void messageAboutTheCampaignCreationStatus(String message) {
        String messageP = "messagePop";
        SoftAssert softAssertion = new SoftAssert();
        Waits.waitUltilIsDisplayedXpath(EnumWebElement.getXpathByButtonName(messageP), driver);
        softAssertion.assertTrue(getWebElementByName(messageP).getText().contains(message)
                , "The respective message wasn't displayed");
    }

    public void validationRedirectedPage(String page) {
        Assert.assertTrue(userActions.isThisPageRedirectedTowards(JsonReader.getValue("Links", page))
                , "The page wasn't redirected towards: \n" + page + "\nAnd get stocked on: \n" + driver.getCurrentUrl());

    }

    //<editor-fold desc="Helpers">
    private boolean validationStartDateGreaterThanEndDate(WebElement startDate, WebElement endDate) {
        Date start = null, end = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            start = dateFormat.parse(startDate.getAttribute("value"));
            end = dateFormat.parse(endDate.getAttribute("value"));
        } catch (ParseException e) {
            Exceptions.exceptionMessage(e);
        } finally {
            if (end.compareTo(start) >= 0)
                return true;
            return false;
        }
    }

    public void cleanAndSendKeys(String value, WebElement field) {
        do {
            field.sendKeys(Keys.CONTROL + "a");
            field.sendKeys(Keys.DELETE);
        } while (!field.getAttribute(Attribute.VALUE.getValue()).equals(""));
        userActions.sendKeys(value, field);
    }
    //</editor-fold>

}