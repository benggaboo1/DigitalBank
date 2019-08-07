package com.whitecloak.digitalbank.controller;

import com.whitecloak.digitalbank.model.AccountResponse;
import com.whitecloak.digitalbank.model.UserAccountEntity;
import com.whitecloak.digitalbank.model.UserEntity;
import com.whitecloak.digitalbank.service.DigitalBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bank")
public class DigitalBankController {

    private DigitalBankService digitalBankService;

    @Autowired
    public DigitalBankController(DigitalBankService digitalBankService) {
        this.digitalBankService = digitalBankService;
    }

    @PostMapping("/user-account")
    public AccountResponse register(@RequestBody UserEntity newUser) {
        return new AccountResponse(digitalBankService.register(newUser).getAccountNumber());
    }
}
