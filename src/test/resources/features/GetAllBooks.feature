Feature: Get All Books
  Scenario: Unauthorized user tries to get all books
    Given the user is not logged in
    When the user requests the list of all books
    Then the response status code should be 401
