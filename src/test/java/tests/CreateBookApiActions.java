package tests;

import clients.BookApiClient;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Book;
import net.serenitybdd.annotations.Steps;

public class CreateBookApiActions {

    @Steps
    BookApiClient apiClient;

    @Then("user gets status code as {int}")
    public void receiveStatusCode(int statusCode) {
        apiClient.verifyStatusCode(statusCode);
    }


    @Given("user authenticates using username {string} and password {string}")
    public void userAuthenticatesUsingUsernameAndPassword(String arg0, String arg1) {
        apiClient.authenticate(arg0, arg1);
    }

    @When("user sends a request to create a book with title - {string} and author - {string}")
    public void userSendsARequestToCreateABook(String title, String author) {
        Book book = new Book(title, author);
        apiClient.createBook(book);
    }
    @When("user sends a request to create a book with invalid title - {int} and author - {string}")
    public void userSendsARequestToCreateABookinvalidtitle(int title, String author) {
        apiClient.createBookinvalidtitle(title,author);
    }

    @When("user sends a request to create a book with title - {string} and invalid author - {int}")
    public void userSendsARequestToCreateABookinvalidtitle(String title, int author) {
        apiClient.createBookinvalidauthor(title,author);
    }


    @And("the response should contain an error message {string}")
    public void verifyErrorMessage(String error) {
        apiClient.verifyErrorMessage(error);
    }

    @When("user posts the book details title {string} and author {string}")
    public void user_posts_the_book_details(String title, String author) {
        apiClient.createBook(new Book(title, author));
    }

    @Then("user gets the book with title {string} and author {string} and id {int} as response")
    public void user_gets_the_book_as_response(String title, String author, int id) {
        apiClient.checkResponseBook(new Book(id, title, author));
    }

    @Then("user gets the book with title {string} and author {string} as response")
    public void user_gets_the_book_as_response_with_new_id(String title, String author) {
        apiClient.checkResponseBook(new Book(title, author));
    }

    @Then("user gets {int} code")
    public void user_gets_code(int code) {
        apiClient.verifyStatusCode(code);
    }

    @When("user posts the book details title {string}")
    public void user_posts_the_book_details_title(String title) {
        Book book = new Book();
        book.setTitle(title);
        apiClient.createBook(book);
    }

    @When("user posts the book details author {string}")
    public void user_posts_the_book_details_author(String author) {
        Book book = new Book();
        book.setAuthor(author);
        apiClient.createBook(book);
    }

    @When("user posts the book details title {string} and author {string} and Id {int}")
    public void userPostsTheBookDetailsTitleAndAuthorAndId(String title, String author, int id) {
        apiClient.createBook(new Book(id, title, author));
    }
}


