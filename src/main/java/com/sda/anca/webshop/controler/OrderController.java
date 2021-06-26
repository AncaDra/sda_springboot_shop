package com.sda.anca.webshop.controler;

import com.sda.anca.webshop.model.OrderStatus;
import com.sda.anca.webshop.service.OrderService;
import com.sda.anca.webshop.service.dto.OrderDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;

    }
    @PostMapping("/orders")
    public String addOrder(@RequestBody OrderDTO orderDTO){
        orderService.save(orderDTO);
        return "Order created";
            }

    @PatchMapping("/orders/{id}")
    public String changeStatus(@PathVariable(value="id") Long orderId, @RequestBody String status){
        orderService.updateStatus(orderId, OrderStatus.valueOf(status));
        return "status changed";
            }

}
