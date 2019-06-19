package com.rodrigor.meat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigor.meat.domain.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
