import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderService {

    private final List<Order> repository = new ArrayList<>();

    public Optional<Order> findById(int id) {
        return repository.stream()
                .filter(o -> o.getId() == id)
                .findFirst();
    }

}
