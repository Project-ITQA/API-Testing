package clients;

import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import utils.BookApiEndpoints;

import static net.serenitybdd.rest.SerenityRest.*;

public class BookApiClient {
    @Step("GET all books")
    public void getAllBooks() {
        when().get(BookApiEndpoints.GET_ALL);
    }

    @Step("Verify status code as {0}")
    public void verifyStatusCode(int statusCode) {
        then().statusCode(Matchers.equalTo(statusCode));
    }
}
