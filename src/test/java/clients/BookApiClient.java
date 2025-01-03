package clients;

import models.Book;
import net.serenitybdd.annotations.Step;
import utils.BookApiEndpoints;

import javax.swing.plaf.PanelUI;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;

public class BookApiClient {

    @Step("GET all books")
    public void getAllBooks() {
        when().get(BookApiEndpoints.GET_ALL);
    }

    @Step("Get books by ID")
    public void getBooksByID(){when().get(BookApiEndpoints.GET_BY_ID);}

    @Step("Verify status code as {0}")
    public void verifyStatusCode(int statusCode) {
        then().statusCode(statusCode);
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
        if(book.getId()>0){
        then().
                body("id", equalTo(book.getId()))
                .body("title", equalTo(book.getTitle()))
                .body("author", equalTo(book.getAuthor()));
        }else{
            then()
                    .body("title", equalTo(book.getTitle()))
                    .body("author", equalTo(book.getAuthor()));
        }
    }
}
