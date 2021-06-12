package com.sda.anca.webshop.repository;

import com.sda.anca.webshop.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
