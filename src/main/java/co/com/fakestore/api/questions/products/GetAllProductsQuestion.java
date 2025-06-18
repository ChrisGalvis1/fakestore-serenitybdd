package co.com.fakestore.api.questions.products;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.fakestore.api.utils.Constants.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class GetAllProductsQuestion implements Question<Integer> {


    @Override
    public Integer answeredBy(Actor actor) {
        return lastResponse().getStatusCode();
    }

    public static GetAllProductsQuestion success(){
        return new GetAllProductsQuestion();
    }
}
