package stripe;

import org.junit.jupiter.api.Test;
import stripe.model.InvoiceModel;

import static org.junit.jupiter.api.Assertions.*;

class StripePaymentServiceTest {

    private static final String API_KEY = "sk_test_7mJuPfZsBzc3JkrANrFrcDqC";

    private static final String TEST_EMAIL = "test@mail.com";
    private static final int TEST_PRICE = 1;
    private static final String TEST_PRODUCT = "testProduct";

    final StripePaymentService service = new StripePaymentService(API_KEY);

    @Test
    void createInvoice() {
        final String result = createTestInvoice();

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void retrieveInvoice() {
        final String testInvoice = createTestInvoice();

        final InvoiceModel result = service.retrieveInvoice(testInvoice);

        assertNotNull(result);
        assertEquals(100, result.getPrice());
        assertNotNull(result.getCustomer());
        assertFalse(result.getCustomer().isEmpty());
        assertEquals(testInvoice, result.getId());
    }

    private String createTestInvoice() {
        return service.createInvoice(TEST_EMAIL, TEST_PRODUCT, TEST_PRICE);
    }

}