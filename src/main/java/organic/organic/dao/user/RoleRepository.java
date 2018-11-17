package organic.organic.dao.user;

import org.springframework.data.repository.CrudRepository;
import organic.organic.model.user.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
