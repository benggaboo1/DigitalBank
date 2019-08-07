package com.whitecloak.digitalbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountResponse {

    @JsonProperty("account_number")
    private Long accountNumber;

    public AccountResponse(Long accountNumber) {
        this.accountNumber = accountNumber;
    }
}