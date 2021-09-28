<!--
*** Igor Andrzejewski Readme.md
-->
# Task: Invoice client library in the Stripe payment system

"Zaimplementować bibliotekę kliencką obsługi faktur w systemie płatności Stripe (https://stripe.com/docs/api/invoices). W ramach zadania należy obsłużyć tworzenie i pobieranie faktur."

## Technology stack

* Maven
* Java 11
* stripe-java official library
* JUnit Jupiter

## Information

* Invoice creation and retrieving are implemented.
* For testing, a test key from the official stripe documentation is used.
* The console commands in this document are relevant to the Windows command line.

## How to use
There is an example of using this library in JAVA:
```
    private static final String API_KEY = "sk_test_7mJuPfZsBzc3JkrANrFrcDqC";
    private static final String TEST_EMAIL = "test@mail.com";
    private static final int TEST_PRICE = 1;
    private static final String TEST_PRODUCT = "testProduct";
    
    final StripePaymentService service = new StripePaymentService(API_KEY);
    final String testInvoice = service.createInvoice(TEST_EMAIL, TEST_PRODUCT, TEST_PRICE);
    final InvoiceModel result = service.retrieveInvoice(testInvoice);
```
## Test
The project implements tests:
* Invoice creation
* Invoice retrieving

To run the tests on your local machine please run the following command
```shell
mvn test
```