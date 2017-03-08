package com.travelbest.controller;

import com.travelbest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    public static final String REJECT_ORDER_URL = "api/orders/:id/reject";

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @PatchMapping(OrderController.REJECT_ORDER_URL)
    public ResponseEntity<?> rejectOrder(@PathVariable("id") Long id,
            @RequestHeader(value = "Authorization", defaultValue = "") String token) {

        orderService.rejectOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
