package com.test.springcloud.dao;

import com.test.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * User: 兴希
 * Date: 2020/11/6
 * Time: 9:38
 * Description: No Description
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
