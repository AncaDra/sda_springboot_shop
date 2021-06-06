package com.sda.anca.webshop.service;

import com.sda.anca.webshop.model.Account;
import com.sda.anca.webshop.model.Customer;
import com.sda.anca.webshop.repository.AccountRepository;
import com.sda.anca.webshop.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {
    private final AccountRepository accountRepository;
    //private este cel mai restrictiv mod de acces

    private final CustomerRepository customerRepository;

    // injected by Spring through the constructor
    public CustomerService(AccountRepository accountRepository, CustomerRepository customerRepository) {

        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void addCustomer(Account account, Customer customer) {
        accountRepository.save(account);
        customerRepository.save(customer);
    }

    public Iterable<Account> getCustomerAccounts() {
        return accountRepository.findAll();
    }
}
