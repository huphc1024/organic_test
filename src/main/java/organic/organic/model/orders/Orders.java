package organic.organic.model.orders;

import javax.persistence.*;

@Entity
@Table(name = "tbl_order")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", updatable = false, nullable = false)
    private int id;

    @Column(name = "order_status_code")
    private String order_status_code;

    @Column(name = "date_order_placed")
    private String date_order_placed;

    @Column(name = "tbl_payment_id")
    private int tbl_payment_id;

    @Column(name = "ref_order_status_code")
    private String ref_order_status_code;

    @Column(name = "tbl_discount_code")
    private int tbl_discount_code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_status_code() {
        return order_status_code;
    }

    public void setOrder_status_code(String order_status_code) {
        this.order_status_code = order_status_code;
    }

    public String getDate_order_placed() {
        return date_order_placed;
    }

    public void setDate_order_placed(String date_order_placed) {
        this.date_order_placed = date_order_placed;
    }

    public int getTbl_payment_id() {
        return tbl_payment_id;
    }

    public void setTbl_payment_id(int tbl_payment_id) {
        this.tbl_payment_id = tbl_payment_id;
    }

    public String getRef_order_status_code() {
        return ref_order_status_code;
    }

    public void setRef_order_status_code(String ref_order_status_code) {
        this.ref_order_status_code = ref_order_status_code;
    }

    public int getTbl_discount_code() {
        return tbl_discount_code;
    }

    public void setTbl_discount_code(int tbl_discount_code) {
        this.tbl_discount_code = tbl_discount_code;
    }
}
