package com.andrew.springcloud.dao;

import com.andrew.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Andrew Yang
 * @className PaymentDao
 * @description
 * @package com.andrew.springcloud.dao
 * @create 2021-05-30 14:50
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
