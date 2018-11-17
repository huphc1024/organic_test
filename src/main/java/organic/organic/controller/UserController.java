package organic.organic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import organic.organic.dao.user.ServiceResult;
import organic.organic.dao.user.UserService;
import organic.organic.model.user.User;

@Controller
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    /* ---------------- GET ALL USER ------------------------ */
    @GetMapping("/users")
    public ResponseEntity<ServiceResult> findAllCustomer() {
        return new ResponseEntity<ServiceResult>(userService.findAll(), HttpStatus.OK);
    }
    /* ---------------- GET USER BY ID ------------------------ */
    @GetMapping("/user/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(userService.findById(id), HttpStatus.OK);
    }
    /* ---------------- CREATE NEW USER ------------------------ */
    @PostMapping("/user")
    public ResponseEntity<ServiceResult> create(@RequestBody User user) {
        return new ResponseEntity<ServiceResult>(userService.create(user), HttpStatus.OK);
    }

    /* ---------------- UPDATE USER ------------------------ */
    @PutMapping("/user/{id}")
    public ResponseEntity<ServiceResult> update(@RequestBody User user, @PathVariable int id) {
        user.setId(id);
        return new ResponseEntity<ServiceResult>(userService.update(user), HttpStatus.OK);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(userService.delete(id), HttpStatus.OK);
    }
}
