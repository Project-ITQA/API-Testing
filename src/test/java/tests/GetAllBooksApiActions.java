package tests;

import clients.BookApiClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Book;
import net.serenitybdd.annotations.Steps;

public class GetAllBooksApiActions {
    @Steps
    BookApiClient apiClient;

    @Given("user is not logged in")
    public void userNotLoggedIn() {
    }

    @When("user asks for all books")
    public void asksForAllBooks() {
        apiClient.getAllBooks();
    }

//    @Then("user gets status code as {int}")
//    public void receiveStatusCode(int statusCode) {
//        apiClient.verifyStatusCode(statusCode);
//    }





}
