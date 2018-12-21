package organic.organic.model.orders;

import javax.persistence.*;

@Entity
@Table(name = "tbl_discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="code", updatable = false, nullable = false)
    private int code;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "discount_number")
    private float discount_number;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getDiscount_number() {
        return discount_number;
    }

    public void setDiscount_number(float discount_number) {
        this.discount_number = discount_number;
    }
}
