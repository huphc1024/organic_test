package organic.organic.dao.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import organic.organic.model.orders.OrdersItem;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrdersItem, Integer> {
    @Query( value = "DELETE FROM tbl_order_item WHERE tbl_order_id = ?1",  nativeQuery = true)
    public int deleteALlByOrderId(int id);
    @Query( value = "SELECT * FROM tbl_order_item WHERE tbl_order_id = ?1",  nativeQuery = true)
    public List<OrdersItem> listOrdersItemByOrder(int id_order);
    @Query( value = "SELECT id FROM tbl_order_item WHERE tbl_order_id = ?1",  nativeQuery = true)
    public List<Integer> listidOrdersItemByOrder(int id_order);
}
