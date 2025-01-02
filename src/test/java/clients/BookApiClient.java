    package clients;
    
    import models.Book;
    import net.serenitybdd.annotations.Step;
    import org.hamcrest.Matchers;
    import utils.BookApiEndpoints;
    
    import java.util.HashMap;
    import java.util.Map;
    
    import static net.serenitybdd.rest.SerenityRest.*;
    import static org.hamcrest.Matchers.equalTo;
    
    public class BookApiClient {
    
    
        private String username;
        private String password;
    
        @Step("GET all books")
        public void getAllBooks() {
            when().get(BookApiEndpoints.GET_ALL);
        }
    
        @Step("Verify status code")
        public void verifyStatusCode(int statusCode) {
            then().statusCode(equalTo(statusCode));
        }
        @Step("Authenticate")
        public void authenticate(String username, String password) {
            this.username = username;
            this.password = password;
        }
    
    
        @Step("Create a book")
        public void createBook(Book book) {
    
            given()
                    .auth().preemptive().basic(username, password)
                    .contentType("application/json")
                    .body(book)
                    .when()
                    .post(BookApiEndpoints.CREATE)
                    .then().log().all();
        }
    
        @Step("Create a book with an invalid title")
        public void createBookinvalidtitle(int title, String author) {
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("title", title);
            requestBody.put("author", author);
    
            given()
                    .auth().preemptive().basic(username, password)
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
                    .auth().preemptive().basic(username, password)
                    .contentType("application/json")
                    .body(requestBody)
                    .when()
                    .post(BookApiEndpoints.CREATE)
                    .then()
                    .log().all();
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
    }
