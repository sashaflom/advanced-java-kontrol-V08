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

    protected void validateOrder(Order order){
        int howMuch = order.getItems().length;
        if (howMuch < 1 || howMuch > 5) {
            throw new IllegalArgumentException("Invalid amount of items: " + howMuch);
        }
    }
    protected abstract boolean fraudCheck(Order order);

    protected void calculatePrice(Order order){
        if (order.getTotalPrice() > 20000) {
            order.setTotalPrice(order.getTotalPrice() * 0.9);
            System.out.println("You have 10% discount");
        }
    }

    protected abstract void pay(Order order);

    protected void sendNotification(Order order){
        System.out.println("Order №" + order.getId() + "was processed");
    }

}
