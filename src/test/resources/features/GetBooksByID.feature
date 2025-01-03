Feature: Get Books By ID

  Scenario Outline: Successful Retrieval of a Book for logged in user
    Given the user is logged in with username: "admin" and password: "password"
    And user posts the book details title "<Title>" and author "<Author>"
    Then user gets status code as 201
    Given the user is logged in with username: "<Username>" and password: "<Password>"
    When user calls the service to get the book with ID <ID>
    Then user gets status code as 200
    Then user gets the book with title "<Title>" and author "<Author>" and ID <ID> as response
    Examples:
      | Username | Password | Title    | Author  | ID   |
      | admin    | password | serenity | john    |  1   |
      | user     | password | cucumber | jane    |  2   |


#  Scenario: Get a non-existence book by ID as the admin
#    When user calls the service to get the book with ID 9999
#    Then user gets 404 code
#
#  Scenario: Get a non-existence book by ID as the regular user
#    When user calls the service to get the book with ID 9999
#    Then user gets 404 code
#
#  Scenario: Get a book with invalid ID format as the admin
#    When user calls the service to get the book with invalid ID "abc"
#    Then user gets 400 code
#
#  Scenario: Get a book with invalid ID format as the regular user
#    When user calls the service to get the book with invalid ID "abc"
#    Then user gets 400 code
#
#  Scenario: Unauthorized access when not logged in
#    Given a book exists in the database with title "Test Book", and author "Test Author"
#    And the user is not logged in
#    When user requests book details by ID 0
#    Then user gets status code as 401 - getid