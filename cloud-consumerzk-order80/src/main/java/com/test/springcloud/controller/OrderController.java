package com.test.springcloud.controller;


import com.test.springcloud.entities.CommonResult;
import com.test.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * User: 兴希
 * Date: 2020/11/8
 * Time: 22:00
 * Description: No Description
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

//    private final static String PAYMENT_URL = "http://localhost:8001/";
    private final static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @PostMapping("create")
    public CommonResult create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("getById/{id}")
    public CommonResult getById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById/"+id,CommonResult.class);
    }
}
