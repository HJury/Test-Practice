package com.screenplay.automation.userInterface;

import net.bytebuddy.implementation.bind.annotation.Default;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://demo.automationtesting.in/Register.html")
public class AutomationDemoPage extends PageObject {
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

    public AutomationDemoPage(WebDriver driver) {
        super(driver);
    }
}
