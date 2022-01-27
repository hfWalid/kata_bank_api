# kata_bank_api
Kata bank account api gives possibility to make deposit/withdrawal statements, and also list all history statements already done


### Prerequisites
 * Gradle-7.3.3
 *  Java 8
 * PostgreSQL

### Installation

Gradle is the dependency management tool used for this application to compile and package.
in order to run the application:
    Goto the root of the app where is build.gradle
    Run and execute the below command:
```text
gradle bootRun
```

This Api provides three endpoints:

- [x] Make deposit to bank account:
  - [ ] Method: POST
  - [ ] URL: http://localhost:9090/statement/deposit
  - [ ] Body: 
```json
    {
      "accountNumber": "1234567890",
      "statementAmount": "500.00"
    }
```
- [x] Make withdrawal to bank account:
    - [ ] Method: POST
    - [ ] URL: http://localhost:9090/statement/withdrawal
    - [ ] Body:
```json
    {
      "accountNumber": "1234567890",
      "statementAmount": "500.00"
    }
```
- [x] list all history statements for specific account:
    - [ ] Method: GET
    - [ ] URL: http://localhost:9090/statement/?accountNumber=1234567890
    - [ ] Option : page and size are byy default 0 and 25 but can change them on url