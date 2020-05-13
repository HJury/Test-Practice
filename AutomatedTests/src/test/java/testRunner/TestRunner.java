package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

//@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/java/resources/functionalTestsFeatures/example.feature",
        glue = "stepDefinitions", tags={"@EXECUTE"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class TestRunner extends AbstractTestNGCucumberTests {
}
