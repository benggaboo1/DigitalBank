package com.whitecloak.digitalbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "user_accounts")
public class UserAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("user")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @JsonProperty("account_number")
    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "balance")
    private BigDecimal balance;

    public UserAccountEntity(Long id, UserEntity userEntity, Long accountNumber, BigDecimal balance) {
        this.id = id;
        this.userEntity = userEntity;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public UserAccountEntity() {
    }

    public Long getId() {
        return id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
