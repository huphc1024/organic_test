package organic.organic.dao.order;

import org.springframework.data.jpa.repository.JpaRepository;
import organic.organic.model.orders.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
