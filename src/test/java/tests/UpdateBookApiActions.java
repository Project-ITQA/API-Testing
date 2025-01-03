package tests;

import clients.BookApiClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Book;
import net.serenitybdd.annotations.Steps;

public class UpdateBookApiActions {

    @Steps
    BookApiClient bookApiClient;

    @When("user updates a book with an invalid ID {string} and title {string} and author {string}")
    public void userUpdatesBookWithInvalidId(String invalidId, String title, String author) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);

        bookApiClient.updateBookWithInvalidId(invalidId, book);
    }
}
