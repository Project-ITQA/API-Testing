package tests;

import clients.BookApiClient;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Book;
import net.serenitybdd.annotations.Steps;

public class CreateBookApiActions {
    @Steps
    BookApiClient bookApiClient;

    @When("user posts the book details title {string} and author {string}")
    public void user_posts_the_book_details(String title, String author) {
        bookApiClient.createBook(new Book(title, author));
    }

    @Then("user gets the book with title {string} and author {string} and id {int} as response")
    public void user_gets_the_book_as_response(String title, String author, int id) {
        bookApiClient.checkResponseBook(new Book(id, title, author));
    }

    @Then("user gets the book with title {string} and author {string} as response")
    public void user_gets_the_book_as_response_with_new_id(String title, String author) {
        bookApiClient.checkResponseBook(new Book(title, author));
    }

    @Then("user gets {int} code")
    public void user_gets_code(int code) {
        bookApiClient.verifyStatusCode(code);
    }

    @When("user posts the book details title {string}")
    public void user_posts_the_book_details_title(String title) {
        Book book = new Book();
        book.setTitle(title);
        bookApiClient.createBookWithTitle(book);
    }

    @When("user posts the book details title {string} and author {string} and Id {int}")
    public void userPostsTheBookDetailsTitleAndAuthorAndId(String title, String author, int id) {
        bookApiClient.createBookWithId(new Book(id, title, author));
    }
}
