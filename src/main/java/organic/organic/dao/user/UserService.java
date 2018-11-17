package organic.organic.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import organic.organic.model.user.User;

@Service
public class UserService {
    @Autowired
    UserRepository userReponsitory;

    public ServiceResult findAll(){
        ServiceResult result = new ServiceResult();
        result.setData(userReponsitory.findAll());
        return result;
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
