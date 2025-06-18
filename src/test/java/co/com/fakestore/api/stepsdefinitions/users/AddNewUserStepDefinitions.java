package co.com.fakestore.api.stepsdefinitions.users;

import co.com.fakestore.api.models.users.UserModel;
import co.com.fakestore.api.questions.users.AddNewUserQuestion;
import co.com.fakestore.api.tasks.users.AddNewUserTask;
import co.com.fakestore.api.utils.UserModelFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.fakestore.api.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class AddNewUserStepDefinitions {

    @When("realiza la creacion del user con los datos")
    public void crearUsuarioConLosDatos(DataTable dataTable) {
        UserModel user = UserModelFactory.crearDesde(dataTable);
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddNewUserTask.con(user)
        );
    }

    @Then("debería ver la respuesta con código exitoso al crear el user")
    public void validarCreacionExitosa() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("Código exitoso",
                        AddNewUserQuestion.success(),
                        equalTo(STATUS_200))
        );
    }
}
