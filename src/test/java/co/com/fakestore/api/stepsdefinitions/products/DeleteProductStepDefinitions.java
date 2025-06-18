package co.com.fakestore.api.stepsdefinitions.products;

import co.com.fakestore.api.questions.products.DeleteProductQuestion;
import co.com.fakestore.api.questions.products.GetAllProductsQuestion;
import co.com.fakestore.api.tasks.products.DeleteProductTask;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.fakestore.api.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteProductStepDefinitions {

    @When("eliminar el producto por medio del id {string}")
    public void eliminarElProductoPorMedioDelId(String id) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DeleteProductTask.conId(id)
        );
    }

    @Then("debería ver el código de respuesta exitosa al eliminar el producto")
    public void deberíaVerElCódigoDeRespuestaExitosaAlEliminarElProducto() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("La respuesta es 200",
                        DeleteProductQuestion.success(),
                        equalTo(STATUS_200))
        );
    }
}
