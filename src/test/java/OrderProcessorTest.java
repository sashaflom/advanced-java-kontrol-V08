import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderProcessorTest {

    private PaymentMethod card = new CardPayment();
    private PaymentMethod payPal = new PayPalPayment();
    private PaymentMethod bank = new BankTransferPayment();
    private final OrderProcessor processorCard = new OrderProcessor(card);

    @Test
    void testFraudCheckException() {
        Order badOrder = new Order(-10, new OrderItem[1], 100);
        AppException exception = assertThrows(AppException.class, () -> processorCard.process(badOrder));
        assertTrue(exception.getCause() instanceof FraudCheckFailedException);
    }

    @Test
    void testCardLimit() {
        Order heavyOrder = new Order(1, new OrderItem[1], 50000);
        assertThrows(AppException.class, () -> processorCard.process(heavyOrder));
    }

    @Test
    void testDiscountApplied() throws AppException {
        Order order = new Order(1, new OrderItem[1], 25000);
        processorCard.process(order);
        assertEquals(22500, order.getTotalPrice());
    }

}
