package interactions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Actions {
    WebDriver driver;

    //<editor-fold desc="Elementos que solo pueden ser alcanzados en tiempo de ejecución">
    String XPATH_RIGHT_ARROW_DATESELECTOR = "//div[@role = 'dialog']/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[2]";
    String XPATH_11_BUTTON_DATESELECTOR = "//div[@role = 'dialog']/div[3]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[4]/button";
    String XPATH_OK_BUTTON_DATESELECTOR = "//div[@role = 'dialog']/div[3]/div/div[2]/button[2]";
    String XPATH_AUTOCOMPLETE_DROPBOX = "//div[@class = 'MuiPaper-root MuiAutocomplete-paper MuiPaper-elevation1 MuiPaper-rounded']";
    String XPATH_AUTOCOMPLETE_LIST = "//div[@class = 'MuiPaper-root MuiAutocomplete-paper MuiPaper-elevation1 MuiPaper-rounded']//ul";
    String XPATH_AUTOCOMPLETE_NO_MATCHES_FOUND = "//div[@class = 'MuiPaper-root MuiAutocomplete-paper MuiPaper-elevation1 MuiPaper-rounded']/div";
    String XPATH_CAMPAIGN_MESSAGE_BUTTON = "//div[@class= 'MuiSnackbar-root MuiSnackbar-anchorOriginTopCenter']/div/div[@class = 'MuiAlert-message']";
    //</editor-fold>

    public Actions(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeys(String text, WebElement element) {
        element.sendKeys(text);
    }

    public WebElement findElementByXpath(String xpath) {
        return this.driver.findElement(By.xpath(xpath));
    }

    public List<WebElement> findElementsByXpath(String xpath) {
        return this.driver.findElements(By.xpath(xpath));
    }


    public boolean validationRedirectedPage(String element) {
        Waits.waitUltiIsDisplayed(findElementByXpath(element), driver);
        if (findElementByXpath(element).isDisplayed())
            return true;
        return false;
    }

    public boolean messageAboutTheCampaignCreationStatus() {
        Waits.waitUltiIsDisplayed(findElementByXpath(XPATH_CAMPAIGN_MESSAGE_BUTTON), driver);
        if (findElementByXpath(XPATH_CAMPAIGN_MESSAGE_BUTTON).isDisplayed())
            return true;
        return false;
    }

    //<editor-fold desc="Methods of new Campaign">
    public void sendKeysAutocomplete(String date, WebElement webElement) {
        sendKeys(date, webElement);
        Waits.waitUltiIsDisplayed(findElementByXpath(XPATH_AUTOCOMPLETE_DROPBOX), driver);
        List<WebElement> list = findElementsByXpath(XPATH_AUTOCOMPLETE_LIST);
        list.get(0).click();
    }

    public void selectDateFromDateSelector(WebElement dateButton) {
        dateButton.click();
        findElementByXpath(XPATH_RIGHT_ARROW_DATESELECTOR).click();
        Waits.waitUltiIsDisplayed(findElementByXpath(XPATH_11_BUTTON_DATESELECTOR), driver);
        findElementByXpath(XPATH_11_BUTTON_DATESELECTOR).click();
        findElementByXpath(XPATH_OK_BUTTON_DATESELECTOR).click();
    }

    public boolean validationStartDateGreaterThanEndDate(WebElement startDate, WebElement endDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date start = dateFormat.parse(startDate.getAttribute("value"));
        Date end = dateFormat.parse(endDate.getAttribute("value"));
        if (end.compareTo(start) >= 0)
            return true;
        return false;
    }

    public void sendKeysOnDateFields(String date, WebElement dateElement) {
        dateElement.sendKeys(Keys.CONTROL + "a");
        dateElement.sendKeys(Keys.DELETE);
        sendKeys(date, dateElement);
    }

    public boolean validationNoMatchesFoundMessageIsPresent() {
        Waits.waitUltiIsDisplayed(findElementByXpath(XPATH_AUTOCOMPLETE_DROPBOX), driver);
        try {
            Assert.assertEquals(findElementByXpath(XPATH_AUTOCOMPLETE_NO_MATCHES_FOUND).getText(), "No matches found");
            return true;
        } catch (Exception e) {
            Exceptions.exceptionMessage(e);
        }
        return false;
    }
    //</editor-fold>
}
