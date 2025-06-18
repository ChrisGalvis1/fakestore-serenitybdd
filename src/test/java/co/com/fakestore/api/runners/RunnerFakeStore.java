package co.com.fakestore.api.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"co.com.fakestore.api.stepsdefinitions", "co.com.fakestore.api.hook"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = "pretty"
)
public class RunnerFakeStore {
}
