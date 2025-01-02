Feature: Get Book by ID

  Scenario: Unauthorized access when not logged in
  Given a book exists in the database with title "Test Book", and author "Test Author"
  And the user is not logged in
  When user requests book details by ID 0
  Then user gets status code as 401 - getid
