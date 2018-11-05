package organic.organic.dao;

import org.springframework.data.repository.CrudRepository;
import organic.organic.model.UserRole;

public interface RoleRepository extends CrudRepository<UserRole, Integer> {
}
