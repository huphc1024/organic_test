package organic.organic.dao.order;

import org.springframework.data.jpa.repository.JpaRepository;
import organic.organic.model.orders.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Integer> {
}
