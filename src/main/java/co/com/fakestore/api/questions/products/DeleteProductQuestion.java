package co.com.fakestore.api.questions.products;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class DeleteProductQuestion implements Question <Integer>{
    @Override
    public Integer answeredBy(Actor actor) {
        return lastResponse().getStatusCode();
    }

    public static DeleteProductQuestion success(){
        return new DeleteProductQuestion();
    }
}
