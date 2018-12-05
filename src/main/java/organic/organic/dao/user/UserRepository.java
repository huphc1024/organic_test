package organic.organic.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import organic.organic.model.user.User;

public interface UserRepository  extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}