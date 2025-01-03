package clients;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Book;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import org.hamcrest.Matchers;
import utils.BookApiEndpoints;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

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
        given().auth().preemptive().basic(username, password).contentType(ContentType.JSON).accept(ContentType.JSON);
    }

    @Step("not authenticated")
    public void noAuthenticate() {
        given().contentType(ContentType.JSON).accept(ContentType.JSON);
    }

    @Step("post the book")
    public void createBook(Book book) {
        Response response = given().auth().preemptive().basic("admin", "password").contentType("application/json").body(book.toJSONString()).when().post(BookApiEndpoints.CREATE).then().extract().response();

        // Store the response in Serenity's session
        Serenity.setSessionVariable("response").to(response);
    }

    @Step("response contains the book")
    public void checkResponseBook(Book book) {
        if (book.getId() > 0) {
            then().body("id", equalTo(book.getId())).body("title", equalTo(book.getTitle())).body("author", equalTo(book.getAuthor()));
        } else {
            then().body("title", equalTo(book.getTitle())).body("author", equalTo(book.getAuthor()));
        }
    }

    @Step("check if the response returned a list including the book with title: {0} and author: {1}")
    public void checkResponseContainsBookInList(String title, String author) {
        then().body("title", hasItem(title)).body("author", hasItem(author));
    }

    @Step("check if the response returned an empty list")
    public void checkResponseReturnedEmptyList() {
        then().body("", Matchers.empty());
    }

    @Step("Verify error message")
    public void verifyErrorMessage(String expectedMessage) {
        lastResponse().then().assertThat().body("error", equalTo(expectedMessage));
    }

    @Step
    public void getBookByIdWithoutAuth(int id) {
        given().pathParam("id", id)
                .when().get(BookApiEndpoints.GET_BY_ID).then().log().all();
    }

    @Step("Create a book with an invalid title")
    public void createBookinvalidtitle(int title, String author) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("title", title);
        requestBody.put("author", author);

        given()
//                .auth().preemptive().basic(username, password)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(BookApiEndpoints.CREATE)
                .then()
                .log().all();
    }

    @Step("Create a book with an invalid author")
    public void createBookinvalidauthor(String title, int author) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("title", title);
        requestBody.put("author", author);

        given()
//                .auth().preemptive().basic(username, password)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(BookApiEndpoints.CREATE)
                .then()
                .log().all();
    }

    @Step("get stored response from session")
    public Response getStoredResponse() {
        return Serenity.sessionVariableCalled("response");
    }

    @Step("update the book")
    public void updateBook(Book updatedBook) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", updatedBook.getId() );
        requestBody.put("title", Objects.equals(updatedBook.getTitle(), "[blank]") ? "" : updatedBook.getTitle());
        requestBody.put("author", Objects.equals(updatedBook.getAuthor(), "[blank]") ? "" : updatedBook.getAuthor());
        // Update the book
        given()
                .auth()
                .preemptive()
                .basic("admin", "password")
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put(BookApiEndpoints.UPDATE, updatedBook.getId())
                .then()
                .extract()
                .response();
    }

    @Step("update book with only id and title in req body")
    public void updateBookWithOnlyTitle(Book updatedBook) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("title", updatedBook.getTitle());
        requestBody.put("id", updatedBook.getId());
        // Update the book
        given()
                .auth()
                .preemptive()
                .basic("admin", "password")
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put(BookApiEndpoints.UPDATE, updatedBook.getId())
                .then()
                .extract()
                .response();
    }

    @Step("update book with only id and author in req body")
    public void updateBookWithOnlyAuthor(Book updatedBook) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("author", updatedBook.getAuthor());
        requestBody.put("id", updatedBook.getId());
        // Update the book
        given()
                .auth()
                .preemptive()
                .basic("admin", "password")
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put(BookApiEndpoints.UPDATE, updatedBook.getId())
                .then()
                .extract()
                .response();
    }

}
