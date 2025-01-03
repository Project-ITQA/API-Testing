package tests;

import clients.BookApiClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Book;
import net.serenitybdd.annotations.Steps;

public class GetBookByIDApiActions {
    @Steps
    BookApiClient bookApiClient;
    @When("user calls the service to get the book with valid ID {int}")
    public void successful_retrieval_of_a_book_for_admin_login (){
       bookApiClient.getBooksByID();
    }
    @Then("user gets the book with title {string} and author {string} and ID {int} as response")
    public void user_gets_the_book_as_response(String title, String author, int id) {
        bookApiClient.checkResponseBook(new Book(id, title, author));
    }


}
