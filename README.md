# REST Assured API Tests

A Java API testing project using REST Assured and TestNG. The tests send GET and POST requests to the public practice API at [restful-api.dev](https://restful-api.dev/). This repository contains tests only; it does not implement the API.

## Tools

- Java 17
- Maven
- REST Assured
- TestNG

## Tests

| Test | What it checks |
|---|---|
| `getExistingObject` | GET `/objects/7` returns an object with ID `7`. |
| `createObject` | POST `/objects` creates an object and returns its submitted details. |
| `postWithoutName` | Sends a POST request without a name and logs the response for inspection. |


## Run the tests

1. Open the project in IntelliJ IDEA and select Java 17.
2. Let Maven download the dependencies.
3. Right-click `ObjectApiTest.java` and select **Run 'ObjectApiTest'**.

Alternatively, run:

```bash
mvn test
```

An internet connection is required because the tests call a public API.