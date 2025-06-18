package co.com.fakestore.api.tasks.products;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.fakestore.api.utils.Constants.*;

public class GetSingleProductTask implements Task {

    private final String id;

    public GetSingleProductTask(String id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(PATH_PRODUCTOS + "/" + id)
                        .with(request -> request
                                .header("Content-Type", CONTENT_TYPE_JSON))
        );
        Response response = SerenityRest.lastResponse();
        int statusCode = response.statusCode();
        actor.remember("STATUS_CODE", statusCode);
    }

    public static GetSingleProductTask conId(String id){
        return Tasks.instrumented(GetSingleProductTask.class, id);
    }
}
