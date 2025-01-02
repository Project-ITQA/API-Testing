Feature: Get All Books
#  Scenario: Unauthorized user tries to get all books
#    Given the user is not logged in
#    When the user requests the list of all books
#    Then the response status code should be 401

#  Scenario: Admin user retrieves the list of all books
##    Given user posts the book details title "the gambler" and author "Fyodar"
##    And
#    Given the user is logged in with username: "admin" and password: "password"
#    When the user requests the list of all books
#    Then the response status code should be 200
#    And the response should contain a list of books

  Scenario Outline: Users retrieves an empty array when no books in database
    Given the user is logged in with username: "<Username>" and password: "<Password>"
    When the user requests the list of all books
    Then the response status code should be 200
    And the response should contain an empty array

    Examples:
      | Username | Password |
      | admin    | password |
      | user     | password |
