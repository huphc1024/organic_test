package organic.organic.model.orders;


import javax.persistence.*;

@Entity
@Table(name = "ref_order_item_status")
public class RefOrderItemStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="code", updatable = false, nullable = false)
    private String code;

    public RefOrderItemStatus() {
    }

    private enum order_item_status {WAITING, ACCEPT, REJECT};

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
