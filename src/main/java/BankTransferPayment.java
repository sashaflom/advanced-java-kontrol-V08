public class BankTransferPayment implements PaymentMethod{

    @Override
    public void implement(double amount) {
        double commission = amount * 0.015;
        System.out.println("Bank transfer of amount " + amount + " is with commission " + commission + ". Total paid: " + (amount + commission));
    }

}
