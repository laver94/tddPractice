package com.example.tddpractice.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class AccountServiceTest {

  AccountService accountService;
  int initMoney = 10000;

  @BeforeEach
  void before() {
    accountService = new AccountService(initMoney);
  }

  @Test
  @DisplayName("계좌 생성")
  void 계좌생성() {
    AccountService accountService = new AccountService();
    assertThat(accountService).isNotNull();
  }

  @Test
  @DisplayName("계좌를 생성하며 입금")
  void 계좌생성입금() {
    assertThat(accountService).isNotNull();
  }

  @Test
  @DisplayName("잔고조회")
  void 잔고조회() {
    assertThat(accountService.getBalance()).isEqualTo(initMoney);
  }

  @Test
  @DisplayName("입금")
  void 입금() {
    int depositMoney = 1000;
    accountService.deposit(depositMoney);
    assertThat(accountService.getBalance()).isEqualTo(initMoney + depositMoney);
  }

  @Test
  @DisplayName("출금")
  void 출금() {
    int withdrawMoney = 1000;
    accountService.withdraw(withdrawMoney);
    assertThat(accountService.getBalance()).isEqualTo(initMoney - withdrawMoney);
  }

  @Test
  @DisplayName("잔고보다 많은 돈은 예외")
  void 돈없음() {
    int withdrawMoney = 20000;
    assertThatThrownBy(() -> accountService.withdraw(withdrawMoney))
            .isInstanceOf(RuntimeException.class);
  }
}
