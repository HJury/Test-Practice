package interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Waits {


    private Waits(WebDriver driver){


    }

    public static void waitUltiIsDisplayed(WebElement element,WebDriver driver){
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void waitForAttribute(String value, WebElement element){

    }
}
