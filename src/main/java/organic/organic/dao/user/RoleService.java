package organic.organic.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import organic.organic.model.user.Role;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public ServiceResult findAll(){
        ServiceResult result = new ServiceResult();
        result.setData(roleRepository.findAll());
        return result;
    }

    public ServiceResult findById(int id) {
        ServiceResult result = new ServiceResult();
        Role userRole = roleRepository.findById(id).orElse(null);
        result.setData(userRole);
        return result;
    }

    public ServiceResult create(Role userRole) {
        ServiceResult result = new ServiceResult();
        result.setData(roleRepository.save(userRole));
        return result;
    }

    public ServiceResult update(Role userRole) {
        ServiceResult result = new ServiceResult();
        if (!roleRepository.findById(userRole.getId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("UserRole Not Found");
        } else {
            result.setData(roleRepository.save(userRole));
        }
        return result;
    }

    public ServiceResult delete(int id) {
        ServiceResult result = new ServiceResult();
        Role userRole = roleRepository.findById(id).orElse(null);
        if (userRole == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("UserRole Not Found");
        } else {
            roleRepository.deleteById(id);
            result.setMessage("success");
        }
        return result;
    }
}
