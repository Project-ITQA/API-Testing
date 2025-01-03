Feature: Update a book

  Scenario Outline: Update a book with valid input values
    Given user posts the book details title "<originalTitle>" and author "<originalAuthor>"
    Given user gets 201 code
    Given user gets the book with title "<originalTitle>" and author "<originalAuthor>" as response
    When user updates the book with title "<originalTitle>" and author "<originalAuthor>" with new title "<newTitle>" and new author "<newAuthor>"
    Then user gets 200 code
    Then user gets the updated book with title "<newTitle>" and author "<newAuthor>" and id as response

    Examples:
      | originalTitle          | originalAuthor       | newTitle             | newAuthor      |
      | Exercise and the Heart | Victor F. Froelicher | Heart: A History     | Sandeep Jauhar |
      | The Silent Patient     | Alex Michaelides     | The Silent Voice     | John Smith     |
      | To Kill a Mockingbird  | Harper Lee           | Mockingbird: Reborn  | Lee Harper     |

  Scenario Outline: Update a book with empty input values
    Given user posts the book details title "<originalTitle>" and author "<originalAuthor>"
    Given user gets 201 code
    Given user gets the book with title "<originalTitle>" and author "<originalAuthor>" as response
    When user updates the book with title "<originalTitle>" and author "<originalAuthor>" with new title "<newTitle>" and new author "<newAuthor>"
    Then user gets 400 code

    Examples:
      | originalTitle          | originalAuthor   | newTitle    | newAuthor |
      | The Silent Patient-12  | Alex Michaelides | [blank]     | [blank]   |
      | Brave New World        | Aldous Huxley    | [blank]     | Aldous    |
      | The Catcher in the Rye | J.D. Salinger    | The Catcher | [blank]   |

  Scenario: Update a book with missing author in request body
    Given user posts the book details title "War and Peace" and author "Leo Tolstoy"
    Given user gets 201 code
    Given user gets the book with title "War and Peace" and author "Leo Tolstoy" as response
    When user updates the book with only the id and title "Moby - Dick" in the request body
    Then user gets 400 code

  Scenario: Update a book with missing title in request body
    Given user posts the book details title "Pride and Prejudice" and author "Leo Tolstoy"
    Given user gets 201 code
    Given user gets the book with title "Pride and Prejudice" and author "Leo Tolstoy" as response
    When user updates the book with only the id and author "Herman Melville" in the request body
    Then user gets 400 code

  Scenario Outline: Update a book by changing only the author
    Given user posts the book details title "<originalTitle>" and author "<originalAuthor>"
    Given user gets 201 code
    When user updates the book with title "<originalTitle>" and author "<originalAuthor>" with new title "<originalTitle>" and new author "<newAuthor>"
    Then user gets 200 code
    Then user gets the updated book with title "<originalTitle>" and author "<newAuthor>" and id as response

    Examples:
      | originalTitle        | originalAuthor | newAuthor              |
      | The Alchemist        | Paulo Coelho   | Gabriel García Márquez |
      | The Midnight Library | Matt Haig      | Haruki Murakami        |

  Scenario Outline: Update a book by changing only the title
    Given user posts the book details title "<originalTitle>" and author "<originalAuthor>"
    Given user gets 201 code
    When user updates the book with title "<originalTitle>" and author "<originalAuthor>" with new title "<newTitle>" and new author "<originalAuthor>"
    Then user gets 200 code
    Then user gets the updated book with title "<newTitle>" and author "<originalAuthor>" and id as response

    Examples:
      | originalTitle    | originalAuthor  | newTitle          |
      | Invisible Cities | Italo Calvino   | Jorge Luis Borges |
      | A Man Called Ove | Fredrik Backman | A Women Called Eve|
