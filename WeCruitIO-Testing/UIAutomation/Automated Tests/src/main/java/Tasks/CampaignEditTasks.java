package Tasks;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import pageObjects.CampaignEditPage;
import pageObjects.CampaignListPage;
import util.JsonReader;


public class CampaignEditTasks {
    private WebDriver driver;
    private CampaignEditPage campaignEditPage;
    private CampaignListPage campaignListPage;
    private String name = "Name",
            project = "Project",
            requestor = "Requestor",
            startDate = "Start date",
            role = "Role",
            keywords = "Keywords",
            skill = "Skill",
            link = "Links",
            addKeywords = "add keywords",
            save = "Save",
            cancel = "Cancel",
            listPage = "Campaign List";

    public CampaignEditTasks(WebDriver driver) {
        this.driver = driver;
        campaignEditPage = new CampaignEditPage(driver);
        campaignListPage = new CampaignListPage(driver);
    }

    /**
     * Navigates towards the edit page of a campaign that matches with the information received into the JSONObject.
     *
     * @param jsonObject
     */
    public void getIntoEditCampaignPage(JSONObject jsonObject) {
        campaignListPage.getIntoEditCampaignPage(JsonReader.getValueFromPackage(jsonObject, name));
        driver.get(driver.getCurrentUrl());
    }

    /**
     * It wait for the information of the campaign to be obtained for the Data Base and displayed into the campaign edit
     * page.
     */
    public void waitForElementsToBeDisplayed() {
        campaignEditPage.waitUntilInformationIsDisplayed(name);
    }

    /**
     * Verify that the fields:
     * <ul>
     *     <li Role />
     *     <li Requestor />
     *     <li Start Date />
     * </ul>
     */
    public void theFieldsAreDisabled() {
        campaignEditPage.thisFieldIsDiseable(startDate);
        campaignEditPage.thisFieldIsDiseable(role);
        campaignEditPage.thisFieldIsDiseable(requestor);
    }

    /**
     * Edits the info of a campaign with the information received into the JSONObject.
     *
     * @param jsonObject
     */
    public void editTheCampaignInformationCorrectly(JSONObject jsonObject) {
        campaignEditPage.editTheCampaignInformationCorrectly(name, JsonReader.getValueFromPackage(jsonObject, name));
        campaignEditPage.cleanFieldsForEdit(project);
        campaignEditPage.fillInformationIntoInputAutocompleteFields(project, JsonReader.getValueFromPackage(jsonObject, project));
        campaignEditPage.editTheCampaignInformationCorrectly(keywords, JsonReader.getValueFromPackage(jsonObject, skill));
        campaignEditPage.clickOnButton(addKeywords);
    }

    /**
     * Edits the info of a campaign with empty information to make in invalid.
     */
    public void editTheCampaignInformationIncorrectly() {
        campaignEditPage.cleanFieldsForEdit(project);
        campaignEditPage.clickOnButton(save);
    }

    /**
     * Verify that a message about the status of the edition of a campaign was displayed.
     *
     * @param message
     */
    public void aMessageisShown(String message) {
        campaignEditPage.messageAboutTheCampaignCreationStatus(message);
    }

    /***
     * Verify that the information of a campaign wasn't edited after invalid intends.
     * @param jsonObject
     */
    public void theCampaignInformationShouldnTBeUpdated(JSONObject jsonObject) {
        clickOnButton(cancel);
        isRedirectedTowards(listPage);
        waitForProgressBar();
        campaignListPage.validationCampaignExists(JsonReader.getValueFromPackage(jsonObject, name));
    }

    /**
     * Verify that when a edition of a campaign is cancel all the modification should be apply.
     *
     * @param jsonObject
     */
    public void theModificationsShouldBeCanceled(JSONObject jsonObject) {
        campaignListPage.validationCampaignExists(JsonReader.getValueFromPackage(jsonObject, name));
    }

    public void clickOnButton(String button) {
        campaignEditPage.clickOnButton(button);
    }

    /**
     * Waits for the fully load of the campaigns information
     */
    public void waitForProgressBar() {
        campaignListPage.waitForProgressBar();
    }

    /**
     * Validates that the page is redirected towards the page that it's receive as parameter.
     *
     * @param listPage
     */
    public void isRedirectedTowards(String listPage) {
        campaignEditPage.isRedirectedTowards(listPage);
        driver.get(JsonReader.getValue(link, listPage));
    }

    /**
     * Verify that when a edition of a campaign is invalid all the modification should be apply.
     *
     * @param jsonObject
     */
    public void theCampaignInformationShouldBeUpdated(JSONObject jsonObject) {
        campaignListPage.validationCampaignExists(JsonReader.getValueFromPackage(jsonObject, name));
    }

}
