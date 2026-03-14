import java.util.Arrays;
import java.util.Objects;

public class Order {

    private final int id;
    private OrderItem[] items;
    private double totalPrice;
    private OrderStatus status;

    public Order(int id, OrderItem[] items) {
        this(id, items, 0.0);
    }

    public Order(int id, OrderItem[] items, double totalPrice) {
        this.id = id;
        this.items = items != null ? Arrays.copyOf(items, items.length) : new OrderItem[0];
        this.totalPrice = totalPrice;
        status = OrderStatus.NEW;
    }

    @Override
    public String toString() {
        return "Order: id = '%d', totalPrice = '%d', status = '%s'".formatted(id, totalPrice, status);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && totalPrice == order.totalPrice && Objects.deepEquals(items, order.items) && status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Arrays.hashCode(items), totalPrice, status);
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
