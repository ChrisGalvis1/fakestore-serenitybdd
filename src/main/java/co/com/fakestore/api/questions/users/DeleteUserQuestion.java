package co.com.fakestore.api.questions.users;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class DeleteUserQuestion implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        return lastResponse().statusCode();
    }

    public static DeleteUserQuestion success() {
        return new DeleteUserQuestion();
    }
}
