package bdd.step_definitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import utils.ConfigurationLoader;
import utils.RequestMaker;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static net.serenitybdd.rest.SerenityRest.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BaseSteps {

    public static String url;
    public static Map<String, String> resourceSchemaMap = Stream.of(new Object[][] {
            { "albums", "albumsSchema.json" },
            { "comments", "commentsSchema.json" },
            { "photos", "photosSchema.json" },
            { "posts", "postsSchema.json" },
            { "todos", "todosSchema.json" },
            { "users", "usersSchema.json" }
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (String) data[1]));

    @Steps
    RequestMaker requestMaker;

    @Steps
    ConfigurationLoader configurationLoader;

    @Before
    public void setup()
    {
        configurationLoader.readProperties();
    }

    @Given("the url for JPH")
    public void withBaseURL() {
        url = configurationLoader.getPropertyValue("baseURL");
    }

    @When("get request is made for {string} endpoint")
    public void getAllRecordsForResource(String resourceName) {
        requestMaker.makeGetRequest(
                url + configurationLoader.getPropertyValue(resourceName)
        );
    }

    @Then("response code should be {int}")
    public void assertResponseCode(Integer responseCode) {
        restAssuredThat(response -> response.statusCode(responseCode));
    }

    @Then("there should be {int} records in response")
    public void recordCountInResponse(Integer size) {
        assertThat(
                then().extract().response().jsonPath().getInt("$.size()"),
                is(size));
    }

    @Then("should follow the schema for {string}")
    public void validateSchema(String resourceName) {
        then().assertThat()
                .body(matchesJsonSchemaInClasspath("jsonSchema/" + resourceSchemaMap.get(resourceName)));
    }
}
