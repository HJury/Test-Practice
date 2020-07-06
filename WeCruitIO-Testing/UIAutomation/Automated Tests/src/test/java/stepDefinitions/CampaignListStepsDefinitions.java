package stepDefinitions;

import Tasks.CampaignListTasks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.JsonReader;

public class CampaignListStepsDefinitions {
    private CampaignListTasks campaignListTasks;
    private String campaignBd = "Campaign on DB",
            allFilter = "All",
            myCampaigns = "My Campaigns",
            campaignAdd = "Campaign Add";


    @Given("^gets into Campaign List page$")
    public void the_user_gets_into_WeCruitIO_Campaign_List_page$() {
        campaignListTasks = new CampaignListTasks(Helper.driver);
    }

    @When("^the user clicks on the 'All' Filter button$")
    public void theUserClicksOnTheAllFilterButton() {
        campaignListTasks.theAllFilterIsSelected(allFilter);
        campaignListTasks.ClickOnTheButton(allFilter);
        campaignListTasks.theButtonIsNotSelected(myCampaigns);

    }

    @Then("^the user should see all the campaign displayed on the list$")
    public void theUserShouldSeeAllTheCampaignDisplayedOnTheList() {
        campaignListTasks.thisCampaignShouldExits(JsonReader.getInfoPackage(campaignBd));
    }

    @Then("^the user should see the campaign that he created$")
    public void theUserShouldSeeTheCampaignThatHeCreated() {
        //Agregar metodos que verifiquen que todos los requestor tienen el nombre de la persona logeada
    }

    @When("^the user clicks on the 'My Campaigns' Filter button$")
    public void theUserClickOnTheMyCampaignsFilterButton() {
        campaignListTasks.theAllFilterIsSelected(allFilter);
        campaignListTasks.ClickOnTheButton(myCampaigns);
        campaignListTasks.theButtonIsNotSelected(allFilter);
    }


    @When("^the user click on the (.*?) button$")
    public void the_user_click_on_the_Add_New_button(String button) {
        campaignListTasks.theAllFilterIsSelected(allFilter);
        campaignListTasks.ClickOnTheButton(button);
    }

    @When("^the user click on the action (.*?)$")
    public void the_user_click_on_the_button(String button) {
        campaignListTasks.ClickOnTheButtonOnAField(button, JsonReader.getInfoPackage(campaignBd));
    }

    @Given("^a campaign with long values on (.*?) exists$")
    public void a_campaign_with_long_values_on_field(String field) {
        if (!field.equals("Skills")) {
            campaignListTasks.theCampaignWithLongValueExistsOn(field, JsonReader.getInfoPackage(campaignBd));
        }
    }

    @Given("^a campaign has the status (.*?)$")
    public void a_campaign_has_the_status_Active(String status) {
        campaignListTasks.theCampaignHasTheStatus(status, JsonReader.getInfoPackage(campaignBd));
    }


    @Then("^the state of the campaign should change to (.*?)$")
    public void the_state_of_the_campaign_should_change_to_On_Hold(String status) {
        campaignListTasks.theStatusIs(status, JsonReader.getInfoPackage(campaignBd));
    }


    @When("^the user puts the mouse over the value of the (.*)$")
    public void the_user_puts_the_mouse_over_the_value_of_the_column(String field) {
        campaignListTasks.moveTheMouseTowards(field, JsonReader.getInfoPackage(campaignBd));
    }

    @Then("^the list should contains the column$")
    public void the_list_should_contains_the_column() {
        campaignListTasks.theRespectiveColumnExists(JsonReader.getInfoPackage(campaignBd));
        campaignListTasks.theSecondLineInfoExist(JsonReader.getInfoPackage(campaignBd));
        campaignListTasks.theDateHasTheFormart(JsonReader.getInfoPackage(campaignBd));
    }

    @Then("^the user should see a hover with the whole value of the (.*)$")
    public void the_should_see_a_hover_with_the_whole_value_of_the_element(String field) {
        campaignListTasks.isTheHoverShownTheTestOnThis(field, JsonReader.getInfoPackage(campaignBd));
    }

    @Then("^the action buttons (.*?) and (.*?) are shown$")
    public void the_action_buttons_button_and_button_are_shown(String button1, String button2) {
        campaignListTasks.areTheActionButtonDisplayed(button1, button2, JsonReader.getInfoPackage(campaignBd));
    }


    @Then("^the user should be redirected towards 'Campaign Add' page$")
    public void theUserShouldBeRedirectedTowards() {
        campaignListTasks.isRedirectedTowards(campaignAdd);
    }


}
