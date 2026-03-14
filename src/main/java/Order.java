import java.util.Arrays;

public class Order {

    private final int id;
    private OrderItem[] items;
    private double totalPrice;

    public Order(int id, OrderItem[] items) {
        this(id, items, 0.0);
    }

    public Order(int id, OrderItem[] items, double totalPrice) {
        this.id = id;
        this.items = items != null ? Arrays.copyOf(items, items.length) : new OrderItem[0];
        this.totalPrice = totalPrice;
    }

    public OrderItem[] getItems() {
        return Arrays.copyOf(items, items.length);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }
}
