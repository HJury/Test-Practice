package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

public class GitPracticeDownload {
    WebDriver driver;


    @FindBy(id = "raw-url")
    WebElement RAW;


    public GitPracticeDownload(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




    public void downloadRAW() throws InterruptedException, AWTException {
        Actions action = new Actions(driver);
        action.contextClick(RAW).build().perform();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);

    }

    public boolean assertIsDownloadedTheFile(String fileName) {
        File dir = new File("C:\\Users\\rherrera\\Downloads");
        File[] dir_contents = dir.listFiles();
        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                return true;
        }
        return false;
    }


}
