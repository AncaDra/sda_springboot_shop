package com.sda.anca.webshop.controler;

import com.sda.anca.webshop.model.Account;
import com.sda.anca.webshop.service.AccountService;
import com.sda.anca.webshop.service.dto.UserRegistrationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Base64;
import java.util.Date;

@RestController
@RequestMapping("/api")

public class AccountController {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AccountService accountService;

    public AccountController(BCryptPasswordEncoder bCryptPasswordEncoder, AccountService accountService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.accountService = accountService;
    }

    //metoda creare account
    @PostMapping("/account/create")
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        if (accountService.acountExists(account.getLogin())) {
            return ResponseEntity.badRequest().build();
        }
        accountService.createAccount(account);
        return ResponseEntity.ok("Account created!");
    }

    @PostMapping("/user/register")
    @CrossOrigin
    public ResponseEntity<Account> registerAccount(@RequestBody @Valid UserRegistrationDTO userDTO) {
        if (accountService.acountExists(userDTO.getLogin())) {
            return ResponseEntity.badRequest().build();
        } else {
            Account account = new Account();
            account.setLogin(userDTO.getLogin());
            account.setPassword(userDTO.getPassword());
            account.setBillingAddress(userDTO.getEmail());
            account.setCreationDate(new Date());
            account.setClosed(false);
            account.setClosedDate(new Date());
            accountService.createAccount(account);

            return ResponseEntity.ok(account);
        }
    }

    @PostMapping("/login")
    @CrossOrigin
    public Boolean login(@RequestBody Account account) {
        UserDetails userDetails = accountService.loadUserByUsername(account.getLogin());
        if (userDetails != null &&
                bCryptPasswordEncoder.matches(
                        account.getPassword(),
                        userDetails.getPassword()))
        {
            return true;
        }

        return false;
    }

    @PostMapping("/user")
    @CrossOrigin
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
        return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
    }
}
