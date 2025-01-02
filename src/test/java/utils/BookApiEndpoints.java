package utils;

public interface BookApiEndpoints {
    String BASE_URL = "http://localhost:7081/api";

    String GET_ALL = BASE_URL + "/books/";
    String GET_BY_ID = BASE_URL + "/books/{id}";
    String CREATE = BASE_URL + "/books";
    String UPDATE = BASE_URL + "/";
    String DELETE = BASE_URL + "/books/{id}";
}
