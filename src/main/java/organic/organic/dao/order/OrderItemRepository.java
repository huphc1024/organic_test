package organic.organic.dao.order;

import org.springframework.data.jpa.repository.JpaRepository;
import organic.organic.model.orders.OrdersItem;

public interface OrderItemRepository extends JpaRepository<OrdersItem, Integer> {

}
