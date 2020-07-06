package stepDefinitions;

import Tasks.CampaignAddTasks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;
import util.JsonReader;

public class CampaignAddStepDefinition {

    //<editor-fold desc="Variables for Json calls">
    private String validInfo = "Valid info for Campaign Creation",
            links = "Links",
            campaignList = "Campaign List";
    //</editor-fold>

    private JSONObject jsonObjectValidInfo;
    private CampaignAddTasks campaignAddTasks;

    @Given("^select Create new campaign$")
    public void selectCreateNewCampaign() {
        campaignAddTasks = new CampaignAddTasks(Helper.driver);
        Helper.driver.get(JsonReader.getValue(links, "Campaign Add"));
        jsonObjectValidInfo = JsonReader.getInfoPackage(validInfo);
    }


    @When("the user fills out the form with valid information")
    public void theFillsOutTheFormWithValidInformation() {
        campaignAddTasks.fillFormWithValidInformation(jsonObjectValidInfo);
        campaignAddTasks.validateThatTheInformationWasFilledCorrectly(jsonObjectValidInfo);
    }


    @When("the user fills out the form with invalid information")
    public void theFillsOutTheFormWithInvalidInformation() {
        campaignAddTasks.invalidInfoFromTheForm(jsonObjectValidInfo);
        campaignAddTasks.validInfoFromTheForm(jsonObjectValidInfo);
        ;
    }


    @When("^(.*?) the modifications$")
    public void saveTheModifications(String action) {
        campaignAddTasks.theInformationIsPreserved(jsonObjectValidInfo);
        campaignAddTasks.manageTheChanges(action);
    }


    @Then("a new campaign should be created")
    public void aNewCampaignShouldBeCreated() {
        campaignAddTasks.aNewCampaignShouldBeCreated(campaignList, jsonObjectValidInfo);
        campaignAddTasks.theNewCampaignIsDeleted(campaignList, jsonObjectValidInfo);
        //campaignAddTasks.thisCampaignDoesntExist(jsonObjectValidInfo);
    }


    @Then("a message about the campaign status should be displayed")
    public void aMessageAboutTheCampaignStatusShouldBeDisplayed() {
        campaignAddTasks.aMessageAboutTheStateIsDisplayed("couldn't be created");
        campaignAddTasks.validInfoFromTheForm(jsonObjectValidInfo);
    }

    @Then("the campaign shouldn't be created")
    public void theCampaignShouldnTBeCreated() {
        campaignAddTasks.thePageIsRedirected(campaignList);
        campaignAddTasks.thisCampaignDoesntExist(jsonObjectValidInfo);
    }
}
