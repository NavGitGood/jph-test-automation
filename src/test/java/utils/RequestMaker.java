package utils;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class RequestMaker {

    @Step
    public void makeGetRequest(String url) {
        SerenityRest.given()
                .when().get(url);
    }

}
