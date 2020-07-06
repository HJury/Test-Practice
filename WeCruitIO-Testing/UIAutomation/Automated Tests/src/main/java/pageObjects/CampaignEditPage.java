package pageObjects;

import interactions.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class CampaignEditPage extends CampaignAddPage {

    public CampaignEditPage(WebDriver driver) {
        super(driver);
    }

    public void editTheCampaignInformationCorrectly(String field, String value) {
        super.cleanAndSendKeys(value, super.getWebElementByName(field));
    }

    public void isRedirectedTowards(String page) {
        super.validationRedirectedPage(page);
    }

    public void cleanFieldsForEdit(String field) {
        Actions actions = new Actions(driver);
        actions.moveToElement(super.getWebElementByName(field)).click().perform();
        getWebElementByName("Clean " + field).click();
        List<WebElement> elements;
        elements = super.getWebElementsByName("Close ChipContainer");
        while (elements.size() > 0){
            elements.get(0).click();
            elements = super.getWebElementsByName("Close ChipContainer");
        };
    }

    public void thisFieldIsDiseable(String field) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(getWebElementByName(field).isEnabled(), "The field: " + field + " isn't disable");
    }

    public void waitUntilInformationIsDisplayed(String name) {
        Waits.waitUntilInformationInFieldIsDisplayed(super.getWebElementXpathByName(name), driver);
    }
}
