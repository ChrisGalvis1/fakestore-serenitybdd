package co.com.fakestore.api.stepsdefinitions.auth;

import co.com.fakestore.api.models.auth.AuthModel;
import co.com.fakestore.api.questions.auth.AuthQuestion;
import co.com.fakestore.api.tasks.auth.AuthTask;
import co.com.fakestore.api.utils.AuthModelFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.fakestore.api.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class AuthStepDefinitions {

    @Given("que el QA desea autenticarse en la API")
    public void queElQADeseaAutenticarseEnLaAPI() {
        System.out.println("Iniciando Api Auth...");
    }

    @When("realiza la autenticacion con las credenciales")
    public void realizaLaAutenticacion(DataTable dataTable) {
        AuthModel authModel = AuthModelFactory.crearDesde(dataTable);
        OnStage.theActorInTheSpotlight().attemptsTo(
                AuthTask.conCredenciales(authModel)
        );
    }

    @Then("debería ver el código de respuesta exitoso al autenticar")
    public void validarCodigoExitoso() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("Código exitoso",
                        AuthQuestion.status(),
                        equalTo(STATUS_200))
        );
    }

    @Then("debería ver el código de error al autenticar")
    public void validarCodigoError() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("Código error",
                        AuthQuestion.status(),
                        equalTo(STATUS_401))
        );
    }
}
