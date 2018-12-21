package organic.organic.dao.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import organic.organic.model.orders.RefOrderStatus;

import java.util.Optional;

public interface RefOrderStatusRepository extends JpaRepository<RefOrderStatus, Integer> {
    @Query( value = "SELECT * FROM ref_order_status r WHERE r.code = ?1",  nativeQuery = true)
    public RefOrderStatus findByCode(String code);
}
