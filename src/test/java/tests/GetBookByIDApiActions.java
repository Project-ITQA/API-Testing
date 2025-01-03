package tests;

import clients.BookApiClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Book;
import net.serenitybdd.annotations.Steps;

public class GetBookByIDApiActions {

    @Steps
    BookApiClient apiClient;


    @Given("a book exists in the database with title {string}, and author {string}")
    public void aBookExistsInTheDatabase( String title, String author) {
        Book book = new Book(title, author);
        apiClient.authenticate("user", "password");
        apiClient.createBook(book);
    }

    @When("user requests book details by ID {int}")
    public void userRequestsBookDetailsByID(int id) {
//        apiClient.authenticate("", "");
        apiClient.getBookByIdWithoutAuth(id);



    }

    @Then("user gets status code as {int} - getid")
    public void userGetsUnauthorizedResponse(int statusCode) {
        apiClient.verifyStatusCode(statusCode);

    }
}
