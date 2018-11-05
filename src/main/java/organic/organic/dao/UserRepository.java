package organic.organic.dao;

import org.springframework.data.repository.CrudRepository;
import organic.organic.model.User;

public interface UserRepository  extends CrudRepository<User, Integer> {

}