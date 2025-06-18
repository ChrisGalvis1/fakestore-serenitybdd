package co.com.fakestore.api.stepsdefinitions.products;

import co.com.fakestore.api.models.products.ProductsModel;
import co.com.fakestore.api.questions.products.AddNewProductQuestion;
import co.com.fakestore.api.tasks.products.AddNewProductTask;
import co.com.fakestore.api.utils.ProductModelFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.fakestore.api.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class AddNewProductStepDefinitions {

    @When("realiza la creacion del producto con los datos")
    public void realizaLaCreacionDelProductoConLosDatos(io.cucumber.datatable.DataTable dataTable) {
        ProductsModel productsModel = ProductModelFactory.crearDesde(dataTable);
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddNewProductTask.con(productsModel)
        );
    }

    @Then("debería ver la respuesta con código exitoso al crear el producto")
    public void deberíaVerLaRespuestaConCódigoExitosoAlCrearElProducto() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("La respuesta es 200",
                        AddNewProductQuestion.success(),
                        equalTo(STATUS_200))
        );
    }
}
