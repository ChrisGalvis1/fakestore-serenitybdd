package co.com.fakestore.api.questions.users;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class GetAllUsersQuestion implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        return lastResponse().getStatusCode();
    }

    public static GetAllUsersQuestion success() {
        return new GetAllUsersQuestion();
    }
}
