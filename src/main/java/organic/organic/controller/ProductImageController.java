package organic.organic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import organic.organic.dao.product.ProductImageRepository;
import organic.organic.dao.product.ProductImageService;
import organic.organic.model.shop.Shop;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class ProductImageController {

    @Autowired
    ProductImageService productImageService;

    @Autowired
    ProductImageRepository productImageRepository;
    /* ---------------- GET IMAGE PRODUCT ------------------------ */
    @GetMapping("/product/image/{id}")
    public void showImage(@PathVariable("id") Integer itemId, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {


        Shop item = productImageRepository.getOne(itemId);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(item.getImage());


        response.getOutputStream().close();
    }
    /* ---------------- GET IMAGE PRODUCT ------------------------ */
    @GetMapping("/productimages/{id}")
    public @ResponseBody  List<Shop> listImage(@PathVariable("id") Integer itemId) {


        List<Shop> items = productImageRepository.findAllByIdProdut(itemId);


        return items;
    }
}
