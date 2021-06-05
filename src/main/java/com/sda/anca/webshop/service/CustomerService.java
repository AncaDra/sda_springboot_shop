package com.sda.anca.webshop.service;

import com.sda.anca.webshop.model.Account;
import com.sda.anca.webshop.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final AccountRepository accountRepository;
    //private este cel mai restrictiv mod de acces

    // injected by Spring through the constructor
    public CustomerService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public  void addCustomer(Account account){
        accountRepository.save(account);
    }
    public List<Account> getCustomerAccounts(){
        return accountRepository.getAll();
    }
}
