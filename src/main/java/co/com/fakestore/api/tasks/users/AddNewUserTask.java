package co.com.fakestore.api.tasks.users;

import co.com.fakestore.api.models.users.UserModel;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.fakestore.api.utils.Constants.*;

public class AddNewUserTask implements Task {

    private final UserModel userModel;

    public AddNewUserTask(UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(PATH_USERS)
                        .with(request -> request
                                .header("Content-Type", CONTENT_TYPE_JSON)
                                .body(userModel))
        );
        Response response = SerenityRest.lastResponse();
        actor.remember("STATUS_CODE", response.statusCode());
    }

    public static AddNewUserTask con(UserModel userModel) {
        return Tasks.instrumented(AddNewUserTask.class, userModel);
    }
}
