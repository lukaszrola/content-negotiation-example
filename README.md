# Content Negotiation Example

Purpose of this project is to demonstrate how to use content negotiation in Spring Boot.
To do so, we will create a simple REST API that returns a list of currency exchange rates in various representations.

## Pre-requisites
- To run application you need to have Java 17 installed.
- If you want to perform example requests, you need to have `curl` installed.

## Running the application with Gradle

```shell
./gradlew bootRun
```

## Example requests

### Mime type negotiation

You can select preferred mime type by setting `Accept` header. Support for following mime types is implemented:
- `application/json`
- `application/xml`
- `text/html`

#### application/json

```shell
curl -i -H "Accept: application/json" curl --location 'http://localhost:8080/exchange-rates'
```

#### application/xml

```shell
curl -i -H "Accept: application/xml" curl --location 'http://localhost:8080/exchange-rates'
```


#### text/html

```shell
curl -i -H "Accept: text/html" curl --location 'http://localhost:8080/exchange-rates'
```

### Language negotiation
For representation `application/html` you can select preferred language by setting `Accept-Language` header. Support for following languages is implemented:
- `en` (default
- `pl`
- `de`

#### en

```shell
curl -i -H "Accept: text/html" -H "Accept-Language: en" curl --location 'http://localhost:8080/exchange-rates'
```

#### pl

```shell
curl -i -H "Accept: text/html" -H "Accept-Language: pl" curl --location 'http://localhost:8080/exchange-rates'
```

#### de

```shell
curl -i -H "Accept: text/html" -H "Accept-Language: de" curl --location 'http://localhost:8080/exchange-rates'
```

### Encoding negotiation
You can select `gzip` encoding by setting `Accept-Encoding` header:

```shell
curl -sI -H "Accept-Encoding: gzip" curl --location 'http://localhost:8080/exchange-rates'
```
    

