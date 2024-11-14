# MVCArchitecture Spring Boot Application

This project is a simple blog application built using Spring MVC, with two main entities, `Post` and `User`, where `User` is the author of `Post`. The application provides basic CRUD operations and includes validation and page rendering with Thymeleaf.

## Features

- **Post Listing**: Displays a list of blog posts.
- **Post Details**: View individual posts by `id`.
- **Create/Update Post**: Form for adding or updating a post.
- **Validation**: Ensures data integrity for required fields.
- **Custom Error Page**: Includes a custom `404` error page if post can`t be found.

## Technologies

- **Java 21**
- **Spring Boot** (MVC, Validation)
- **Thymeleaf** (for templating)

## Setup and Running

### Prerequisites

- JDK 21
- Any IDE (e.g., IntelliJ IDEA, Eclipse)

### Running the Application

1. **Clone the Repository** (if applicable):
   ```bash
   git clone https://github.com/k1fl1k/MVCSpring.git
   cd MVCSpring
   ```

2. **Run the Application**:
   - You can start the application with your IDE's run configuration.

3. **Access the Application**:
   - Go to `http://localhost:8080/posts` to view the list of posts.

## API Endpoints

Open your web browser and navigate to `http://localhost:8080/posts` to view the list of posts.

## Custom Error Handling

- **404 Error**: Displays a custom `404` page if a route or resource is not found.
