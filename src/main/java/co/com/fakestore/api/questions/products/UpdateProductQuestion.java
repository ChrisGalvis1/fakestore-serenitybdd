package co.com.fakestore.api.questions.products;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class UpdateProductQuestion implements Question <Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        return lastResponse().getStatusCode();
    }

    public static UpdateProductQuestion success(){
        return new UpdateProductQuestion();
    }
}
