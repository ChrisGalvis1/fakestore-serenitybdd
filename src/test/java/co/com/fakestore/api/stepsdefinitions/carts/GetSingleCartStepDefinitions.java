package co.com.fakestore.api.stepsdefinitions.carts;

import co.com.fakestore.api.questions.carts.GetSingleCartQuestion;
import co.com.fakestore.api.tasks.carts.GetSingleCartTask;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.fakestore.api.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetSingleCartStepDefinitions {

    @When("consulta el cart por medio del id {string}")
    public void consultaElCartPorMedioDelId(String id) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetSingleCartTask.conId(id)
        );
    }

    @Then("debería ver la respuesta con código exitoso al consultar el cart")
    public void deberíaVerLaRespuestaConCódigoExitosoAlConsultarElCart() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("La respuesta es 200",
                        GetSingleCartQuestion.success(),
                        equalTo(STATUS_200))
        );
    }
}
