package com.rodrigor.meat.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigor.meat.domain.OrderPurchase;

@RestController
@RequestMapping(value="/order")
public class OrderPurchaseResource extends GenericResource<OrderPurchase> {

}
