public class OrderProcessor extends OrderProcessorTemplate{
    private PaymentMethod paymentMethod;

    public OrderProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    protected boolean fraudCheck(Order order) {
        return order.getId()>0;
    }

    @Override
    protected void pay(Order order) {
        paymentMethod.implement(order.getTotalPrice());
    }

}
