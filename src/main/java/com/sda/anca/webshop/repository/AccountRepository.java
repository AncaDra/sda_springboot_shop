package com.sda.anca.webshop.repository;


import com.sda.anca.webshop.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

    }

