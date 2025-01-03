#Feature: Get All Books
#
#  Scenario: Unauthorized user tries to get all books
#    Given the user is not logged in
#    When the user requests the list of all books
#    Then the response status code should be 401
#
#
#  Scenario Outline: Users retrieves an empty response when no books in database
#    Given the user is logged in with username: "<Username>" and password: "<Password>"
#    When the user requests the list of all books
#    Then the response status code should be 200
#    And the response should be empty
#
#    Examples:
#      | Username | Password |
#      | admin    | password |
#      | user     | password |
#
#
#  Scenario Outline: Users retrieves a list of books when at least one book is in database
#    Given the user is logged in with username: "<Username>" and password: "<Password>"
#    And user posts the book details title "<Title>" and author "<Author>"
#    When the user requests the list of all books
#    Then the response status code should be 200
#    And the response should be a list of books containing a book with title: "<Title>" and author: "<Author>"
#
#    Examples:
#      | Username | Password | Title    | Author  |
#      | admin    | password | serenity | john    |
#      | user     | password | cucumber | jane    |