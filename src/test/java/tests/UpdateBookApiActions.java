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

    @When("user updates a book with an invalid ID {string} and title {string} and author {string}")
    public void userUpdatesBookWithInvalidId(String invalidId, String title, String author) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);

        apiClient.updateBookWithInvalidId(invalidId, book);
    }

    @When("user updates a book with a non-existent ID {string}, title {string}, and author {string}")
    public void userUpdatesBookWithNonExistentId(String id, String title, String author) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);

        apiClient.updateBookWithNonExistentId(id, book);

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

    @When("user updates the book with only the id and title {string} in the request body")
    public void userUpdatesTheBookWithOnlyTheTitleInTheRequestBody(String string) {
        int id = apiClient.getStoredResponse().jsonPath().getInt("id");
        Book updatedBook = new Book(id, string, "");
        apiClient.updateBookWithOnlyTitle(updatedBook);
    }

    @When("user updates the book with only the id and author {string} in the request body")
    public void userUpdatesTheBookWithOnlyTheIdAndAuthorStringInTheRequestBody(String author) {
        int id = apiClient.getStoredResponse().jsonPath().getInt("id");
        Book updatedBook = new Book(id, "", author);
        apiClient.updateBookWithOnlyAuthor(updatedBook);
    }

    @When("user updates the book with title {string} and author {string} with new title {int} and new author {int}")
    public void userUpdatesTheBookWithTitleAndAuthorWithNewTitleAndNewAuthorWithInvalidValues(String title, String author, int newTitle, int newAuthor) {
        int id = apiClient.getStoredResponse().jsonPath().getInt("id");
        apiClient.updateBookWithInvalidValues(id, newTitle, newAuthor);
    }
}
