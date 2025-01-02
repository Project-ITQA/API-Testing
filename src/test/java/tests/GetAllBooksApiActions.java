package tests;

import clients.BookApiClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class GetAllBooksApiActions {
    @Steps
    BookApiClient apiClient;

    @Given("the user is not logged in")
    public void theUserIsNotLoggedIn() {
    }

    @When("the user requests the list of all books")
    public void theUserRequestsTheListOfAllBooks() {
        apiClient.getAllBooks();
    }
}
