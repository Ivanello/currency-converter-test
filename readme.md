# Currency Converter Test #

## Setup:

* install Java
* install Maven

## Run tests:

```
git clone git@github.com:Ivanello/currency-converter-test.git
cd currency-converter-test
mvn clean test -Dselenide.baseUrl=https://goo.gl/UszK6B
mvn allure:serve
```

or

`mvn test allure:serve -Dselenide.baseUrl=https://goo.gl/UszK6B`



# Checklist:

1. Check ability and correctness to choose currency from Main list to FROM field
2. Check ability and correctness to choose currency from Popular list to FROM field
3. Check ability and correctness to choose currency from Main list to TO field
4. Check ability and correctness to choose currency from Popular list to FROM field
5. Check ability to set value to FROM field
6. Check that TO field !==0 if FROM field !==0
7. Check Clear button set FROM and TO input fields to 0