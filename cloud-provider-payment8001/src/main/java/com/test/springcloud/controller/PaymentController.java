package com.test.springcloud.controller;

import com.test.springcloud.entities.CommonResult;
import com.test.springcloud.entities.Payment;
import com.test.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);

        if (result>0){
            return new CommonResult(200,"插入数据库成功",result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        String s = result.getSerial();
        log.info(s);
        if (result!=null){
            return new CommonResult(200,"查询成功",result);
        }else {
            return new CommonResult(444,"没有对应记录",null);
        }
    }
}
