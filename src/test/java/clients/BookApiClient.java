package clients;

import models.Book;
import net.serenitybdd.annotations.Step;
import utils.BookApiEndpoints;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class BookApiClient {
    @Step("get all books")
    public void getAllBooks() {
        given().get(BookApiEndpoints.GET_ALL);
    }

    @Step("verify unauthorized")
    public void verifyUnauthorized() {
        lastResponse().then().statusCode(401);
    }
}
