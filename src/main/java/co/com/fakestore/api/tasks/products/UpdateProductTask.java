package co.com.fakestore.api.tasks.products;

import co.com.fakestore.api.models.products.ProductsModel;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static co.com.fakestore.api.utils.Constants.*;

public class UpdateProductTask implements Task {

    private final String id;
    private final ProductsModel producto;

    public UpdateProductTask(String id, ProductsModel producto) {
        this.id = id;
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(PATH_PRODUCTOS + "/" + id)
                        .with(req -> req
                                .header("Content-Type", CONTENT_TYPE_JSON)
                                .body(producto))
        );
        Response response = SerenityRest.lastResponse();
        actor.remember("STATUS_CODE", response.statusCode());
    }

    public static UpdateProductTask conIdYDatos(String id, ProductsModel producto) {
        return Tasks.instrumented(UpdateProductTask.class, id, producto);
    }
}
