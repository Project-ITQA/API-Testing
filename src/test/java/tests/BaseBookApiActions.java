package tests;

import clients.BookApiClient;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class BaseBookApiActions {
    @Steps
    BookApiClient apiClient;

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        apiClient.verifyStatusCode(statusCode);
    }
}
