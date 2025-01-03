package tests;

import clients.BookApiClient;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class GetAllBooksApiActions {
    @Steps
    BookApiClient apiClient;

    @When("the user requests the list of all books")
    public void theUserRequestsTheListOfAllBooks() {
        apiClient.getAllBooks();
    }

    @And("the response should be empty")
    public void theResponseShouldContainAnEmptyArray() {
        apiClient.checkResponseReturnedEmptyList();
    }

    @And("the response should be a list of books containing a book with title: {string} and author: {string}")
    public void theResponseShouldBeAListContainingBook(String title, String author) {
        apiClient.checkResponseContainsBookInList(title, author);
    }
}
