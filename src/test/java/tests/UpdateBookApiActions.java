package tests;

import clients.BookApiClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Book;
import net.serenitybdd.annotations.Steps;

public class UpdateBookApiActions {

    @Steps
    BookApiClient apiClient;

    @When("user updates the book with title {string} and author {string} with new title {string} and new author {string}")
    public void user_updates_the_book_with_title_and_author_with_new_title_and_new_author(String title, String author, String newTitle, String newAuthor) {
        int id = apiClient.getStoredResponse().jsonPath().getInt("id");
        Book updatedBook = new Book(id, newTitle, newAuthor);
        apiClient.updateBook(updatedBook);
    }


    @Then("user gets the updated book with title {string} and author {string} and id as response")
    public void userGetsTheUpdatedBookWithTitleAndAuthorAndIdAsResponse(String title, String author) {
        int id = apiClient.getStoredResponse().jsonPath().getInt("id");
        apiClient.checkResponseBook(new Book(id, title, author));
    }

    @When("the user updates the book with only title {string}")
    public void theUserUpdatesTheBookWithOnlyTitle(String title) {
        int id = apiClient.getStoredResponse().jsonPath().getInt("id");
        Book updatedBook = new Book(id, title, "");
        apiClient.updateBookWithOnlyTitle(updatedBook);
    }
}
