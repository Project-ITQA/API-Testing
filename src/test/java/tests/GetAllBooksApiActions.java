package tests;

import clients.BookApiClient;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import models.Book;
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

    @And("the response should contain a list of books")
    public void theResponseShouldContainAListOfBooks() {
        apiClient.checkResponseContainsBookInList(new Book());
    }

    @And("the response should contain an empty array")
    public void theResponseShouldContainAnEmptyArray() {
        apiClient.checkResponseReturnedEmptyList();
    }
}
