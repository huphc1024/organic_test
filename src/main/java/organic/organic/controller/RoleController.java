package organic.organic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import organic.organic.dao.user.RoleService;
import organic.organic.dao.user.ServiceResult;
import organic.organic.model.user.Role;

@Controller
@RequestMapping("/api")
public class RoleController {
        @Autowired
        private RoleService userService;

        /* ---------------- GET ALL ROLE ------------------------ */
        @GetMapping("/roles")
        public ResponseEntity<ServiceResult> findAllRole() {
            return new ResponseEntity<ServiceResult>(userService.findAll(), HttpStatus.OK);
        }
        /* ---------------- GET ROLE BY ID ------------------------ */
        @GetMapping("/role/{id}")
        public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
            return new ResponseEntity<ServiceResult>(userService.findById(id), HttpStatus.OK);
        }
        /* ---------------- CREATE NEW ROLE ------------------------ */
        @PostMapping("/role")
        public ResponseEntity<ServiceResult> create(@RequestBody Role userRole) {
            return new ResponseEntity<ServiceResult>(userService.create(userRole), HttpStatus.OK);
        }

        /* ---------------- UPDATE ROLE ------------------------ */
        @PutMapping("/role/{id}")
        public ResponseEntity<ServiceResult> update(@RequestBody Role userRole, @PathVariable int id) {
            userRole.setId(id);
            return new ResponseEntity<ServiceResult>(userService.update(userRole), HttpStatus.OK);
        }
        @DeleteMapping("/role/{id}")
        public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
            return new ResponseEntity<ServiceResult>(userService.delete(id), HttpStatus.OK);
        }
}

