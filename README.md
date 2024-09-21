# product-management-api

# product-management-api

Features
Product Management

Create new products
Retrieve a list of all products
Get details of a single product by ID
Delete products (functionality to be added)
Category Management

Retrieve a list of all categories
Retrieve products by category name
Search Functionality

Perform paginated searches for products by title
Technologies Used
Java 17
Spring Boot 3
Spring Data JPA for data persistence
Spring Web for RESTful API implementation
H2 Database (in-memory database for testing purposes)
RestTemplate to interact with external fake store API
Maven for project management and dependency handling
API Endpoints
Product Endpoints
POST /products
Create a new product.
Request Body: CreateProductRequestDTO (contains product title, description, price, category, image).
GET /products
Retrieve all products.
GET /products/{id}
Retrieve a single product by ID.
Category Endpoints
GET /categories
Retrieve all product categories.
GET /category/{name}
Retrieve products under a specific category.
Search Endpoint
POST /search
Search for products by title.
Request Body: SearchRequestDTO (contains search query, page number, and page size).


Project Structure
Controllers/ - Contains the REST controllers to handle incoming API requests.
Services/ - Contains service classes responsible for business logic.
Repositories/ - Contains the repository interfaces for data persistence.
DTOs/ - Data Transfer Objects used to interact with external APIs and request/response mapping.
