Feature: Create book

  Scenario: Create book correctly
    When user posts the book details title "the gambler" and author "Fyodar"
    Then user gets 201 code
    Then user gets the book with title "the gambler" and author "Fyodar" as response

  Scenario: Create book correctly with given Id
    When user posts the book details title "the gambler 2" and author "Fyodar 2" and Id 14
    Then user gets 201 code
    Then user gets the book with title "the gambler 2" and author "Fyodar 2" and id 14 as response

  Scenario: Create a book with missing values author
    When user posts the book details title "the gambler 3"
    Then user gets 400 code

  Scenario: Create a book with missing values title
    When user posts the book details author "Fyodar Dhosteyoski"
    Then user gets 400 code

  Scenario: Create a duplicate book
    When user posts the book details title "the gambler 4" and author "Fyodar 4"
    Then user gets 201 code
    When user posts the book details title "the gambler 4" and author "Fyodar 4"
    Then user gets 208 code