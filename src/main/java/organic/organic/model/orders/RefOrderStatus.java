package organic.organic.model.orders;

import javax.persistence.*;

@Entity
@Table(name = "ref_order_status")
public class RefOrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="code", updatable = false, nullable = false)
    private String code;

    private enum order_status {WAITING, SHIPPING, DELIVERED};

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}