package com.whitecloak.digitalbank.service;

import com.whitecloak.digitalbank.model.UserAccountEntity;
import com.whitecloak.digitalbank.model.UserEntity;

public interface DigitalBankService {
    UserAccountEntity register(UserEntity newUser);
    UserEntity getUser(Long id);
}
