package organic.organic.model.product;

import javax.persistence.*;

@Entity
@Table(name = "tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", updatable = false, nullable = false)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Float price;
    @Column(name = "unit")
    private String unit;
    @Column(name = "stock")
    private String stock;
    @Column(name = "sku")
    private String sku;
    @Column(name = "rating")
    private String rating;
    @Column(name = "buy")
    private String buy;
    @Column(name = "sale")
    private String sale;
    @Column(name = "hotdeal")
    private String hotdeal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getHotdeal() {
        return hotdeal;
    }

    public void setHotdeal(String hotdeal) {
        this.hotdeal = hotdeal;
    }
}
