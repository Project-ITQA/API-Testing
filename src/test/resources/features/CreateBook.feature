Feature: Create book

  Scenario: Create book correctly
    When user posts the book details title "the gambler" and author "Fyodar"
    Then user gets 201 code
    Then user gets the book with title "the gambler" and author "Fyodar" as response

  Scenario: Create book correctly with given Id
    When user posts the book details title "the gambler 2" and author "Fyodar 2" and Id 4
    Then user gets 201 code
    Then user gets the book with title "the gambler 2" and author "Fyodar 2" and id 4 as response

  Scenario: Create a book with missing values
    When user posts the book details title "the gambler 3"
    Then user gets 400 code

  Scenario: Create a book with empty values
    When user posts the book details title "" and author ""
    Then user gets 400 code

  Scenario: Create a book with duplicate Id
    When user posts the book details title "the gambler 4" and author "Fyodar 4" and Id 5
    Then user gets 201 code
    When user posts the book details title "ape gama" and author "martin wickramasinge" and Id 5
    Then user gets 409 code