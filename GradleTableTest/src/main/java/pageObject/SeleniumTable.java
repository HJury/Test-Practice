package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SeleniumTable {
    private WebDriver driver;
    private String table = "", xpath;
    private List<WebElement> tagNamesTableElements;


    public SeleniumTable(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    private boolean nextElementOnTableExits(String xpath) {
        return driver.findElements(By.xpath(xpath)).size() != 0;
    }
    
    public void getTable() {

        xpath = "//*[@id = 'post-body-5867683659713562481']/div/div/table/child::*";//optiene todó lo que sea hijo de la table, y los agrega a una lista
        tagNamesTableElements = driver.findElements(By.xpath(xpath));
        for (int i = 0; i < tagNamesTableElements.size(); i++) {
            if (!tagNamesTableElements.get(i).getTagName().equals("tfoot")) {
                fillTable(tagNamesTableElements.get(i));   //llama la función que debe llenar el String table y le envia la fila
            }
        }
        for (int i = 0; i < tagNamesTableElements.size(); i++) {
            if (tagNamesTableElements.get(i).getTagName().equals("tfoot")) {
                fillTable(tagNamesTableElements.get(i));
            }
        }
        System.out.println(table);


    }

    private void fillTable(WebElement element) {  //Tomar todos los elemetos de una fila y agregarla al String "table"
        String xpathTable = "//*[@id = 'post-body-5867683659713562481']/div/div/table/" + element.getTagName() + "/tr"; //modifica el xpath para que se adapte al tag del elemento enviado
        List<WebElement> elementsOnEachRow = driver.findElements(By.xpath(xpathTable));//Obtiene todos los elementos del xpath
        for (int i = 0; i < elementsOnEachRow.size(); i++) {
                table = table + "    " + elementsOnEachRow.get(i).getText() + "\n";
        }

    }
}
