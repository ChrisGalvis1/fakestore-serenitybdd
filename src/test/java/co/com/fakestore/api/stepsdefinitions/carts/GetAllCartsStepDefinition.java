package co.com.fakestore.api.stepsdefinitions.carts;

import co.com.fakestore.api.questions.carts.GetAllCartsQuestion;
import co.com.fakestore.api.tasks.carts.GetAllCartsTask;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.fakestore.api.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetAllCartsStepDefinition {

    @Given("que el QA desea consultar el API de carts")
    public void queElQADeseaConsultarElAPIDeCarts() {
        System.out.println("Iniciando Api Carts...");
    }

    @When("realiza la solicitud al endpoint de carts")
    public void realizaLaSolicitudAlEndpointDeCarts() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetAllCartsTask.consultar()
        );
    }

    @Then("debería ver la respuesta con código exitoso de carts")
    public void deberíaVerLaRespuestaConCódigoExitosoDeCarts() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("La respuesta es 200",
                        GetAllCartsQuestion.success(),
                        equalTo(STATUS_200))
        );
    }
}
