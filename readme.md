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