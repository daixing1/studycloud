package com.test.springcloud.service.impl;

import com.test.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.springcloud.dao.PaymentDao;
import com.test.springcloud.service.PaymentService;

/**
 * User: 兴希
 * Date: 2020/11/6
 * Time: 9:49
 * Description: No Description
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
