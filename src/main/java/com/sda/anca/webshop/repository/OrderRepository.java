package com.sda.anca.webshop.repository;

import com.sda.anca.webshop.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
