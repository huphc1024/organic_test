package organic.organic.dao.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import organic.organic.model.orders.RefOrderItemStatus;

public interface RefOrdersItemStatus extends JpaRepository<RefOrderItemStatus, Integer> {
    @Query( value = "SELECT * FROM ref_order_item_status r WHERE r.code = ?1",  nativeQuery = true)
    public RefOrderItemStatus findByCode(String code);
}
