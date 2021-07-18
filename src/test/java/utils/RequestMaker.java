package utils;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.stream.Collectors;

public class RequestMaker {

    @Step
    public void makeGetRequest(String url) {
        SerenityRest.given()
                .when().get(url);
    }

    @Step
    public void makeGetRequest(String url, List<String> routes) {
        SerenityRest.given()
                .when().get(url
                +routes
                .stream()
                .collect(Collectors.joining()));
    }

}
