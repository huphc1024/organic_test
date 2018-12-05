package organic.organic.model.shop;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Blob;

@Entity
@Table(name = "tbl_shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", updatable = false, nullable = false)
    private int id;

    @Column(name = "name")
    private  String name;
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "image")
    private byte[] image;

    public int getId() {        return id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
