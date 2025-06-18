package co.com.fakestore.api.questions.auth;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class AuthQuestion implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        return lastResponse().getStatusCode();
    }

    public static AuthQuestion status() {
        return new AuthQuestion();
    }
}
