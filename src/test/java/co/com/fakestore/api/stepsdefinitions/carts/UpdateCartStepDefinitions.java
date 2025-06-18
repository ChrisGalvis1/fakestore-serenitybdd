package co.com.fakestore.api.stepsdefinitions.carts;

import co.com.fakestore.api.models.carts.CartsModel;
import co.com.fakestore.api.questions.carts.UpdateCartQuestion;
import co.com.fakestore.api.tasks.carts.UpdateCartTask;
import co.com.fakestore.api.utils.CartModelFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.Map;

import static co.com.fakestore.api.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class UpdateCartStepDefinitions {

    @When("actualiza el cart por medio del id")
    public void actualizaElCartPorMedioDelId(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> datos = dataTable.asMaps().get(0);
        String idCarrito = datos.get("idCarrito");
        CartsModel carrito = CartModelFactory.crearDesde(dataTable);
        OnStage.theActorInTheSpotlight().attemptsTo(
                UpdateCartTask.conIdYDatos(idCarrito, carrito)
        );
    }

    @Then("debería ver el código de respuesta exitosa al actualizar el cart")
    public void deberíaVerElCódigoDeRespuestaExitosaAlActualizarElCart() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("La respuesta es 200",
                        UpdateCartQuestion.success(),
                        equalTo(STATUS_200))
        );
    }
}
