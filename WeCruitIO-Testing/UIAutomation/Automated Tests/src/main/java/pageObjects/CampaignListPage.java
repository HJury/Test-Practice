package pageObjects;

import interactions.UserActions;
import interactions.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.JsonReader;

import java.util.List;
import java.util.stream.Stream;

public class CampaignListPage {
    WebDriver driver;
    UserActions userActions;
    String tableBase = "Row Table Name",
            tableWithOutExtension = "Row Without Extension",
            status = "Status",
            nextPage = "Next Page",
            tooltip = "Tooltip",
            active = "Active",
            onHold = "On Hold",
            playButton = "Play Button",
            pauseButton = "Pause Button",
            firstName = "First Name",
            lastName = "Last Name";

    private enum EnumWebElement {
        INPUT_NOT_FOUND("not found", "WebElement not found"),
        FIRST_NAME_USER_CURRENTLY_LOGGED("First Name", "//p[@class= 'firstName']"),
        LAST_NAME_USER_CURRENTLY_LOGGED("Last Name", "//p[@class= 'lastName']"),
        BUTTON_ALL_FILTER("All", "//button[@data-testid = 'row-1_allFilterButton']"),
        BUTTON_MY_CAMPAIGN_FILTER("My Campaigns", "//button[@data-testid = 'row-1_myCampaignsFilterButton']"),
        BUTTON_ADD_NEW_CAMPAIGN("+ Add New", "//a[@data-testid = 'row-2_addNewCampaignButton']"),
        BUTTON_ACTION_PLAY("Play Button", "//button[@data-testid = 'campaignStatus_Button']"),
        BUTTON_ACTION_PAUSE("Pause Button", "//button[@data-testid = 'campaignStatus_Button']"),
        BUTTON_ACTION_EDIT("Edit", "//td[8]/button[1]"),
        BUTTON_ACTION_CANDIDATE("Candidates", "//a[@data-testid = 'tab2']"),
        BUTTON_NEXT_PAGE("Next Page", "//button[@title = 'Next page']"),
        BUTTON_ACTION_PLAY_XPATH_CONTAINS("Play", "/td[8]/button[3]/span/*/*[contains(@d, 'M8 ') ]"),
        BUTTON_ACTION_PAUSE_XPATH_CONTAINS("Pause", "/td[8]/button[3]/span/*/*[contains(@d, 'M6 ') ]"),
        BUTTON_AGREE_DELETE("Agree", "//button[@data-testid = 'alert-dialog-buttonAgree']"),
        ROW_TABLE_BASE("Row Table Name", "//table/tbody/tr/td[2]/p[1]"),
        FIRST_ROW_OF_THE_TABLE_DATE("First Row Date", "//table/tbody/tr[1]/td[3]/p[2]"),
        TABLE_HEAD("Table Head", "//table/thead/tr/th/p"),
        SECOND_LINE_INFO("Second Line", "//table/tbody/tr[1]/td/p[2]"),
        ROW_TABLE_WITHOUT_EXTENSION("Row Without Extension", "//table/tbody/tr"),
        NAME_XPATH_EXTENSION("Name", "/td[2]/p[1]"),
        ROLE_XPATH_EXTENSION("Role", "/td[3]/p[1]"),
        STATUS_XPATH_EXTENSION("Status", "/td[7]/p/div/span"),
        PROJECT_XPATH_EXTENSION("Project", "/td[2]/p[2]"),
        DELETE_XPATH_EXTENSION("Delete", "/td[8]/button[2]"),
        SKILL_XPATH_EXTENSION("Skill", "/td[5]/p"),
        REQUESTOR_XPATH_EXTENSION("Requestor", "/td[4]/p[1]"),
        DELETE_ALERT_POOUP("Alert", "//div[@data-testid = 'alert-dialog']"),
        PROGRESS_BAR("Progress Bar", "//div[@role = 'progressbar']"),
        TOOLTIP_MESSAGE("Tooltip", "//div[@role = 'tooltip']/div");

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

        static private String getXpathByWebElementName(String name) {
            return Stream.of(CampaignListPage.EnumWebElement.values())
                    .filter(x -> x.getName().equals(name))
                    .findFirst()
                    .orElse(INPUT_NOT_FOUND)
                    .getXpath();
        }
    }

    private WebElement getWebElementFromASearchAndAField(String name, String field) {
        return userActions.findElementByXpath(searchOnTable(name) + EnumWebElement.getXpathByWebElementName(field));
    }

    public WebElement getWebElementByName(String name) {
        return userActions.findElementByXpath(CampaignListPage.EnumWebElement.getXpathByWebElementName(name));
    }

    public String getWebElementXpathByName(String name) {
        return CampaignListPage.EnumWebElement.getXpathByWebElementName(name);
    }

    public List<WebElement> getWebElementsByName(String name) {
        return userActions.findElementsByXpath(CampaignListPage.EnumWebElement.getXpathByWebElementName(name));
    }

    public void moveTheMouseTowards(String name, String field) {
        Actions action = new Actions(this.driver);
        action.moveToElement(getWebElementFromASearchAndAField(name, field)).perform();
    }

    public CampaignListPage(WebDriver driver) {
        this.driver = driver;
        userActions = new UserActions(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void ThisElementIsDisplayed(String button) {
        userActions.isThisElementDisplayed(getWebElementByName(button));
    }


    public void theAllFilterIsSelected(String button) {
        Assert.assertTrue((getWebElementByName(button)).isEnabled());
    }

    public void clickOnButton(String button) {
        getWebElementByName(button).click();
    }

    public void theButtonIsNotSelected(String button) {
        Assert.assertFalse(getWebElementByName(button).isSelected());
    }

    public void validationCampaignExists(String name) {
        Assert.assertTrue(searchOnTable(name) != null, "The campaign searching for default doesn't exist");
    }

    public void isTheHoverShownTheTestOnThis(String value) {
        Waits.waitUltilIsDisplayedxpathShort(EnumWebElement.getXpathByWebElementName(tooltip), driver);
        String hoverText = getWebElementByName(tooltip).getText();
        Assert.assertEquals(value, hoverText);
    }

    public void theStatusIs(String name, String status) {
        Assert.assertTrue(getWebElementFromASearchAndAField(name, this.status).getText().equals(status),
                "The status of the campaign: " + name + " doesn't match was expected: " + status
                        + "and the was obtained: " + getWebElementFromASearchAndAField(name, this.status).getText().equals(status) + "\n");
    }

    public void clickOnButtonOnAField(String name, String button) {
        getWebElementFromASearchAndAField(name, button).click();
    }

    public void isThisElementDisplayed(String name, String button) {
        Waits.waitUltilIsDisplayedxpathShort(searchOnTable(name) + EnumWebElement.getXpathByWebElementName(button), driver);
        Assert.assertTrue(getWebElementFromASearchAndAField(name, button).isDisplayed()
                , "The element: " + button + " isn't displayed" + "\n");
    }

    public void thisFieldWithThisInformationExists(String name, String field) {
        Assert.assertTrue(
                getWebElementFromASearchAndAField(name, field).getAttribute(CampaignAddPage.Attribute.TITLE.getValue()).length() > 20
                , "The length of the element: " + field + "isn't greater than 20 " + "\n"
        );
    }

    public void theFieldWithLongValuesShowEllipsis(String name, String field) {
//        Assert.assertTrue(
//                getWebElementFromASearchAndAField(name, field).getText().contains("...")
//                , "The field: " + field + " doesn't contain ellipsis(...) " + "\n"
//        );
    }

    public void theRespectiveColumnsExist(List<String> Columns, String key) {
        for (int per = 0; per < Columns.size(); per++) {
            Assert.assertTrue(thisValueExistsAmongTheColumns(Columns.get(per), key)
                    , "The value: " + key + " doesn't exist among the columns" + "\n");
        }
    }

    public void theSecondLineinfoExist(List<String> columns, String key) {
        for (int per = 0; per < columns.size(); per++) {
            Assert.assertTrue(thisValueExistsAmongTheColumns(columns.get(per), key)
                    , "The value: " + key + " doesn't exist among the columns" + "\n");
        }
    }

    public void theDateHasTheFormart(String regex) {
        Assert.assertTrue(getWebElementByName("First Row Date").getText().split(" ")[2].matches(regex)
                , "The date format doesn't match");
    }

    public void theCampaignHasTheStatus(String name, String status) {
        WebElement statusWeb = getWebElementFromASearchAndAField(name, this.status);
        if (status.equals(active) && statusWeb.getText().equals(onHold))
            getWebElementFromASearchAndAField(name, playButton).click();
        else if (status.equals(onHold) && statusWeb.getText().equals(active))
            getWebElementFromASearchAndAField(name, pauseButton).click();
        else {
        }
    }

    public void deleteCampaign(String name) {
        getWebElementFromASearchAndAField(name, "Delete").click();
        Waits.waitUltilIsDisplayed(getWebElementByName("Alert"), driver);
        getWebElementByName("Agree").click();
    }

    public void theUserLoggedIs(String user) {
        String userLoggedName = getWebElementByName(firstName).getText() + getWebElementByName(lastName).getText();
        Assert.assertEquals(userLoggedName, user
                , "The user name doesn't mach, were expected: " + user + " And was obtain: " + userLoggedName + "\n");
    }

    public void isRedirectedTowards(String page) {
        Assert.assertTrue(userActions.isThisPageRedirectedTowards(JsonReader.getValue("Links", page))
                , "The page wasn't redirected towards: " + page + "on time" + "\n");
    }

    public void thisCampaignDoesntExist(String name) {
        Assert.assertEquals(searchOnTable(name), null
                , "The campaign exists when it shouldn't" + "\n");
    }

    public void getIntoEditCampaignPage(String name) {
        getWebElementFromASearchAndAField(name, "Edit").click();
    }

    public void waitForProgressBar() {
        Waits.waitUntilIsInvisible(EnumWebElement.getXpathByWebElementName("Progress Bar"), driver);
    }
    //<editor-fold desc="Helper">

    private boolean thisValueExistsAmongTheColumns(String value, String key) {
        List<WebElement> elementList = getWebElementsByName(key);
        for (int per = 0; per < elementList.size(); per++) {
            if (elementList.get(per).getText().equals(value) || elementList.get(per).getText().contains(value)) {
                return true;
            }
        }
        return false;
    }

    public String searchOnTable(String name) {
        int watcher = 1;
        int position = 0;
        for (int jump = 0; jump <= watcher; jump++) {
            position = userActions.searchOnList(getWebElementsByName(tableBase), name);
            if (position != 0)
                return (EnumWebElement.getXpathByWebElementName(tableWithOutExtension) + "[" + position + "]");
            if (getWebElementByName(nextPage).isEnabled()) {
                watcher++;
                getWebElementByName(nextPage).click();
            }
        }
        return null;
    }
    //</editor-fold>
}
