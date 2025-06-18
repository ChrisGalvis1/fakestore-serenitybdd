package co.com.fakestore.api.stepsdefinitions.carts;

import co.com.fakestore.api.models.carts.CartsModel;
import co.com.fakestore.api.questions.products.AddNewProductQuestion;
import co.com.fakestore.api.tasks.carts.AddNewCartTask;
import co.com.fakestore.api.utils.CartModelFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.fakestore.api.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class AddNewCartStepDefinitions {

    @When("realiza la creacion del carts con los datos")
    public void realizaLaCreacionDelCartsConLosDatos(io.cucumber.datatable.DataTable dataTable) {
        CartsModel cart = CartModelFactory.crearDesde(dataTable);
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddNewCartTask.conDatos(cart)
        );
    }

    @Then("debería ver la respuesta con código exitoso al crear el carts")
    public void deberíaVerLaRespuestaConCódigoExitosoAlCrearElCarts() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("La respuesta es 200",
                        AddNewProductQuestion.success(),
                        equalTo(STATUS_200))
        );
    }
}
