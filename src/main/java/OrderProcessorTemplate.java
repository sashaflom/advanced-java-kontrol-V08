public abstract class OrderProcessorTemplate {

    public final void process(Order order) {
        validateOrder(order);
        fraudCheck(order);
        calculatePrice(order);
        pay(order);
        sendNotification(order);
    }

    protected abstract void validateOrder(Order order);
    protected abstract boolean fraudCheck(Order order);

    protected void calculatePrice(Order order){

    }

    protected abstract void pay(Order order);

    protected void sendNotification(Order order){
        System.out.println("Order №" + order.getId() + "was processed");
    }

}
