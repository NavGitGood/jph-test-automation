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

    @When("get request is made for comments endpoint")
    public void getAllComments() {
        requestMaker.makeGetRequest(
                url + configurationLoader.getPropertyValue("resourceComments")
        );
    }

    @When("get request is made for albums endpoint")
    public void getAllAlbums() {
        requestMaker.makeGetRequest(
                url + configurationLoader.getPropertyValue("resourceAlbums")
        );
    }

    @When("get request is made for photos endpoint")
    public void getAllPhotos() {
        requestMaker.makeGetRequest(
                url + configurationLoader.getPropertyValue("resourcePhotos")
        );
    }

    @When("get request is made for todos endpoint")
    public void getAllTodos() {
        requestMaker.makeGetRequest(
                url + configurationLoader.getPropertyValue("resourceTodos")
        );
    }

    @When("get request is made for users endpoint")
    public void getAllUsers() {
        requestMaker.makeGetRequest(
                url + configurationLoader.getPropertyValue("resourceUsers")
        );
    }

    @Then("there should be {int} records in response")
    public void recordCountInResponse(Integer size) {
        assertThat(
                then().extract().response().jsonPath().getInt("$.size()"),
                is(size));
    }

    @Then("should follow the schema for posts")
    public void validatePostsSchema() {
        then().assertThat()
                .body(matchesJsonSchemaInClasspath("jsonSchema/postsSchema.json"));
    }

    @Then("should follow the schema for comments")
    public void validateCommentsSchema() {
        then().assertThat()
                .body(matchesJsonSchemaInClasspath("jsonSchema/commentsSchema.json"));
    }

    @Then("should follow the schema for albums")
    public void validateAlbumsSchema() {
        then().assertThat()
                .body(matchesJsonSchemaInClasspath("jsonSchema/albumsSchema.json"));
    }

    @Then("should follow the schema for photos")
    public void validatePhotosSchema() {
        then().assertThat()
                .body(matchesJsonSchemaInClasspath("jsonSchema/photosSchema.json"));
    }

    @Then("should follow the schema for todos")
    public void validateTodosSchema() {
        then().assertThat()
                .body(matchesJsonSchemaInClasspath("jsonSchema/todosSchema.json"));
    }

    @Then("should follow the schema for users")
    public void validateUsersSchema() {
        then().assertThat()
                .body(matchesJsonSchemaInClasspath("jsonSchema/usersSchema.json"));
    }

}
