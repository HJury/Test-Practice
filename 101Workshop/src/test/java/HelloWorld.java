import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorld {

    /**
     *this method is tovalidate or maven dependencies
     * @param args
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rherrera\\IdeaProjects\\GitHub\\101Workshop\\src\\test\\resources\\chromedriver.exe");
        WebDriver wd = new ChromeDriver();
        wd.get("https://www.google.com/");
    }
}
