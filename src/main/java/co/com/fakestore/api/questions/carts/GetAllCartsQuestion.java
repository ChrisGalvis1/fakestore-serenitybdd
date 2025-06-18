package co.com.fakestore.api.questions.carts;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class GetAllCartsQuestion implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        return lastResponse().getStatusCode();
    }

    public static GetAllCartsQuestion success(){
        return new GetAllCartsQuestion();
    }
}
