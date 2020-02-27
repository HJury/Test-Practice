package stepDefinitions.Other;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class Steps {
    WebDriver driver;
    @Given("Open the Firefox and searching for Goldilocks Tale on Google.com")
    public void open_the_Firefox_and_searching_for_Goldilocks_Tale_on_Google_com() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\rherrera\\IdeaProjects\\Jar's\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("http://www.Google.com");
        //throw new io.cucumber.java.PendingException();
    }

    @When("Goldilocks tale's page is full charger")
    public void goldilocks_tale_s_page_is_full_charger() {
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Goldilocks tale");
        search.submit();
        //throw new io.cucumber.java.PendingException();
    }

    @Then("Compare the title of the page with {string}")
    public void compare_the_title_of_the_page_with(String string) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html/body/div[6]/div[3]/div[10]/div[1]/div[3]/div/div[1]/div[1]/div[1]/div/div[1]/div[2]/div[1]/div/div/div[2]/div[1]/span")));
        assertEquals("Goldilocks tale - Buscar con Googlo",driver.getTitle());
        //throw new io.cucumber.java.PendingException();
    }
}
