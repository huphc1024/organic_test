package organic.organic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import organic.organic.dao.shop.ShopRepository;
import organic.organic.dao.shop.ShopService;
import organic.organic.model.shop.Shop;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("/api")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopRepository shopRepository;

    /* ---------------- GET IMAGE SHOP ------------------------ */
    @GetMapping("/shop/image/{id}")
    public void showImage(@PathVariable("id") Integer itemId, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {


        Shop item = shopRepository.getOne(itemId);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(item.getImage());


        response.getOutputStream().close();
    }
}
