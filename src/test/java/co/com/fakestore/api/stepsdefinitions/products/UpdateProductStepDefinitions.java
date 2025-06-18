package co.com.fakestore.api.stepsdefinitions.products;

import co.com.fakestore.api.models.products.ProductsModel;
import co.com.fakestore.api.questions.products.UpdateProductQuestion;
import co.com.fakestore.api.tasks.products.UpdateProductTask;
import co.com.fakestore.api.utils.ProductModelFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.Map;

import static co.com.fakestore.api.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class UpdateProductStepDefinitions {

    @When("actualiza el producto por medio del id")
    public void actualizaElProductoPorMedioDelId(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> datos = dataTable.asMaps().get(0);
        String idProducto = datos.get("idProducto");
        ProductsModel producto = ProductModelFactory.crearDesde(dataTable);
        OnStage.theActorInTheSpotlight().attemptsTo(
                UpdateProductTask.conIdYDatos(idProducto, producto)
        );
    }

    @Then("debería ver el código de respuesta exitosa al actualizar el producto")
    public void deberíaVerElCódigoDeRespuestaExitosaAlActualizarElProducto() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("La respuesta es 200",
                        UpdateProductQuestion.success(),
                        equalTo(STATUS_200))
        );
    }
}
