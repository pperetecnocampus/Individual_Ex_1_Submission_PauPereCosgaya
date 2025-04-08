package com.tecnocampus.bank;

public class BankAccount {
    private static int nextId = 1;
    private final String accountId;
    private final String owner;
    private double balance;

    public BankAccount(String owner, double initialBalance) {
        if (owner == null || owner.trim().isEmpty()) {
            throw new IllegalArgumentException("Owner name must be valid.");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.owner = owner;
        this.balance = initialBalance;
        this.accountId = String.valueOf(nextId++);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Withdrawal exceeds balance.");
        }
        this.balance -= amount;
    }

    public void transfer(BankAccount targetAccount, double amount) {

    }

    public String getAccountId() {
        return "";
    }

    public String getOwner() {
        return "";
    }

    public double getBalance() {
        return 0;
    }
}
