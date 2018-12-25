package organic.organic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

//    @GetMapping("/order_id/{id}")
//    public @ResponseBody
//    int findOrderByidUser(@PathVariable int id) {
//        return orderRepository.findOrderByIdUser(id);
//    }

    @GetMapping("/ordersitems")
    public @ResponseBody
    List<OrdersItem> findAllOrderItem() {
        return orderItemRepository.findAll();
    }
    
    @GetMapping("/ordersitemsbyorder/{id_order}")
    public @ResponseBody
    List<OrdersItem> findAllOrderItemByOrdersId(@PathVariable int id_order) {
        return orderItemRepository.listOrdersItemByOrder(id_order);
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
    @PostMapping("/order/{id_user}/{payment_id}-{discount_code}/{id_product}-{quantity}")
    public @ResponseBody String create(@PathVariable List<Integer> id_product, @PathVariable int discount_code,
                                       @PathVariable int payment_id, @PathVariable List<Integer> quantity,
                                       @RequestBody Orders orders, @PathVariable int id_user ) {
        Date date = new Date();
        String mess = "";
        orders.setPayment(paymentRepository.getOne(payment_id));
        orders.setTbl_discount_code(discountRepository.getOne(discount_code));
        orders.setRef_order_status_code(refOrderStatusRepository.findByCode("w"));
        orders.setDate_order_placed(new Timestamp(date.getTime()));
        orders.setTbl_user_id(id_user);
        if(orderRepository.save(orders) == null){
            mess = "fail";
        }
        else{
            int id_order = orderRepository.findOrderByIdUser(id_user);
            for (int i = 0; i < id_product.size(); i++) {
                OrdersItem ordersItem = new OrdersItem();
                ordersItem.setTbl_product_id(id_product.get(i));
                ordersItem.setQuantity(quantity.get(i));
                ordersItem.setOrders(orderRepository.getOne(id_order));
                ordersItem.setRef_order_item_status_code(refOrderItemStatusRepository.findByCode("w"));
                if(orderItemRepository.save(ordersItem) == null){
                    return mess = "fail";
                }
            }
            mess = "success";
        }
        return mess;
    }
    @PutMapping("/order/{id_order}")
    public @ResponseBody String update(@PathVariable int id_order, @RequestBody Orders order) {
        String mess = "";
        Orders orders = orderRepository.getOne(id_order);
        orders.setRef_order_status_code(refOrderStatusRepository.findByCode(order.getRef_order_status_code().getCode()));
        orders.setId(id_order);
        if(orderRepository.save(orders) == null){
            mess = "fail";
        }
        else{
            mess = "success";
        }
        return mess;
    }

    @DeleteMapping("/order/{id_order}")
    public @ResponseBody String delete(@PathVariable int id_order) {
        String mess = "";
        try {
            for (Integer i : orderItemRepository.listOrdersItemByOrder(id_order)
                 ) {
                orderItemRepository.deleteById(i);
            }
            //orderItemRepository.deleteALlByOrderId(id_order);
            System.out.print("SAI");
            orderRepository.deleteById(id_order);
            mess = "success";
        }catch (Exception e){
            mess = "fail";
        }

        return mess;
    }

//    @PostMapping("/ordersitem/{order_id}-{code_status}")
//    public @ResponseBody String create(@PathVariable int order_id, @PathVariable String code_status,
//                                       @RequestBody OrdersItem ordersitem) {
//        String mess = "";
//        ordersitem.setOrders(orderRepository.getOne(order_id));
//        ordersitem.setRef_order_item_status_code(refOrderItemStatusRepository.findByCode(code_status));
//        if(orderItemRepository.save(ordersitem) == null){
//            mess = "fail";
//        }
//        else{
//            mess = "success";
//        }
//        return mess;
//    }

}
