package com.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.dao.PaymentDao;
import com.books.entity.Payment;
@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
	PaymentDao paymentDao;
	
	@Override
	public void savePayments(Payment payments) {
		paymentDao.save(payments);
		
	}

}
