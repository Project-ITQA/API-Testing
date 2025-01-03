Feature: Create a Book

  Scenario: Attempt to create a book with empty title and author fields
    Given the user is logged in with username: "admin" and password: "password"
    When user sends a request to create a book with title - "" and author - ""
    Then the response status code should be 400

  Scenario: Attempt to create a book for User
    Given the user is logged in with username: "user" and password: "password"
    When user sends a request to create a book with title - "The Silent Patient" and author - "Alex Michaelides"
    Then the response status code should be 201
    Then user gets the book with title "The Silent Patient" and author "Alex Michaelides" as response


  Scenario: Invalid data type for title in the payload
    Given the user is logged in with username: "user" and password: "password"
    When user sends a request to create a book with invalid title - 12345 and author - "Alex Michaelides"
    Then the response status code should be 400

  Scenario: Invalid data type for author in the payload
    Given the user is logged in with username: "user" and password: "password"
    When user sends a request to create a book with title - "Silent" and invalid author - 89756
    Then the response status code should be 400

  Scenario: Create book correctly
    Given the user is logged in with username: "user" and password: "password"
    When user posts the book details title "the gambler" and author "Fyodar"
    Then user gets 201 code
    Then user gets the book with title "the gambler" and author "Fyodar" as response

  Scenario: Create book correctly with given Id
    Given the user is logged in with username: "user" and password: "password"
    When user posts the book details title "the gambler 2" and author "Fyodar 2" and Id 14
    Then user gets 201 code
    Then user gets the book with title "the gambler 2" and author "Fyodar 2" and id 14 as response

  Scenario: Create a book with missing values author
    Given the user is logged in with username: "user" and password: "password"
    When user posts the book details title "the gambler 3"
    Then user gets 400 code

  Scenario: Create a book with missing values title
    Given the user is logged in with username: "user" and password: "password"
    When user posts the book details author "Fyodar Dhosteyoski"
    Then user gets 400 code

  Scenario: Create a duplicate book
    Given the user is logged in with username: "user" and password: "password"
    When user posts the book details title "the gambler 4" and author "Fyodar 4"
    Then user gets 201 code
    When user posts the book details title "the gambler 4" and author "Fyodar 4"
    Then user gets 208 code