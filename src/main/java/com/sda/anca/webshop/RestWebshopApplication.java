package com.sda.anca.webshop;

import com.sda.anca.webshop.model.Account;
import com.sda.anca.webshop.model.Customer;
import com.sda.anca.webshop.model.Product;
import com.sda.anca.webshop.model.ProductCategory;
import com.sda.anca.webshop.repository.AccountRepository;
import com.sda.anca.webshop.service.CustomerService;
import com.sda.anca.webshop.service.MailService;
import com.sda.anca.webshop.service.OrderService;
import com.sda.anca.webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@SpringBootApplication
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.sda.anca.webshop.repository")
//@EntityScan(basePackages = "com.sda.anca.webshop.model")
public class RestWebshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestWebshopApplication.class, args);
    }


}
