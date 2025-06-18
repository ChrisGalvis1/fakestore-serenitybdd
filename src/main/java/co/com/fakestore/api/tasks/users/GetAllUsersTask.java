package co.com.fakestore.api.tasks.users;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.fakestore.api.utils.Constants.*;

public class GetAllUsersTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(PATH_USERS)
                        .with(request -> request
                                .header("Content-Type", CONTENT_TYPE_JSON))
        );
        Response response = SerenityRest.lastResponse();
        actor.remember("STATUS_CODE", response.statusCode());
    }

    public static GetAllUsersTask consult() {
        return Tasks.instrumented(GetAllUsersTask.class);
    }
}
