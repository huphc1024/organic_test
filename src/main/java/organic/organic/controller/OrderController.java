package organic.organic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import organic.organic.dao.order.*;
import organic.organic.model.orders.Orders;
import organic.organic.model.orders.OrdersItem;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private RefOrderStatusRepository refOrderStatusRepository;
    @Autowired
    private RefOrdersItemStatus refOrderItemStatusRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @GetMapping("/orders")
    public @ResponseBody
    List<Orders> findAllCustomer() {
        return orderRepository.findAll();
    }

    @GetMapping("/order_id/{id}")
    public @ResponseBody
    int findOrderByidUser(@PathVariable int id) {
        return orderRepository.findOrderByIdUser(id);
    }

    @GetMapping("/ordersitems")
    public @ResponseBody
    List<OrdersItem> findAllOrderItem() {
        return orderItemRepository.findAll();
    }

    @GetMapping("/ordersitem/{id}")
    public @ResponseBody Optional<OrdersItem> findByIdOrdersItem(@PathVariable int id) {
        return orderItemRepository.findById(id);
    }

    @GetMapping("/order/{id}")
    public @ResponseBody Optional<Orders> findById(@PathVariable int id) {
        return orderRepository.findById(id);
    }

//     -- add order --
    @PostMapping("/order/{payment_id}-{discount_code}-{status_code}")
    public @ResponseBody String create(@PathVariable int payment_id, @PathVariable int discount_code,
                                       @PathVariable String status_code, @RequestBody Orders orders) {
        Date date = new Date();
        String mess = "";
        orders.setPayment(paymentRepository.getOne(payment_id));
        orders.setTbl_discount_code(discountRepository.getOne(discount_code));
        orders.setRef_order_status_code(refOrderStatusRepository.findByCode(status_code));
        orders.setDate_order_placed(new Timestamp(date.getTime()));
        if(orderRepository.save(orders) == null){
            mess = "fail";
        }
        else{
            mess = "success";
        }
        return mess;
    }

    @PostMapping("/ordersitem/{order_id}-{code_status}")
    public @ResponseBody String create(@PathVariable int order_id, @PathVariable String code_status,
                                       @RequestBody OrdersItem ordersitem) {
        String mess = "";
        ordersitem.setOrders(orderRepository.getOne(order_id));
        ordersitem.setRef_order_item_status_code(refOrderItemStatusRepository.findByCode(code_status));
        if(orderItemRepository.save(ordersitem) == null){
            mess = "fail";
        }
        else{
            mess = "success";
        }
        return mess;
    }

}
