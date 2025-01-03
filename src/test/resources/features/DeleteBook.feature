Feature: Delete Book

  Scenario Outline: Valid Book Deletion for admin user
    Given the user is logged in with username: "<Username>" and password: "<Password>" for CREATE
    When user posts the book details title "<Title>" and author "<Author>"
    Then user gets 201 code
    Then user gets the book with title "<Title>" and author "<Author>" as response
    When user deletes the previously added book as admin
    Then the response status code should be 200


    Examples:
      | Username | Password | Title | Author |
      | admin    | password | Dark arena 22 | Mario Puzo 22 |

  Scenario Outline: Non-Existent Book ID Deletion
    Given the user is logged in with username: "<Username>" and password: "<Password>" for CREATE
    When user deletes the book with Id <Id>
    Then the response status code should be 404

    Examples:
      | Username | Password | Id |
      | admin    | password | 666 |

  Scenario Outline: deleting a book with normal user
    Given the user is logged in with username: "admin" and password: "password" for CREATE
    When user posts the book details title "<Title>" and author "<Author>"
    Then user gets 201 code
    When user deletes the previously added book as user
    Then the response status code should be 403

    Examples:
      | Title | Author |
      | Angels and Demons 66 | Dan Brown 66 |