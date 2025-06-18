package co.com.fakestore.api.stepsdefinitions.users;

import co.com.fakestore.api.models.users.UserModel;
import co.com.fakestore.api.questions.users.UpdateUserQuestion;
import co.com.fakestore.api.tasks.users.UpdateUserTask;
import co.com.fakestore.api.utils.UserModelFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.Map;

import static co.com.fakestore.api.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class UpdateUserStepDefinitions {

    @When("actualiza el user por medio del id")
    public void actualizaElUsuarioConLosDatos(DataTable dataTable) {
        Map<String, String> datos = dataTable.asMaps().get(0);
        String idUsuario = datos.get("idUsuario");
        UserModel userModel = UserModelFactory.crearDesde(dataTable);
        OnStage.theActorInTheSpotlight().attemptsTo(
                UpdateUserTask.conIdYDatos(idUsuario, userModel)
        );
    }

    @Then("debería ver el código de respuesta exitosa al actualizar el user")
    public void validarCodigoRespuesta() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("Código exitoso",
                        UpdateUserQuestion.success(),
                        equalTo(STATUS_200))
        );
    }
}
