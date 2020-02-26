package com.books.dao;

import org.springframework.data.repository.CrudRepository;

import com.books.entity.Payment;

public interface PaymentDao extends CrudRepository<Payment, Integer> {

}
