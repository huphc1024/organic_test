package organic.organic.dao.order;

import org.springframework.data.jpa.repository.JpaRepository;
import organic.organic.model.orders.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
