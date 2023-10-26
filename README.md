# Spring Boot Library Management System

## Project Description

This Spring Boot project is a Library Management System that provides a web-based platform for managing books, librarians, and patrons. The project uses a stack that includes Hibernate for database interaction, PostgreSQL as the relational database, and Spring Boot for creating the web application.

### Entities

#### `Book`

- Represents a book in the library.
- Attributes:
  - `id`: Unique identifier for the book.
  - `title`: Title of the book.
  - `author`: Author of the book.
  - `isbn`: ISBN (International Standard Book Number) of the book.
  - `genre`: Genre of the book.
  - `availability`: Indicates whether the book is available for borrowing.

#### `Librarian`

- Represents a librarian who manages the library.
- Attributes:
  - `id`: Unique identifier for the librarian.
  - `username`: Unique username for login.
  - `password`: Password for login.
  - `firstName`: First name of the librarian.
  - `lastName`: Last name of the librarian.
  - `contactInfo`: Contact information of the librarian.
  - `roles`: Roles assigned to the librarian.

#### `Patron`

- Represents a library patron who borrows books.
- Attributes:
  - `id`: Unique identifier for the patron.
  - `username`: Unique username for login.
  - `password`: Password for login.
  - `firstName`: First name of the patron.
  - `lastName`: Last name of the patron.
  - `contactInfo`: Contact information of the patron.
  - `membershipStatus`: Indicates the membership status of the patron.
  - `roles`: Roles assigned to the patron.

#### `Transaction`

- Represents a book transaction, including borrowing and returning.
- Attributes:
  - `id`: Unique identifier for the transaction.
  - `book`: Book associated with the transaction.
  - `patron`: Patron associated with the transaction.
  - `borrowDate`: Date when the book was borrowed.
  - `dueDate`: Due date for returning the book.
  - `returnDate`: Date when the book was returned.
  - `overdue`: Indicates whether the book was returned late.

### Controllers

The project includes several controllers for handling HTTP requests related to the entities:

#### `BookController`

- Manages book-related operations such as creating, deleting, updating, and searching for books.
- Provides endpoints for various book search criteria.

#### `LibrarianController`

- Manages librarian-related operations, including creation, retrieval, updating, and deletion.
- Provides login and search functionality for librarians.

#### `PatronController`

- Manages patron-related operations, including creation, retrieval, updating, and deletion.
- Provides various search criteria for patrons.

#### `TransactionController`

- Manages book transaction-related operations, including creating, deleting, updating, and searching for transactions.
- Includes functionality to find transactions by book, patron, and to find overdue transactions.

### Deployment

The project is deployed on Railway, and the web application can be accessed at the following link: [Spring Boot Library Management System](https://springbootlibrarymanagement-production.up.railway.app/)

This Library Management System allows librarians to manage books and patrons efficiently and patrons to browse and borrow books from the library. It provides a user-friendly interface for a smooth library experience.
