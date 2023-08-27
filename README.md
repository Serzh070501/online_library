# Online Store Library

The Online Store Library is a Java Spring Boot project that simulates an online library system with role-based access control. It uses PostgreSQL as the database for storing user data and library information.

## Features

- User registration and authentication
- Role-based access control (User, Admin, Super_Admin)
- Browse and search for library items
- Borrow and return items
- Admin management of library items
- Super Admin management of users and roles

## Prerequisites

- Java 11 or higher
- Gradle
- PostgreSQL database

## Installation

1. Clone the repository: `git clone https://github.com/yourusername/online-store-library.git`
2. Navigate to the project directory: `cd online-store-library`
3. Configure the database connection in `src/main/resources/application.properties`
4. Build and run the application: `./gradlew bootRun`

## Usage

After running the application, you can access the online library system through your browser or API testing tool.

## API Endpoints

- `/auth/register`: User registration
- `/auth/login`: User login
- `/books`: Get all library books
- `/books/{id}`: Get a specific library book
- `/books/preferences/user/{id}}`: Get preferences book
- `/orders`: Do Order and get Orders(Role = Admin)
- `/users`: Admin management of Users
- `/sales`: Super Admin get SalesReport 


## Database

The project uses a PostgreSQL database to store user information, library books, user's cards and orders.

## User Roles

- User: Can  search for books and make purchases
- Admin: Can manage books in the application and manage user data
- Super Admin: Can add new Admins, and have access to sales reports.

## Contributing

Contributions are welcome! Please follow the standard GitHub workflow: fork the repository, create a new branch, make changes, and submit a pull request.

## Acknowledgements

- Java Spring Boot
- PostgreSQL
- Spring Security
- Your favorite API testing tool
- Other libraries/tools you've used
