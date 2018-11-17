package organic.organic.dao.user;

import org.springframework.data.repository.CrudRepository;
import organic.organic.model.user.User;

public interface UserRepository  extends CrudRepository<User, Integer> {

}