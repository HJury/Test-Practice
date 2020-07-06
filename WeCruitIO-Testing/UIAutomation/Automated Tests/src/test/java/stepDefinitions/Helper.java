package stepDefinitions;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import testRunner.TestRunner;
import util.JsonReader;
import util.PropertiesReader;

import java.io.IOException;


public class Helper {
    static public WebDriver driver;
    private String
            links = "Links",
            login = "Login";

    @Before
    static public void setUp() throws IOException {

        if (TestRunner.browser.equals("chrome")) {
            String path = System.getProperty("user.dir") + new PropertiesReader().getPropoValues("chromeDriver");
            System.setProperty("webdriver.chrome.driver", path);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors",
                    "--disable-dev-shm-usage", "--no-sandbox", "--remote-debugging-port=9922");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        } else if (TestRunner.browser.equals("firefox")) {
            String path = System.getProperty("user.dir") + new PropertiesReader().getPropoValues("firefoxDriver");
            System.setProperty("webdriver.gecko.driver", path);
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors",
                    "--disable-dev-shm-usage", "--no-sandbox", "--remote-debugging-port=9922");
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
        } else if (TestRunner.browser.equals("IE")) {
            String path = System.getProperty("user.dir") + new PropertiesReader().getPropoValues("ieDriver");
            System.setProperty("webdriver.ie.driver", path);
            InternetExplorerOptions options = new InternetExplorerOptions();
            driver = new InternetExplorerDriver(options);
        }
    }


    @Given("^the user login into WeCruitIO$")
    public void the_user_gets_into_WeCruitIO_Campaign_List_page$() {
        Helper.driver.get(JsonReader.getValue(links, login));
    }

    @After
    static public void quit() {
        driver.quit();
    }

}
