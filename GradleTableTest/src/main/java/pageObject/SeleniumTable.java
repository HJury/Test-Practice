package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SeleniumTable {
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"post-body-5867683659713562481\"]/div/div/table/tbody/tr[1]")
    List<WebElement> TABLE;

    public SeleniumTable(WebDriver driver) {
        this.driver = driver;
    }

    public boolean getTable() {
        if (TABLE.size() > 0)
            return true;
        else
            return false;
    }

    public void printTable(){
        for(WebElement row: TABLE){
            System.out.println(row.getAttribute("value"));
        }
    }
}
