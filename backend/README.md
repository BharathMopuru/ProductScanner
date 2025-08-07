# Product Scanner API

This is a Spring Boot application that provides an API for scanning products and retrieving information about them.

## API Endpoints

### Scan a Product

* **URL:** `/api/scan`
* **Method:** `POST`
* **Request Body:**

```json
{
  "barcode": "<product_barcode>"
}
```

* **Response:**

```json
{
  "productName": "<product_name>",
  "ingredients": [
    {
      "name": "<ingredient_name>",
      "isSafe": true
    }
  ]
}
```

## How to Build and Run

1. **Clone the repository:**

```bash
git clone https://github.com/BharathMopuru/ProductScanner.git
```

2. **Navigate to the project directory:**

```bash
cd backend
```

3. **Build the project using Maven:**

```bash
mvn clean install
```

4. **Run the application:**

```bash
java -jar target/bobby-backend-0.0.1-SNAPSHOT.jar
```
