Feature: Update a book
  Background:
    When user posts the book details title "Asgard" and author "Loki"
    Then user gets 201 code
    Then user gets the book with title "Asgard" and author "Loki" as response

  Scenario: Update a book with valid input values
    When user updates the book with title "Asgard" and author "Loki" with new title "Asgard Kingdom" and new author "Thor"
    Then user gets 200 code
    Then user gets the updated book with title "Asgard Kingdom" and author "Thor" and id as response
