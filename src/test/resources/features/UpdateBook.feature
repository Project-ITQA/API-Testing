Feature: Update a book
  Background:
    When user posts the book details title "Asgard" and author "Loki"
    Then user gets 201 code
    Then user gets the book with title "Asgard" and author "Loki" as response

  Scenario: Update a book with an invalid ID
    When user updates a book with an invalid ID "invalid-book-id" and title "Asgard" and author "Loki"
    Then user gets 400 code
