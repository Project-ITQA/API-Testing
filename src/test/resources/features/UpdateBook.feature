Feature: Update a book

  Scenario Outline: Update a book with valid input values
    When user posts the book details title "<originalTitle>" and author "<originalAuthor>"
    Then user gets 201 code
    Then user gets the book with title "<originalTitle>" and author "<originalAuthor>" as response
    When user updates the book with title "<originalTitle>" and author "<originalAuthor>" with new title "<newTitle>" and new author "<newAuthor>"
    Then user gets 200 code
    Then user gets the updated book with title "<newTitle>" and author "<newAuthor>" and id as response

    Examples:
      | originalTitle          | originalAuthor       | newTitle             | newAuthor      |
      | Exercise and the Heart | Victor F. Froelicher | Heart: A History     | Sandeep Jauhar |
      | The Silent Patient     | Alex Michaelides     | The Silent Voice     | John Smith     |
      | To Kill a Mockingbird  | Harper Lee           | Mockingbird: Reborn  | Lee Harper     |
      | 1984                   | George Orwell        | Nineteen Eighty-Four | George Orwell  |

  Scenario Outline: Update a book with empty input values
    When user posts the book details title "<originalTitle>" and author "<originalAuthor>"
    Then user gets 201 code
    Then user gets the book with title "<originalTitle>" and author "<originalAuthor>" as response
    When user updates the book with title "<originalTitle>" and author "<originalAuthor>" with new title "<newTitle>" and new author "<newAuthor>"
    Then user gets 400 code

    Examples:
      | originalTitle          | originalAuthor   | newTitle    | newAuthor |
      | The Silent Patient-12  | Alex Michaelides | [blank]     | [blank]   |
      | Brave New World        | Aldous Huxley    | [blank]     | Aldous    |
      | The Catcher in the Rye | J.D. Salinger    | The Catcher | [blank]   |




