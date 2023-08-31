package com.example.tddpractice.service;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AccountService {

  private int balance;

  public AccountService(int money) {
    this.balance = money;
  }

  public int getBalance() {
    return this.balance;
  }

  public void deposit(int depositMoney) {
    this.balance += depositMoney;
  }

  public void withdraw(int withdrawMoney) {
    if (this.balance < withdrawMoney) {
      throw new RuntimeException();
    }
    this.balance -= withdrawMoney;
  }
}
