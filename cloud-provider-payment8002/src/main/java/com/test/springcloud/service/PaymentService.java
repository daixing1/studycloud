package com.test.springcloud.service;

import com.test.springcloud.entities.Payment;

/**
 * User: 兴希
 * Date: 2020/11/6
 * Time: 9:53
 * Description: No Description
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
