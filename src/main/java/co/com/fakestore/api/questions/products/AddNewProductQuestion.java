package co.com.fakestore.api.questions.products;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class AddNewProductQuestion implements Question <Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        return lastResponse().getStatusCode();
    }

    public static AddNewProductQuestion success(){
        return new AddNewProductQuestion();
    }
}
