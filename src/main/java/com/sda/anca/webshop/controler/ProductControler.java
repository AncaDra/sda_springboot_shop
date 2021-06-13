package com.sda.anca.webshop.controler;

import com.sda.anca.webshop.error.ResourceNotFoundException;
import com.sda.anca.webshop.model.Product;
import com.sda.anca.webshop.service.ProductService;
import javassist.NotFoundException;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductControler {
    private final ProductService productService;

    public ProductControler(ProductService productService) {
        this.productService = productService;
    }

    //metoda de returnare a produselor
    @GetMapping("/products")
    public List<Product> getAllProducts() {

        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId) throws ResourceNotFoundException {
        Optional<Product> product = productService.findById(productId);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        }
        //throw new IllegalArgumentException();
        throw new ResourceNotFoundException("product with id: " + productId + " was not found!");
    }

    @PostMapping("/products")
    public String createProduct(@Valid @RequestBody Product product) {
        productService.save(product);
        return ("product saved");
    }
}
