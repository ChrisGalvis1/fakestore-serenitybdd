package co.com.fakestore.api.tasks.users;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static co.com.fakestore.api.utils.Constants.*;

public class DeleteUserTask implements Task {

    private final String id;

    public DeleteUserTask(String id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(PATH_USERS + "/" + id)
                        .with(request -> request
                                .header("Content-Type", CONTENT_TYPE_JSON))
        );
        Response response = SerenityRest.lastResponse();
        actor.remember("STATUS_CODE", response.statusCode());
    }

    public static DeleteUserTask conId(String id) {
        return Tasks.instrumented(DeleteUserTask.class, id);
    }
}
