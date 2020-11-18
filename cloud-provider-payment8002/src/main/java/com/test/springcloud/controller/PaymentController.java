package com.test.springcloud.controller;


import com.test.springcloud.entities.CommonResult;
import com.test.springcloud.entities.Payment;
import com.test.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: 兴希
 * Date: 2020/11/6
 * Time: 9:51
 * Description: No Description
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);

        if (result>0){
            return new CommonResult(200,"插入数据库成功,serverPort"+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败,serverPort"+serverPort,null);
        }
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        String s = result.getSerial();
        log.info(s);
        if (result!=null){
            return new CommonResult(200,"查询成功,serverPort"+serverPort,result);
        }else {
            return new CommonResult(444,"没有对应记录,serverPort"+serverPort,null);
        }
    }

    @GetMapping("discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String ser:services){
            log.info(ser);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance si:instances){
            log.info(si.getServiceId()+"\t"+si.getHost()+"\t"+si.getPort()+"\t"+si.getUri());
        }
        return discoveryClient;
    }
}
