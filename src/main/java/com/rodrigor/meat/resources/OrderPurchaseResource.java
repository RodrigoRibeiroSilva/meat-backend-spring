package com.rodrigor.meat.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigor.meat.domain.OrderPurchase;
import com.rodrigor.meat.services.KafkaOrderProducerService;

@RestController
@RequestMapping(value = "/order")
public class OrderPurchaseResource extends GenericResource<OrderPurchase> {

	@Autowired
	private KafkaOrderProducerService service;

	@Override
	public ResponseEntity<OrderPurchase> insert(@Valid @RequestBody OrderPurchase payload) {
		service.sendMessage(payload);
		return ResponseEntity.ok().body(payload);
	}
}
