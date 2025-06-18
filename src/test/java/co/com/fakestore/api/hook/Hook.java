package co.com.fakestore.api.hook;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.fakestore.api.utils.Constants.BASE_URL;

public class Hook {

    @Before
    public void setup(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Christian").can(CallAnApi.at(BASE_URL));
    }
}
