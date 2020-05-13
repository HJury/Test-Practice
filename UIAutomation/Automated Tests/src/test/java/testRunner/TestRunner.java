package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/java/resources/functionalTestsFeatures",
        //LA ETIQUETA @EXECUTE ES PARA EJECUTAR SÓLO LOS TESTS CON DICHA ETIQUETA
        glue = "stepDefinitions", tags={"@EXECUTE"},
        snippets = SnippetType.CAMELCASE)

//Este runner se debe ejecutar la primera vez para generar los métodos correspondientes.
//Una vez hecho eso, se definen los métodos en el StepDefinitions
public class TestRunner {
}
