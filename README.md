# Banking Application using Spring Boot

RESTful API to simulate simple banking operations. 

## Requirements

•	CRUD operations for customers and accounts.
•	Support deposits and withdrawals on accounts.
•	Internal transfer support (i.e. a customer may transfer funds from one account to another).


## Getting Started

1. Checkout the project from GitHub

```
git clone https://github.com/sbathina/BankApp

```

2. Open IDE of your choice and Import as existing maven project in your workspace

```
- Import existing maven project
- Run mvn clean install
- If using STS, Run As Spring Boot App

```
3. Default port for the api is 8989


### Prerequisites

Java 8
Spring Tool Suite 4 or similar IDE
[Maven](https://maven.apache.org/) - Dependency Management

### Maven Dependencies

```
spring-boot-starter-actuator
spring-boot-starter-data-jpa
spring-boot-starter-security
spring-boot-starter-web
spring-boot-devtools
h2 - Inmemory database
lombok - to reduce boilerplate code
springfox-swagger2
springfox-swagger-ui
spring-boot-starter-test
spring-security-test

```

## Swagger

Please find the Rest API documentation in the below url

```
http://localhost:8989/bank-api/swagger-ui.html

```

## H2 Database Console

Make sure to use jdbc:h2:mem:testdb as your jdbc url. If you intend to you use your own database,
define datasource properties in application.yml

```
http://localhost:8989/bank-api/h2-console/

```

## Testing the Bank APP Rest Api

1. Please use the Swagger url to perform CRUD operations. 

2. Browse to <project-root>/src/test/resources to find sample requests to add customer and accounts.


## Authors

* **Shyam Bathina**

