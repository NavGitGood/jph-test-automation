package bdd.step_definitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import utils.ConfigurationLoader;
import utils.RequestMaker;

import static net.serenitybdd.rest.SerenityRest.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BaseSteps {

    public static String url;

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

    @When("get request is made for posts endpoint")
    public void getAllPosts() {
        requestMaker.makeGetRequest(
                url + configurationLoader.getPropertyValue("resourcePosts")
        );
    }

    @Then("there should be {int} records in response")
    public void recordCountInResponse(Integer size) {
        assertThat(
                then().extract().response().jsonPath().getInt("$.size()"),
                is(size));
    }

    @Then("should follow the schema")
    public void validatePostsSchema() {
        then().assertThat()
                .body(matchesJsonSchemaInClasspath("jsonSchema/postsSchema.json"));
    }

}
