package co.com.fakestore.api.questions.users;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class AddNewUserQuestion implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        return lastResponse().statusCode();
    }

    public static AddNewUserQuestion success() {
        return new AddNewUserQuestion();
    }
}
