package tests;

import clients.BookApiClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class DeleteBookApiActions {
    @Steps
    BookApiClient bookApiClient;

    @When("user deletes the previously added book as admin")
    public void user_deletes_the_book_prev_as_admin() {
        bookApiClient.sendDeletePrevBookRequestasAdmin();
    }

    @When("user deletes the previously added book as user")
    public void user_deletes_the_book_with_prev_as_user() {
        bookApiClient.sendDeletePrevBookRequestasUser();
    }

    @When("user deletes the book with Id {int}")
    public void user_deletes_the_book_with_id(int id) {
        bookApiClient.sendDeleteBookRequest(id);
    }
}
