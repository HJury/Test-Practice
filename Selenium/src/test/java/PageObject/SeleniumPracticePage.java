package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class SeleniumPracticePage<T> {
    //<editor-fold desc="@FindBys">
    private WebDriver driver;
    @FindBy(name = "firstname")
    WebElement FIRST_NAMETXBX;
    @FindBy(name = "lastname")
    WebElement LAST_NAMETXBX;
    @FindBy(id = "datepicker")
    WebElement DATETXBX;
    @FindBy(id = "sex-0")
    WebElement RADIOBUTTOM_SEX;
    @FindBy(id = "exp-2")
    WebElement RADIOBUTTOM_EXP;
    @FindBy(id = "profession-0")
    WebElement CHECKBOX_PROFESSION_0;
    @FindBy(id = "profession-1")
    WebElement CHECKBOX_PROFESSION_1;
    @FindBy(id = "tool-0")
    WebElement CHECKBOX_TOOL_0;
    @FindBy(id = "tool-1")
    WebElement CHECKBOX_TOOL_1;
    @FindBy(id = "tool-2")
    WebElement CHECKBOX_TOOL_2;
    @FindBy(id = "continents")
    WebElement SELECTBOX_CONTINENTS;
    @FindBy(id = "selenium_commands")
    WebElement SELECTBOX_SELENIUM_COMMANDS;
    @FindBy(id = "photo")
    WebElement UPLOAD_PHOTO;
    @FindBy(linkText = "Click here to Download File")
    WebElement DOWNLOAD_FILE_HREF;
    @FindBy(css = "body")
    WebElement BODY;
    @FindBy(id = "submit")
    WebElement SUBMIT_BUTTON;

    private Select selectContinents, selectSeleniumCommands;
    //</editor-fold>


    public SeleniumPracticePage(WebDriver driver) {
        this.driver = driver;
    }

    public void FirefoxConnection() {
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        this.waitPageTillVisibility(driver.findElement(By.id("Followers1-wrapper")));

        //Esto crea la intancia de todos los WebElements declarados con el @FindBy
        PageFactory.initElements(driver, this);

        //Inicialización de objetos Select
        selectContinents = new Select(SELECTBOX_CONTINENTS);
        selectSeleniumCommands = new Select(SELECTBOX_SELENIUM_COMMANDS);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void waitPageTillVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(this.driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    //<editor-fold desc="SENDKEYS METHODS">
    public void typeF(String input) {
        typeElement(FIRST_NAMETXBX, input);
    }

    public void typeL(String input) {
        typeElement(LAST_NAMETXBX, input);
    }

    public void typeD(String input) {
        typeElement(DATETXBX, input);
    }

    private void typeElement(WebElement element, String input) {
        element.sendKeys(input);
    }
    //</editor-fold>

    //<editor-fold desc="ASSERT METHODS">
    public String AssertF() {
        return FIRST_NAMETXBX.getAttribute("value").toString();
    }

    public String AssertL() {
        return LAST_NAMETXBX.getAttribute("value").toString();
    }

    public String AssertD() {
        return DATETXBX.getAttribute("value").toString();
    }

    public boolean AssertProfession0() {
        return CHECKBOX_PROFESSION_0.isSelected();
    }

    public boolean AssertProfession1() {
        return CHECKBOX_PROFESSION_1.isSelected();
    }

    public boolean AssertTool0() {
        return CHECKBOX_TOOL_0.isSelected();
    }

    public boolean AssertTool1() {
        return CHECKBOX_TOOL_1.isSelected();
    }

    public boolean AssertTool2() {
        return CHECKBOX_TOOL_2.isSelected();
    }

    public boolean AssertSelectContinent() {
        return SELECTBOX_CONTINENTS.getAttribute("value").equals("Australia");
    }

    public boolean AssertSelectCommands() {
        return SELECTBOX_SELENIUM_COMMANDS.getAttribute("value").equals("Wait Commands");
    }

    public boolean AssertUploadPhoto() {
        return UPLOAD_PHOTO.getAttribute("value").equals("document.pdf");
    }
    //</editor-fold>

    //<editor-fold desc="RADIO BUTTOMS">
    public void clickSex() {
        RADIOBUTTOM_SEX.click();
    }

    public void clickExp() {
        RADIOBUTTOM_EXP.click();
    }
    //</editor-fold>

    //<editor-fold desc="CHECKBOXES">
    public void checkboxP0() {
        CHECKBOX_PROFESSION_0.click();
    }

    public void checkboxP1() {
        CHECKBOX_PROFESSION_1.click();
    }

    public void checkboxT0() {
        CHECKBOX_TOOL_0.click();
    }

    public void checkboxT1() {
        CHECKBOX_TOOL_1.click();
    }

    public void checkboxT2() {
        CHECKBOX_TOOL_2.click();
    }
    //</editor-fold>

    //<editor-fold desc="SELECTBOXEX">
    public void SelectBoxContinent(String continent) {
        selectContinents.selectByVisibleText(continent);
    }

    public void SelectBoxCommands(String command) {
        selectSeleniumCommands.selectByVisibleText(command);
    }
    //</editor-fold>

    //<editor-fold desc="DOCUMENT DOWNLOAD">
    public void uploadFile(String address) {
        UPLOAD_PHOTO.sendKeys(address);
    }

    public void downloadADocument() throws InterruptedException, AWTException {
        DOWNLOAD_FILE_HREF.sendKeys(Keys.CONTROL, Keys.chord(Keys.SHIFT, Keys.ENTER));
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));


    }
    //</editor-fold>

    public void hundredClicksOnThatButtonBecauseIWantToCelebrateThatIFinishTheAutomation() throws InterruptedException {
        for (int i =0; i<100;i++){
            Actions action = new Actions(driver);
            action.moveToElement(SUBMIT_BUTTON).clickAndHold().build().perform();
            Thread.sleep(10);
            action.release().build().perform();
        }
    }
}
