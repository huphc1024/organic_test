package organic.organic.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import organic.organic.model.user.Role;
import organic.organic.model.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userReponsitory;
    @Autowired
    RoleRepository roleRepository;

    public User findByUsername(String username) {
        return userReponsitory.findByUsername(username);
    }

    public void saveUser(User user) {


        Role userRole = roleRepository.findByName("ADMIN");
        user.setUserRoles(new ArrayList<Role>(Arrays.asList(userRole)){});
        userReponsitory.save(user);
    }

    public List<User> findAll(){
        return userReponsitory.findAll();
    }

    public ServiceResult findById(int id) {
        ServiceResult result = new ServiceResult();
        User user = userReponsitory.findById(id).orElse(null);
        result.setData(user);
        return result;
    }

    public ServiceResult create(User user) {
        ServiceResult result = new ServiceResult();
        result.setData(userReponsitory.save(user));
        return result;
    }

    public ServiceResult update(User user) {
        ServiceResult result = new ServiceResult();
        if (!userReponsitory.findById(user.getId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("User Not Found");
        } else {
            result.setData(userReponsitory.save(user));
        }
        return result;
    }

    public ServiceResult delete(int id) {
        ServiceResult result = new ServiceResult();
        User user = userReponsitory.findById(id).orElse(null);
        if (user == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("User Not Found");
        } else {
            userReponsitory.deleteById(id);
            result.setMessage("success");
        }
        return result;
    }
}
