package organic.organic.model.user;


import javax.persistence.*;

@Entity
@Table(name = "tbl_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", updatable = false, nullable = false)
    private int id_role;

    @Column(name = "name")
    private  String name;




    public int getId() {
        return id_role;
    }

    public void setId(int id) {
        this.id_role = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role() {
    }
}
