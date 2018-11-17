package organic.organic.model.user;

import javax.persistence.*;

@Entity
@Table(name = "ref_user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", updatable = false, nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "tbl_user_id")
    private User users;
    @ManyToOne
    @JoinColumn(name = "tbl_role_id")
    private Role roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }
}
