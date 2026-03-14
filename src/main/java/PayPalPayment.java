public class PayPalPayment implements PaymentMethod{

    @Override
    public void implement(double amount) throws IllegalArgumentException{
        if (amount < 200) throw new IllegalArgumentException("Amount under the limit.");
        System.out.println(amount + " was paid by PayPal.");
    }

}
