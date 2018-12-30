package organic.organic.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import organic.organic.dao.product.ProductRepository;
import organic.organic.model.product.Product;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/producthotdeal")
    public @ResponseBody
    Optional<Product> finhProductHotDeal1() {
        return productRepository.findByHotDeal();
    }

    @GetMapping("/productssale")
    public @ResponseBody
    List<Product> finhProductSale() {
        return productRepository.findAllBySale();
    }
}

