package co.com.fakestore.api.stepsdefinitions.products;

import co.com.fakestore.api.questions.products.GetSingleProductQuestion;
import co.com.fakestore.api.tasks.products.GetSingleProductTask;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.fakestore.api.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetSingleProductStepDefinitions {

    @When("consulta el producto por medio del id {string}")
    public void consultaElProductoPorMedioDelId(String id) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetSingleProductTask.conId(id)
        );
    }

    @Then("debería ver la respuesta con codigo exitoso al consultar el producto")
    public void deberíaVerLaRespuestaConCodigoExitosoAlConsultarElProducto() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("La respuesta es 200",
                        GetSingleProductQuestion.success(),
                        equalTo(STATUS_200))
        );
    }
}
