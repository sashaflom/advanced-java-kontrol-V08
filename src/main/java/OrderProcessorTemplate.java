public abstract class OrderProcessorTemplate {

    public final void process(Order order) throws AppException{
        try{
            validateOrder(order);
            if (fraudCheck(order)) {
                calculatePrice(order);
                pay(order);
                sendNotification(order);
            }else{
                throw new FraudCheckFailedException("Fraud was detected.");
            }

        }catch(Exception e){
            throw new AppException("Order processing failed", e);
        }

    }

    protected abstract void validateOrder(Order order);
    protected abstract boolean fraudCheck(Order order);

    protected void calculatePrice(Order order){
        if (order.getTotalPrice() > 20000) {
            // make a discount
        }
    }

    protected abstract void pay(Order order);

    protected void sendNotification(Order order){
        System.out.println("Order №" + order.getId() + "was processed");
    }

}
