package kz.enu.learn.dias.gp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.enu.learn.dias.gp.project.Customer;
import kz.enu.learn.dias.gp.project.Order;
import kz.enu.learn.dias.gp.project.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    ObjectMapper obMapper;

    @GetMapping("/hello")
    public String myListener() {
        return "HELLO ONLINE SHOPPING SYSTEM";
    }

    // Получить данные о покупателе
    @GetMapping("/customer/{id}")
    public String getCustomer(@PathVariable int id) {
        String jsonText = null;
        Customer customer = new Customer(id, "Dias", "Mendeshev");
        try {
            jsonText = obMapper.writeValueAsString(customer);
        } catch (JsonProcessingException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return jsonText;
    }

    // Создать новый заказ
    @PostMapping("/order")
    public String createOrder(@RequestBody Order order) {
        String jsonText = null;
        try {
            jsonText = obMapper.writeValueAsString(order);
        } catch (JsonProcessingException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return jsonText;
    }

    // Получить данные о продукте
    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable int id) {
        String jsonText = null;
        Product product = new Product(id, "Laptop", 1000.0);
        try {
            jsonText = obMapper.writeValueAsString(product);
        } catch (JsonProcessingException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return jsonText;
    }
}
