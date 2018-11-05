package organic.organic.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "user_test")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", updatable = false, nullable = false)
    private int id;

    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role")
    private UserRole role;

    public User(){

    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    @JsonCreator
//    public User(@JsonProperty("email") String email, @JsonProperty("phone") String phone, @JsonProperty("password") String password) {
//        this.email = email;
//        this.phone = phone;
//        this.password = password;
//    }
//    public User(int id, String email, String phone, String password) {
//        this.id = id;
//        this.email = email;
//        this.phone = phone;
//        this.password = password;
//    }

}
