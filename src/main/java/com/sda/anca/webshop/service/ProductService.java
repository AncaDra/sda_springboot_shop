package com.sda.anca.webshop.service;

import com.sda.anca.webshop.model.Product;
import com.sda.anca.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> findAll() {
       // return new ArrayList<Product>((Collection<? extends Product>) productRepository.findAll());
    return StreamSupport.stream(productRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

}
