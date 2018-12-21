package organic.organic.dao.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import organic.organic.model.orders.Orders;
import organic.organic.model.orders.RefOrderStatus;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
    @Query( value = "SELECT r.id FROM tbl_order r WHERE r.tbl_user_id = ?1 ORDER BY r.id DESC LIMIT 1",  nativeQuery = true)
    public int findOrderByIdUser(int id);
}
