package com.example.webapp.controllers;


import com.example.webapp.domain.Orders;
import com.example.webapp.services.InfoService;
import com.example.webapp.services.ItemService;
import com.example.webapp.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @RequestMapping("/orders")
    public ModelAndView orderList(){
        ModelAndView modelAndView = new ModelAndView("order/order-list");
        List<Orders> orders = orderService.findAll();
        modelAndView.addObject("orders",orders);
        return modelAndView;
    }

    @RequestMapping("/order/delete/{id}")
    public String deleteById(@PathVariable String id){
        orderService.deleteById(Long.valueOf(id));
        return "redirect:/orders";
    }



}
