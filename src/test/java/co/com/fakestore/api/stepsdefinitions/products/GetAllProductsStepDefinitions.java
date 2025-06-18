package co.com.fakestore.api.stepsdefinitions.products;

import co.com.fakestore.api.questions.products.GetAllProductsQuestion;
import co.com.fakestore.api.tasks.products.GetAllProductsTask;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.fakestore.api.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetAllProductsStepDefinitions {

    @Given("que el QA desea consultar el API de productos")
    public void queElQADeseaConsultarTodosLosProductos() {
        System.out.println("Iniciando Api Products...");
    }

    @When("realiza la solicitud al endpoint de productos")
    public void realizaLaSolicitudAlEndpointDeProductos() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetAllProductsTask.consult()
        );
    }

    @Then("debería ver la respuesta con código exitoso")
    public void deberíaVerLaRespuestaConCódigo() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("La respuesta es 200",
                        GetAllProductsQuestion.success(),
                        equalTo(STATUS_200))
        );
    }
}
