Feature: Update a book

  Scenario: Update a book with an invalid ID
    When user posts the book details title "Asgard" and author "Loki"
    Then user gets 201 code
    Then user gets the book with title "Asgard" and author "Loki" as response
    When user updates a book with an invalid ID "invalid-book-id" and title "Asgard" and author "Loki"
    Then user gets 400 code

  Scenario:Update a book with Non-Existent Book ID
    When user posts the book details title "Madolduwa" and author "Martin wikramasinha"
    Then user gets 201 code
    Then user gets the book with title "Madolduwa" and author "Martin wikramasinha" as response
    When user updates a book with a non-existent ID "9999", title "Minushika", and author "H.R Kapuwaththa"
    Then the response status code should be 404


