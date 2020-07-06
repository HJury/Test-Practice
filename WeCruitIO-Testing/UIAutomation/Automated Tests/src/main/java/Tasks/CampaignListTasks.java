package Tasks;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import pageObjects.CampaignListPage;
import util.JsonReader;

import java.util.Arrays;


public class CampaignListTasks {
    private String campaignName = "Name",
            tableHead = "Table Head",
            secondLine = "Second Line",
            columns = "Columns",
            regex = "Regex",
            infoSecondLine = "Second Line Info";
    private CampaignListPage campaignListPage;


    public CampaignListTasks(WebDriver driver) {
        campaignListPage = new CampaignListPage(driver);
    }

    /**
     * Validates that the columns into of campaign list contains the necessary fields such as
     * <p>
     *     <ul>
     *         <li>Name</li>
     *         <li>Role</li>
     *         <li>Requestor</li>
     *         <li>Skills</li>
     *         <li>End Date</li>
     *         <li>Stat</li>
     *         <li>Actions</li>
     *     </ul>
     * </p>
     *
     * @param jsonObject
     */
    public void theRespectiveColumnExists(JSONObject jsonObject) {
        campaignListPage.theRespectiveColumnsExist(Arrays.asList(JsonReader.getValueFromPackage(jsonObject, columns).split(",")), tableHead);
    }

    public void theDateHasTheFormart(JSONObject jsonObject) {
        campaignListPage.theDateHasTheFormart(JsonReader.getValueFromPackage(jsonObject, regex));
    }

    /**
     * Validates that the columns into of campaign list contains a second line info witch should contains
     * <ul>
     *     <li>Project Name</li>
     *     <li>Start Date</li>
     *     <li>Created by</li>
     * </ul>
     *
     * @param jsonObject
     */
    public void theSecondLineInfoExist(JSONObject jsonObject) {
        campaignListPage.theSecondLineinfoExist(Arrays.asList(JsonReader.getValueFromPackage(jsonObject, infoSecondLine).split(",")), secondLine);
    }

    /**
     * Validates that the elements received by parameters are displayed into the screen
     * been in this case (All) and (My Campaign) Filter buttons.
     *
     * @param button1
     * @param button2
     * @param jsonObject
     */
    public void areTheActionButtonDisplayed(String button1, String button2, JSONObject jsonObject) {
        campaignListPage.isThisElementDisplayed(JsonReader.getValueFromPackage(jsonObject, campaignName), button1);
        campaignListPage.isThisElementDisplayed(JsonReader.getValueFromPackage(jsonObject, campaignName), button2);
    }

    /**
     * Verify that the (All) Filter button is selected
     *
     * @param button
     */
    public void theAllFilterIsSelected(String button) {
        campaignListPage.theAllFilterIsSelected(button);
    }

    /**
     * Clicks on the button that is received as a parameter
     *
     * @param button
     */
    public void ClickOnTheButton(String button) {
        campaignListPage.clickOnButton(button);
    }

    /**
     * Clicks on a button depending of the field name that is received as parameters using the field name as an id
     * into the page object
     *
     * @param button
     * @param jsonObject
     */
    public void ClickOnTheButtonOnAField(String button, JSONObject jsonObject) {
        campaignListPage.clickOnButtonOnAField(JsonReader.getValueFromPackage(jsonObject, campaignName), button);
    }

    /**
     * Verify that the button that is received as parameter is not selected
     *
     * @param button
     */
    public void theButtonIsNotSelected(String button) {
        campaignListPage.theButtonIsNotSelected(button);
    }

    /**
     * Verify that a campaign that match with the information received into the JSONObject exist in the list.
     *
     * @param jsonObject
     */
    public void thisCampaignShouldExits(JSONObject jsonObject) {
        campaignListPage.validationCampaignExists(JsonReader.getValueFromPackage(jsonObject, campaignName));
    }

    /**
     * Validates that the page is redirected towards the page that it's receive as parameter.
     *
     * @param page
     */
    public void isRedirectedTowards(String page) {
        campaignListPage.isRedirectedTowards(page);
    }

    /**
     * Verify that the status of the campaign that match with the information received into the JSONObject is the same
     * as the status received as parameter
     *
     * @param status
     * @param jsonObject
     */
    public void theStatusIs(String status, JSONObject jsonObject) {
        campaignListPage.theStatusIs(JsonReader.getValueFromPackage(jsonObject, campaignName), status);
    }

    /**
     * Verify that a field into the campaign that matches the information of the JSONObject contains a long value.
     *
     * @param field
     * @param jsonObject
     */
    public void theCampaignWithLongValueExistsOn(String field, JSONObject jsonObject) {
        campaignListPage.theFieldWithLongValuesShowEllipsis(JsonReader.getValueFromPackage(jsonObject, campaignName), field);
        campaignListPage.thisFieldWithThisInformationExists(JsonReader.getValueFromPackage(jsonObject, campaignName), field);
    }

    /**
     * It moves the moves towards an element in order to active the hover action.
     *
     * @param field
     * @param jsonObject
     */
    public void moveTheMouseTowards(String field, JSONObject jsonObject) {
        campaignListPage.moveTheMouseTowards(JsonReader.getValueFromPackage(jsonObject, campaignName), field);
    }

    /**
     * Verify that the hover is displayed and shows the respective information
     *
     * @param field
     * @param jsonObject
     */
    public void isTheHoverShownTheTestOnThis(String field, JSONObject jsonObject) {
        campaignListPage.isTheHoverShownTheTestOnThis(JsonReader.getValueFromPackage(jsonObject, field));
    }

    /**
     * Verify that the status of the campaign that match with the information received into the JSONObject is the same
     * as the status received as parameter, if is doesn't match, then, it is changed.
     *
     * @param status
     * @param jsonObject
     */
    public void theCampaignHasTheStatus(String status, JSONObject jsonObject) {
        campaignListPage.theCampaignHasTheStatus(JsonReader.getValueFromPackage(jsonObject, campaignName), status);
    }

}
