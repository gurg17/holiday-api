# Holiday API

Welcome to the Holiday API project! This is a Spring Boot application that provides an API for managing holidays.

## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Building and Running](#building-and-running)
- [Running Tests](#running-tests)
- [API Endpoints](#api-endpoints)
- [License](#license)

## Getting Started

Follow these instructions to set up and run the project on your local machine for development and testing purposes.

### Prerequisites

Make sure you have the following installed:

- Java 17
- Maven

### Building and Running

1. Clone the repository:
    ```sh
    git clone <repository-url>
    cd holiday-api
    ```

2. Build the project using Maven:
    ```sh
    ./mvnw clean install
    ```

3. Run the application:
    ```sh
    ./mvnw spring-boot:run
    ```

The application will start and be accessible at `http://localhost:8080`.

### Running Tests

To run the tests, use the following command:
```sh
./mvnw test
```

## API Endpoints

Here are some example API endpoints provided by the `HolidayController`:

- **Get Last Three Holidays**
    ```http
    GET /{countryCode}/last-three
    ```

    ```curl
    curl -X GET "http://localhost:8080/US/last-three"
    ```

    Response:
    ```json
    [
        {"date": "2023-12-25", "name": "Christmas Day"},
        {"date": "2023-11-23", "name": "Thanksgiving Day"},
        {"date": "2023-07-04", "name": "Independence Day"}
    ]
    ```

- **Get Public Holidays Count**
    ```http
    GET /{year}/public-holidays-count
    ```

    ```curl
    curl -X GET "http://localhost:8080/2023/public-holidays-count?countryCodes=US,CA"
    ```

    Response:
    ```json
    {
        "US": 10,
        "CA": 9
    }
    ```

- **Get Common Holidays**
    ```http
    GET /{year}/common-holiday
    ```
    ```curl
    curl -X GET "http://localhost:8080/2023/common-holidays?countryCode1=US&countryCode2=CA"
    ```
    Response:
    ```json
    [
        {"date": "2023-12-25", "name": "Christmas Day"},
        {"date": "2023-07-01", "name": "Canada Day"}
    ]
    ```