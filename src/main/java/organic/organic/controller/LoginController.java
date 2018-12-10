package organic.organic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import organic.organic.dao.user.ServiceResult;
import organic.organic.dao.user.UserService;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;






}
