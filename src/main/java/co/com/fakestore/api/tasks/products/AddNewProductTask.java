package co.com.fakestore.api.tasks.products;

import co.com.fakestore.api.models.products.ProductsModel;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.fakestore.api.utils.Constants.*;

public class AddNewProductTask implements Task {

    private final ProductsModel productsModel;

    public AddNewProductTask(ProductsModel productsModel){
        this.productsModel = productsModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(PATH_PRODUCTOS)
                        .with(requests -> requests
                                .header("Content-Type", CONTENT_TYPE_JSON)
                                .body(productsModel))
        );
        Response response = SerenityRest.lastResponse();
        actor.remember("STATUS_CODE", response.statusCode());
    }

    public static AddNewProductTask con(ProductsModel productsModel){
        return Tasks.instrumented(AddNewProductTask.class, productsModel);
    }
}
