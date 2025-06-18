package co.com.fakestore.api.stepsdefinitions.users;

import co.com.fakestore.api.questions.users.DeleteUserQuestion;
import co.com.fakestore.api.tasks.users.DeleteUserTask;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.fakestore.api.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteUserStepDefinitions {

    @When("elimina el user por medio del id {string}")
    public void eliminarElUsuarioPorId(String id) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DeleteUserTask.conId(id)
        );
    }

    @Then("debería ver el código de respuesta exitosa al eliminar el user")
    public void validarCodigoRespuesta() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("Código exitoso",
                        DeleteUserQuestion.success(),
                        equalTo(STATUS_200))
        );
    }
}
