Feature: Create a Book

  Scenario: Attempt to create a book with empty title and author fields
    Given user authenticates using username "admin" and password "password"
    When user sends a request to create a book with title - "" and author - ""
    Then user gets status code as 400


  Scenario: Attempt to create a book for User
    Given user authenticates using username "user" and password "password"
    When user sends a request to create a book with title - "The Silent Patient" and author - "Alex Michaelides"
    Then user gets status code as 201

  Scenario: Invalid data type for title in the payload
    Given user authenticates using username "user" and password "password"
    When user sends a request to create a book with invalid title - 12345 and author - "Alex Michaelides"
    Then user gets status code as 400
#    And the response should contain an error message "Invalid data type for id, title, or author."

  Scenario: Invalid data type for author in the payload
    Given user authenticates using username "user" and password "password"
    When user sends a request to create a book with title - "Silent" and invalid author - 89756
    Then user gets status code as 400
#    And the response should contain an error message "Invalid data type for id, title, or author."



