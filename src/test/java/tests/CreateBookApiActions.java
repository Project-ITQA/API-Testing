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
//        Book book = new Book(title, author);
        apiClient.createBookinvalidtitle(title,author);
    }

    @When("user sends a request to create a book with title - {string} and invalid author - {int}")
    public void userSendsARequestToCreateABookinvalidtitle(String title, int author) {
//        Book book = new Book(title, author);
        apiClient.createBookinvalidauthor(title,author);
    }


    @And("the response should contain an error message {string}")
    public void verifyErrorMessage(String error) {

        apiClient.verifyErrorMessage(error);
    }
}


