package co.com.fakestore.api.tasks.carts;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.fakestore.api.utils.Constants.*;

public class GetSingleCartTask implements Task {

    private final String id;

    public GetSingleCartTask(String id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(PATH_CARTS + "/" + id)
                        .with(request -> request
                                .header("Content-Type", CONTENT_TYPE_JSON))
        );

        Response response = SerenityRest.lastResponse();
        actor.remember("STATUS_CODE", response.statusCode());
    }

    public static GetSingleCartTask conId(String id) {
        return Tasks.instrumented(GetSingleCartTask.class, id);
    }
}
