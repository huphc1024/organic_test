package organic.organic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import organic.organic.dao.order.DiscountRepository;

//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
//@Controller
//@RequestMapping("/api")
public class DiscountController {
    @Autowired
    private DiscountRepository discountRepository;
}
