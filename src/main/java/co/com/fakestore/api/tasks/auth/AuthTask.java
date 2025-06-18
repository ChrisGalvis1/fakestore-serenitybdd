package co.com.fakestore.api.tasks.auth;

import co.com.fakestore.api.models.auth.AuthModel;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.fakestore.api.utils.Constants.*;

public class AuthTask implements Task {

    private final AuthModel authModel;

    public AuthTask(AuthModel authModel) {
        this.authModel = authModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(PATH_AUTH)
                        .with(request -> request
                                .header("Content-Type", CONTENT_TYPE_JSON)
                                .body(authModel))
        );
        Response response = SerenityRest.lastResponse();
        actor.remember("STATUS_CODE", response.getStatusCode());
    }

    public static AuthTask conCredenciales(AuthModel authModel) {
        return Tasks.instrumented(AuthTask.class, authModel);
    }
}
