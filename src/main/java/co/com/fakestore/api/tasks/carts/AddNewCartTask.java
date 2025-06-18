package co.com.fakestore.api.tasks.carts;

import co.com.fakestore.api.models.carts.CartsModel;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.fakestore.api.utils.Constants.*;

public class AddNewCartTask implements Task {

    private final CartsModel cart;

    public AddNewCartTask(CartsModel cart) {
        this.cart = cart;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(PATH_CARTS)
                        .with(request -> request
                                .header("Content-Type", CONTENT_TYPE_JSON)
                                .body(cart)
                        )
        );
        Response response = SerenityRest.lastResponse();
        actor.remember("STATUS_CODE", response.statusCode());
    }

    public static AddNewCartTask conDatos(CartsModel cart) {
        return Tasks.instrumented(AddNewCartTask.class, cart);
    }
}
