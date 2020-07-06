package stepDefinitions;

import Tasks.CampaignEditTasks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.JsonReader;

public class CampaignEditStepsDefinitions {
    CampaignEditTasks campaignEditTasks = new CampaignEditTasks(Helper.driver);
    private String campaignDB = "Campaign on DB",
            editCampaign = "Info for Edition",
            listPage = "Campaign List",
            save = "Save";


    @Given("gets into Edit Campaign page")
    public void getsIntoThePage() {
        campaignEditTasks.getIntoEditCampaignPage(JsonReader.getInfoPackage(campaignDB));
        campaignEditTasks.waitForElementsToBeDisplayed();
        campaignEditTasks.theFieldsAreDisabled();
    }

    @When("the user edits the campaign information correctly")
    public void theUserEditsTheCampaignInformationCorrectly() {
        campaignEditTasks.editTheCampaignInformationCorrectly(JsonReader.getInfoPackage(editCampaign));
    }

    @When("^(.*?) the changes$")
    public void savesTheChanges(String button) {
        campaignEditTasks.clickOnButton(button);
    }


    @Then("the campaign information should be updated")
    public void theCampaignInformationShouldBeUpdated() {
        campaignEditTasks.isRedirectedTowards(listPage);
        campaignEditTasks.waitForProgressBar();
        campaignEditTasks.theCampaignInformationShouldBeUpdated(JsonReader.getInfoPackage(editCampaign));
        campaignEditTasks.getIntoEditCampaignPage(JsonReader.getInfoPackage(editCampaign));
        campaignEditTasks.waitForElementsToBeDisplayed();
        campaignEditTasks.theFieldsAreDisabled();
        campaignEditTasks.editTheCampaignInformationCorrectly(JsonReader.getInfoPackage(campaignDB));
        campaignEditTasks.clickOnButton(save);
        campaignEditTasks.isRedirectedTowards(listPage);
    }

    @When("the user edits the campaign information incorrectly")
    public void theUserEditsTheCampaignInformationIncorrectly() {
        campaignEditTasks.editTheCampaignInformationIncorrectly();
    }

    @Then("the campaign information shouldn't be updated")
    public void theCampaignInformationShouldnTBeUpdated() {
        //campaignEditTasks.aMessageisShown("couldn't be created");
        campaignEditTasks.theCampaignInformationShouldnTBeUpdated(JsonReader.getInfoPackage(campaignDB));
    }

    @Then("the modifications should be canceled")
    public void theModificationsShouldBeCanceled() {
        campaignEditTasks.waitForProgressBar();
        campaignEditTasks.theModificationsShouldBeCanceled(JsonReader.getInfoPackage(campaignDB));
    }

}
