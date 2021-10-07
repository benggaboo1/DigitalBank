package com.whitecloak.digitalbank.service;

import com.whitecloak.digitalbank.model.UserAccountResponse;
import com.whitecloak.digitalbank.model.UserEntity;

public interface DigitalBankService {
    UserAccountResponse register(UserEntity newUser);
    UserEntity getUser(Long id);
    UserAccountResponse getAccountDetails(Long accountNumber);
}
