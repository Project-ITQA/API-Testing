Feature: Get Books By ID

  Scenario: Successful Retrieval of a Book for Admin Login
    When user posts the book details title "Safe Harbour" and author "Danielle"
    Then user gets 201 code
    Then user gets the book with title "Safe Harbour" and author "Danielle" as response
    When user calls the service to get the book with valid ID 1
    Then user gets 200 code
    Then user gets the book with title "Safe Harbour" and author "Danielle" and ID 1 as response

  Scenario: Successful Retrieval of a Book for regular user Login
    When user posts the book details title "Safe Harbour" and author "Danielle"
    Then user gets 201 code
    Then user gets the book with title "Safe Harbour" and author "Danielle" as response
    When user calls the service to get the book with valid ID 1
    Then user gets 200 code
    Then user gets the book with title "Safe Harbour" and author "Danielle" and ID 1 as response
#
  Scenario: Get a non-existence book by ID as the admin
    When user calls the service to get the book with ID 9999
    Then user gets 404 code
#
  Scenario: Get a non-existence book by ID as the regular user
    When user calls the service to get the book with ID 9999
    Then user gets 404 code

  Scenario: Get a book with invalid ID format as the admin
    When user calls the service to get the book with invalid ID "abc"
    Then user gets 400 code

  Scenario: Get a book with invalid ID format as the regular user
    When user calls the service to get the book with invalid ID "abc"
    Then user gets 400 code




