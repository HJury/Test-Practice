package Tasks;

import interactions.Waits;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import pageObjects.CampaignAddPage;
import pageObjects.CampaignListPage;
import util.JsonReader;

public class CampaignAddTasks {
    WebDriver driver;

    //<editor-fold desc="Variables for Json calls">
    private String campaignName = "Name",
            startDate = "Start date",
            endDate = "End date",
            keywords = "Keywords",
            requestor = "Requestor",
            project = "Project",
            role = "Role",
            chipContainer = "chipContainer",
            addKeywords = "add keywords";
    //</editor-fold>

    private CampaignAddPage campaignAddPage;
    private CampaignListPage campaignListPage;

    /**
     * Declaration of the Page Objects
     *
     * @param driver
     */
    public CampaignAddTasks(WebDriver driver) {
        this.driver = driver;
        campaignAddPage = new CampaignAddPage(driver);
        campaignListPage = new CampaignListPage(driver);
    }


    /**
     * Fills validate information into the fields of campaign creation
     *
     * @param jsonObject
     */
    public void fillFormWithValidInformation(JSONObject jsonObject) {
        fillFormWithInfoFirstPart(jsonObject);
        campaignAddPage.fillInformationIntoInputAutocompleteFields(role, JsonReader.getValueFromPackage(jsonObject, role));
    }

    /**
     * Validates that all the information entered into the field is valid
     *
     * @param jsonObject
     */
    public void validateThatTheInformationWasFilledCorrectly(JSONObject jsonObject) {
        validInfoFromFormFirstPart(jsonObject);
    }

    /**
     * Validates that a new campaign hasn't been create when invalid information is entered.
     *
     * @param jsonObject
     */
    public void thisCampaignDoesntExist(JSONObject jsonObject) {
        campaignListPage.thisCampaignDoesntExist(JsonReader.getValueFromPackage(jsonObject, campaignName));
    }

    /**
     * Deletes the campaign that was created on the test so in can be relaunch in the future.
     *
     * @param page
     * @param jsonObject
     */
    public void theNewCampaignIsDeleted(String page, JSONObject jsonObject) {
        campaignListPage.deleteCampaign(JsonReader.getValueFromPackage(jsonObject, campaignName));
        Waits.waitUltilIsDisplayedxpathShort("fast", driver);
        thePageIsRedirected(page);
    }

    /**
     * Validates that the campaign was created with the valid information.
     *
     * @param page
     * @param jsonObject
     */
    public void aNewCampaignShouldBeCreated(String page, JSONObject jsonObject) {
        //  campaignAddPage.messageAboutTheCampaignCreationStatus( JsonReader.getValue(systemMessage, successfullyCreation));
//        messageAboutTheResultOfCampaignCreationIsShown(page, JsonReader.getValue(systemMessage, successfullyCreation));
        thePageIsRedirected(page);
        campaignListPage.validationCampaignExists(JsonReader.getValueFromPackage(jsonObject, campaignName));
    }

    /**
     * Validates that all the information was filled and Role field information is invalid.
     *
     * @param jsonObject
     */
    public void validInfoFromTheForm(JSONObject jsonObject) {
        validInfoFromFormFirstPart(jsonObject);
        campaignAddPage.invalidInformationFromAField(role, JsonReader.getValueFromPackage(jsonObject, role));
    }

    /**
     * Submits or cancel the creation of a new campaign depending of the parameter.
     *
     * @param button
     */
    public void manageTheChanges(String button) {
        campaignAddPage.clickOnButton(button);
    }

    /**
     * Validates that the information on the fields remains after the intend of a creation of a new campaign with invalid
     * inputs.
     *
     * @param jsonObject
     */
    public void theInformationIsPreserved(JSONObject jsonObject) {
        validInfoFromFormFirstPart(jsonObject);
    }

    /**
     * Validates that the information was filled out with the respective invalid data.
     *
     * @param jsonObject
     */
    public void invalidInfoFromTheForm(JSONObject jsonObject) {
        fillFormWithInfoFirstPart(jsonObject);
    }

    /**
     * Validates that a Pop Up jumps when the submit button is clicked with the respective message depending if the
     * campaign creation status.
     *
     * @param message
     */
    public void aMessageAboutTheStateIsDisplayed(String message) {
        campaignAddPage.messageAboutTheCampaignCreationStatus(message);
    }

    /**
     * Validates that the page is redirected towards the page that it's receive as parameter.
     *
     * @param page
     */
    public void thePageIsRedirected(String page) {
        campaignListPage.isRedirectedTowards(page);
        driver.get(JsonReader.getValue("Links", page));
        campaignListPage.waitForProgressBar();
    }

    /**
     * Private method with common validations using the information received for parameter
     *
     * @param jsonObject
     */
    private void validInfoFromFormFirstPart(JSONObject jsonObject) {
        campaignAddPage.validateInformationFromAField(campaignName, JsonReader.getValueFromPackage(jsonObject, campaignName));
        campaignAddPage.validateInformationFromDate(startDate, endDate);
        campaignAddPage.validateInformationFromChipContainer(chipContainer, JsonReader.getValueFromPackage(jsonObject, keywords));
        campaignAddPage.validateInformationFromAField(requestor, JsonReader.getValueFromPackage(jsonObject, requestor));
        campaignAddPage.validateInformationFromAField(project, JsonReader.getValueFromPackage(jsonObject, project));
    }

    /**
     * Private method that fills common fields using the information received for parameter.
     *
     * @param jsonObject
     */
    private void fillFormWithInfoFirstPart(JSONObject jsonObject) {
        campaignAddPage.fillInformationIntoInputFields(campaignName, JsonReader.getValueFromPackage(jsonObject, campaignName));
        campaignAddPage.fillInformationIntoDatefields(startDate, JsonReader.getValueFromPackage(jsonObject, startDate));
        campaignAddPage.fillInformationIntoDatefields(endDate, JsonReader.getValueFromPackage(jsonObject, endDate));
        campaignAddPage.fillInformationIntoInputFields(keywords, JsonReader.getValueFromPackage(jsonObject, keywords));
        campaignAddPage.clickOnButton(addKeywords);
        campaignAddPage.fillInformationIntoInputAutocompleteFields(requestor, JsonReader.getValueFromPackage(jsonObject, requestor));
        campaignAddPage.fillInformationIntoInputAutocompleteFields(project, JsonReader.getValueFromPackage(jsonObject, project));
    }


}
