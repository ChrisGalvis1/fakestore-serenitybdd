package co.com.fakestore.api.stepsdefinitions.carts;

import co.com.fakestore.api.questions.carts.DeleteCartQuestion;
import co.com.fakestore.api.tasks.carts.DeleteCartTask;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.fakestore.api.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteCartStepDefinitions {

    @When("elimina el cart por medio del id {string}")
    public void eliminaElCartPorMedioDelId(String id) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DeleteCartTask.conId(id)
        );
    }

    @Then("debería ver el código de respuesta exitosa al eliminar el cart")
    public void deberíaVerElCódigoDeRespuestaExitosaAlEliminarElCart() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("La respuesta es 200",
                        DeleteCartQuestion.success(),
                        equalTo(STATUS_200))
        );
    }
}
