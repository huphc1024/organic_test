package organic.organic.model.orders;

import javax.persistence.*;
import java.sql.Timestamp;

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
    private Timestamp date_order_placed;

    @ManyToOne
    @JoinColumn(name = "tbl_payment_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "ref_order_status_code")
    private RefOrderStatus ref_order_status_code;

    @ManyToOne
    @JoinColumn(name = "tbl_discount_code")
    private Discount tbl_discount_code;

    @Column(name = "tbl_user_id")
    private int tbl_user_id;

    public int getTbl_user_id() {
        return tbl_user_id;
    }

    public void setTbl_user_id(int tbl_user_id) {
        this.tbl_user_id = tbl_user_id;
    }

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

    public Timestamp getDate_order_placed() {
        return date_order_placed;
    }

    public void setDate_order_placed(Timestamp date_order_placed) {
        this.date_order_placed = date_order_placed;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public RefOrderStatus getRef_order_status_code() {
        return ref_order_status_code;
    }

    public void setRef_order_status_code(RefOrderStatus ref_order_status_code) {
        this.ref_order_status_code = ref_order_status_code;
    }

    public Discount getTbl_discount_code() {
        return tbl_discount_code;
    }

    public void setTbl_discount_code(Discount tbl_discount_code) {
        this.tbl_discount_code = tbl_discount_code;
    }

}
