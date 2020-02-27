package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.security.Key;

public class AutomationDemoSite {
    WebDriver automationDemoSiteDriver;
    Select select;
    @FindBy(xpath = "//a[@href = 'WebTable.html']")
    WebElement WEBTABLE_HREF;
    @FindBy(xpath = "//input[@placeholder = 'First Name']")
    WebElement FIRST_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@placeholder = 'Last Name']")
    WebElement LAST_NAME_TEXTBOX;
    @FindBy(xpath = "//textarea[@rows = '3']")
    WebElement ADDRESS_TEXTAREA;
    @FindBy(xpath = "//input[@type = 'email']")
    WebElement EMAIL_ADDRESS_TEXTBOX;
    @FindBy(xpath = "//input[@type = 'tel']")
    WebElement PHONE_TEXTBOX;
    @FindBy(xpath = "//input[@type = 'radio' and @value = 'Male']")
    WebElement GENDER_RADIONBUTTON;
    @FindBy(id = "checkbox1")
    WebElement HOBBIE_CRICKET_CHECKBOX;
    @FindBy(id = "checkbox3")
    WebElement HOBBIE_HOCKEY_CHECKBOX;
    @FindBy(id = "msdd")
    WebElement LANGUAGES_MULTISELETBOX;
    @FindBy ( xpath = "//a[text() = 'Arabic']")
    WebElement LANGUAGE_OPTION_ARABIC;
    @FindBy ( xpath = "//a[text() = 'German']")
    WebElement LANGUAGE_OPTION_GERMAN;
    @FindBy(id = "Skills")
    WebElement SKILLS_SELECTBOX;
    @FindBy(id = "countries")
    WebElement COUNTRY_SELECTBOX;
    @FindBy(xpath = "//span[@role = 'combobox']")
    WebElement SELECT_COUNTRY_SELECTBOX;
    @FindBy(id = "yearbox")
    WebElement DATE_OF_BIRTH_YEAR_SELECTBOX;
    @FindBy(xpath = "//select[@placeholder = 'Month']")
    WebElement DATE_OF_BIRTH_MONTH_SELECTBOX;
    @FindBy(id = "daybox")
    WebElement DATE_OF_BIRTH_DAY_SELECTBOX;
    @FindBy(id = "firstpassword")
    WebElement PASSWORD_TEXTBOX;
    @FindBy(id = "secondpassword")
    WebElement CONFIRM_PASSWORD_TEXTBOX;
    @FindBy(id = "submitbtn")
    WebElement SUBMIT_BUTTON;
    @FindBy(id = "imagetrgt")
    WebElement IMG;
    @FindBy(xpath = "//input[@type = 'search' and @class = 'select2-search__field']")
    WebElement INPUT_SELECT_COUNTRY;


    public AutomationDemoSite(WebDriver automationDemoSiteDriver) {
        this.automationDemoSiteDriver = automationDemoSiteDriver;
        PageFactory.initElements(automationDemoSiteDriver, this);
    }

    private void Wait(WebElement element){


    }
    public void Write(String text, WebElement field) {
        field.sendKeys(text);
    }

    public void fillFirstName(String firstName) {
        Write(firstName, FIRST_NAME_TEXTBOX);
    }

    public void fillLastName(String lastName){
        Write(lastName, LAST_NAME_TEXTBOX);
    }

    public void fillAddress(String address){
        Write(address, ADDRESS_TEXTAREA);
    }

    public void fillEmailAddress(String email){
        Write(email, EMAIL_ADDRESS_TEXTBOX);
    }

    public void fillPhone(String phone){
        Write(phone, PHONE_TEXTBOX);
    }

    public void selectGender(){
        GENDER_RADIONBUTTON.click();
    }

    public void selectHobbies(){
        HOBBIE_CRICKET_CHECKBOX.click();
        HOBBIE_HOCKEY_CHECKBOX.click();
    }

    public void selectLanguage(){
        LANGUAGES_MULTISELETBOX.click();
        LANGUAGE_OPTION_ARABIC.click();
        LANGUAGE_OPTION_GERMAN.click();
        IMG.click();
    }

    public void selectSkill(String skill){
        select = new Select(SKILLS_SELECTBOX);
        select.selectByVisibleText(skill);
    }

    public void selectCountry(String country){
        select = new Select(COUNTRY_SELECTBOX);
        select.selectByVisibleText(country);
    }

    public void selectSelectCountry(String selectCountry){
        SELECT_COUNTRY_SELECTBOX.click();
        INPUT_SELECT_COUNTRY.sendKeys(selectCountry);
        INPUT_SELECT_COUNTRY.sendKeys(Keys.ENTER);
    }

    public void selectDateOfBirth(String year, String month, String day){
        select = new Select(DATE_OF_BIRTH_YEAR_SELECTBOX);
        select.selectByVisibleText(year);
        select = new Select(DATE_OF_BIRTH_MONTH_SELECTBOX);
        select.selectByVisibleText(month);
        select = new Select(DATE_OF_BIRTH_DAY_SELECTBOX);
        select.selectByVisibleText(day);
    }

    public void fillPassword(String password){
        PASSWORD_TEXTBOX.sendKeys(password);
    }

    public void fillConfirmPassword(String password){
        CONFIRM_PASSWORD_TEXTBOX.sendKeys(password);
    }

    public void submit(){
        SUBMIT_BUTTON.click();
    }
}
