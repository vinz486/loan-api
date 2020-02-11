# Loan Egine
Loan API Service

This is a Spring Boot application built using Gradle.
Run it using:
```bash
$ ./gradlew bootRun
```
##### Loan Request submission
Submit a loan request using a POST message on '/loan' endpoint:
```bash
$ curl -X POST   http://127.0.0.1:8080/loan -H 'Bigbank-Apikey: TOKEN-ABC' -H 'Content-Length: 36' -H 'Content-Type: application/json' -H 'Host: 127.0.0.1:8080' -d '{
  "market": "en",
  "amount": 8000
  }'

```

Response is an object like this:
```bash
{
    "loanId": "3bf440be-1478-477d-be23-a11c7ddfc92b",
    "requestedAmount": "1000",
    "rate": "7.0",
    "monthlyRepayment": "30.88",
    "totalRepayment": "1111.65",
    "currencySign": "£"
}
```

Bad responses comes with HTTP status codes and error object too.
