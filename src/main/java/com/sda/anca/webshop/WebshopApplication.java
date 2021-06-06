package com.sda.anca.webshop;

import com.sda.anca.webshop.model.Account;
import com.sda.anca.webshop.model.Customer;
import com.sda.anca.webshop.repository.AccountRepository;
import com.sda.anca.webshop.service.CustomerService;
import com.sda.anca.webshop.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.sda.anca.webshop.repository")
@EntityScan(basePackages = "com.sda.anca.webshop.model" )
public class WebshopApplication implements CommandLineRunner {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MailService mailService;
    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(WebshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();

        //here we have the context and we can add code
        Account account1 = new Account();
        account1.setId(1L);

        Customer customer= new Customer();
        customer.setId(1L);

        customerService.addCustomer(account1, customer);

        customerService.getCustomerAccounts().forEach(account -> System.out.println(account) );

        //mailService.sendMail("ancaelena.dragomir@gmail.com", "client@example.com", "mock mail subject", "mock mail content");

        accountRepository.findAllByIsClosed(false).forEach(System.out::println);


    }

}
