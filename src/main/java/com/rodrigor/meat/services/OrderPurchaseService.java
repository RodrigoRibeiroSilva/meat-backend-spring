package com.rodrigor.meat.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rodrigor.meat.domain.OrderPurchase;

@Service
public class OrderPurchaseService extends GenericService<OrderPurchase>{
	
	@Override
	@Transactional
	public OrderPurchase insert(OrderPurchase obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
		 
	}

}
