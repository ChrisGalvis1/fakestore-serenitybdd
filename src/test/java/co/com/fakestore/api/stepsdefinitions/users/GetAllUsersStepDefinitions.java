package co.com.fakestore.api.stepsdefinitions.users;

import co.com.fakestore.api.questions.users.GetAllUsersQuestion;
import co.com.fakestore.api.tasks.users.GetAllUsersTask;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.fakestore.api.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetAllUsersStepDefinitions {

    @Given("que el QA desea consultar el API de users")
    public void iniciarApiUsuarios() {
        System.out.println("Iniciando API Users...");
    }

    @When("realiza la solicitud al endpoint de users")
    public void realizaSolicitudUsuarios() {
        OnStage.theActorInTheSpotlight().attemptsTo(GetAllUsersTask.consult());
    }

    @Then("debería ver la respuesta con código exitoso de users")
    public void validarCodigoExitosoUsuarios() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("La respuesta es 200",
                        GetAllUsersQuestion.success(),
                        equalTo(STATUS_200))
        );
    }
}
