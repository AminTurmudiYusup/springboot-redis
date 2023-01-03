package com.example.redis.controller;

import com.example.redis.entity.PaymentType;
import com.example.redis.repository.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentTypeController {
    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Cacheable(value = "list-of-payment")//define key of list payment
    @GetMapping("/payment-type")
    public List<PaymentType> getAllPaymentType() throws InterruptedException {
        Thread.sleep(3000);
        return paymentTypeRepository.findAll();
    }
}
