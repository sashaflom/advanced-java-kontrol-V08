public class CardPayment implements PaymentMethod{

    @Override
    public void implement(double amount) throws IllegalArgumentException{
        if (amount > 25000) throw new IllegalArgumentException("Amount above the limit.");
        System.out.println(amount + " was paid by Card.");
    }

}
