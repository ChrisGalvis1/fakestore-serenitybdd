package co.com.fakestore.api.tasks.users;

import co.com.fakestore.api.models.users.UserModel;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static co.com.fakestore.api.utils.Constants.*;

public class UpdateUserTask implements Task {

    private final String idUsuario;
    private final UserModel userModel;

    public UpdateUserTask(String idUsuario, UserModel userModel) {
        this.idUsuario = idUsuario;
        this.userModel = userModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(PATH_USERS + "/" + idUsuario)
                        .with(request -> request
                                .header("Content-Type", CONTENT_TYPE_JSON)
                                .body(userModel))
        );
        Response response = SerenityRest.lastResponse();
        actor.remember("STATUS_CODE", response.statusCode());
    }

    public static UpdateUserTask conIdYDatos(String idUsuario, UserModel userModel) {
        return Tasks.instrumented(UpdateUserTask.class, idUsuario, userModel);
    }
}
