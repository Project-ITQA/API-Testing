Feature: Get All Books
  Scenario: Get All Books When Not Logged In
    Given user is not logged in
    When user asks for all books
    Then user gets unauthorized response