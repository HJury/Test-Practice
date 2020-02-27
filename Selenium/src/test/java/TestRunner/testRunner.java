package TestRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C://Users//rherrera//IdeaProjects//Selenium//src//Feature//SeleniumPractice",
        glue = {"stepDefinitions/SeleniumPractice"}, tags = {"@Execute"})
public class testRunner {
}
