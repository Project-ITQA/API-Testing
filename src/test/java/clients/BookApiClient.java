package clients;

import models.Book;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import utils.BookApiEndpoints;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;

public class BookApiClient {

    @Step("GET all books")
    public void getAllBooks() {
        when().get(BookApiEndpoints.GET_ALL);
    }

    @Step("Verify status code as {0}")
    public void verifyStatusCode(int statusCode) {
        then().statusCode(statusCode);
    }

    @Step("authenticate with username: {0} and password: {1}")
    public void authenticate(String username, String password) {
        given().auth().preemptive().basic(username, password);
    }

    @Step("post the book")
    public void createBook(Book book) {
        given()
                .auth()
                .preemptive()
                .basic("admin", "password")
                .contentType("application/json")
                .body(book.toJSONString())
                .when()
                .post(BookApiEndpoints.CREATE);
    }

    @Step("response contains the book")
    public void checkResponseBook(Book book) {
        if (book.getId() > 0) {
            then().
                    body("id", equalTo(book.getId()))
                    .body("title", equalTo(book.getTitle()))
                    .body("author", equalTo(book.getAuthor()));
        } else {
            then()
                    .body("title", equalTo(book.getTitle()))
                    .body("author", equalTo(book.getAuthor()));
        }
    }

    @Step("check if the response returned a list including the book: {0}")
    public void checkResponseContainsBookInList(Book book) {
        then().body(Matchers.arrayContaining(Matchers.theInstance(book)));
    }

    @Step("check if the response returned an empty list")
    public void checkResponseReturnedEmptyList() {
        then().body("", Matchers.empty());
    }
}
