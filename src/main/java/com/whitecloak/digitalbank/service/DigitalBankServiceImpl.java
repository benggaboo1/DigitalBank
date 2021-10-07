package com.whitecloak.digitalbank.service;

import com.whitecloak.digitalbank.model.UserAccountEntity;
import com.whitecloak.digitalbank.model.UserAccountResponse;
import com.whitecloak.digitalbank.model.UserEntity;
import com.whitecloak.digitalbank.repository.UserAccountRepository;
import com.whitecloak.digitalbank.repository.UserRepository;
import com.whitecloak.digitalbank.util.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DigitalBankServiceImpl implements DigitalBankService {

    private final UserRepository userRepository;
    private final UserAccountRepository userAccountRepository;

    @Autowired
    public DigitalBankServiceImpl(UserRepository userRepository,
            UserAccountRepository userAccountRepository) {
        this.userRepository = userRepository;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserAccountResponse register(UserEntity newUser) {
        UserEntity newUserEntity = userRepository.save(newUser);
        UserAccountEntity accountEntity = openNewAccount(newUserEntity);
        return new UserAccountResponse(accountEntity.getUserEntity().getId(),
                accountEntity.getAccountNumber(), accountEntity.getBalance());
    }

    @Override
    public UserEntity getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserAccountResponse getAccountDetails(Long accountNumber) {
        UserAccountEntity accountEntity = userAccountRepository.findByAccountNumber(accountNumber);
        return new UserAccountResponse(accountEntity.getUserEntity().getId(),
                accountEntity.getAccountNumber(), accountEntity.getBalance());
    }

    private UserAccountEntity openNewAccount(UserEntity newUserEntity) {
        return saveUserAccount(newUserEntity);
    }

    private UserAccountEntity saveUserAccount(UserEntity newUserEntity) {
        Long accountNumber = null;
        boolean accountExisting = true;

        while (accountExisting) {
            accountNumber = AccountUtils.generateAccountNumber();
            if (userAccountRepository.findByAccountNumber(accountNumber) == null) {
                accountExisting = false;
            }
        }

        return userAccountRepository.save(
                new UserAccountEntity(null, newUserEntity, accountNumber,
                        new BigDecimal(1000)));
    }
}
