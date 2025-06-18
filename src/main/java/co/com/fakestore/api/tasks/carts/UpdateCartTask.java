package co.com.fakestore.api.tasks.carts;

import co.com.fakestore.api.models.carts.CartsModel;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static co.com.fakestore.api.utils.Constants.*;

public class UpdateCartTask implements Task {

    private final String idCarrito;
    private final CartsModel cartModel;

    public UpdateCartTask(String idCarrito, CartsModel cartModel) {
        this.idCarrito = idCarrito;
        this.cartModel = cartModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(PATH_CARTS + "/" + idCarrito)
                        .with(request -> request
                                .header("Content-Type", CONTENT_TYPE_JSON)
                                .body(cartModel))
        );

        Response response = SerenityRest.lastResponse();
        actor.remember("STATUS_CODE", response.statusCode());
    }

    public static UpdateCartTask conIdYDatos(String idCarrito, CartsModel cartModel) {
        return Tasks.instrumented(UpdateCartTask.class, idCarrito, cartModel);
    }
}
