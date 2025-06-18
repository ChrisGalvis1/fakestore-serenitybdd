package co.com.fakestore.api.tasks.carts;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static co.com.fakestore.api.utils.Constants.*;

public class DeleteCartTask implements Task {

    private final String id;

    public DeleteCartTask(String id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(PATH_CARTS + "/" + id)
                        .with(request -> request
                                .header("Content-Type", CONTENT_TYPE_JSON))
        );

        Response response = SerenityRest.lastResponse();
        actor.remember("STATUS_CODE", response.statusCode());
    }

    public static DeleteCartTask conId(String id) {
        return Tasks.instrumented(DeleteCartTask.class, id);
    }
}
