package tests;

import clients.BookApiClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class BaseBookApiActions {
    @Steps
    BookApiClient apiClient;

    @Given("the user is logged in with username: {string} and password: {string}")
    public void theUserIsLoggedInWithUsernameAndPassword(String username, String password) {
        apiClient.authenticate(username, password);
    }

    @Given("the user is not logged in")
    public void theUserIsNotLoggedIn() {
        apiClient.noAuthenticate();
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        apiClient.verifyStatusCode(statusCode);
    }
}
