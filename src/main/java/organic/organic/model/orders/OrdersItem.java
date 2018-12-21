package organic.organic.model.orders;

import javax.persistence.*;

@Entity
@Table(name = "tbl_order_item")
public class OrdersItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", updatable = false, nullable = false)
    private int id;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "tbl_order_id")
    private Orders orders;

    @Column(name = "tbl_product_id")
    private int tbl_product_id;

    @ManyToOne
    @JoinColumn(name = "ref_order_item_status_code")
    private RefOrderItemStatus ref_order_item_status_code;

    public int getId() {
        return id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    public int getTbl_product_id() {
        return tbl_product_id;
    }

    public void setTbl_product_id(int tbl_product_id) {
        this.tbl_product_id = tbl_product_id;
    }

    public RefOrderItemStatus getRef_order_item_status_code() {
        return ref_order_item_status_code;
    }

    public void setRef_order_item_status_code(RefOrderItemStatus ref_order_item_status_code) {
        this.ref_order_item_status_code = ref_order_item_status_code;
    }
}
