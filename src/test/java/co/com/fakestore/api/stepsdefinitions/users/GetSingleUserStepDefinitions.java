package co.com.fakestore.api.stepsdefinitions.users;

import co.com.fakestore.api.questions.users.GetSingleUserQuestion;
import co.com.fakestore.api.tasks.users.GetSingleUserTask;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.fakestore.api.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetSingleUserStepDefinitions {

    @When("consulta el user por medio del id {string}")
    public void consultaUsuarioPorId(String id) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetSingleUserTask.conId(id)
        );
    }

    @Then("debería ver la respuesta con código exitoso al consultar el user")
    public void validarConsultaExitosa() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("Código exitoso",
                        GetSingleUserQuestion.success(),
                        equalTo(STATUS_200))
        );
    }

}
