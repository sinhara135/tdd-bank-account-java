package org.xpdojo.bank;

public class Account {
    Double balance;

    public Account(Double initialDeposit) {
        this.balance = initialDeposit;
    }

    public Account() {
        this.balance = 0.0;
    }

    public Double getBalance() {
        return balance;
    }

    public void deposit(Double amount) {
        balance += amount;
    }

    public void withdraw(Double amount) throws Exception {

        if (balance < amount) {
            throw new Exception("Not enough balance");
        } else {
            balance -= amount;
        }
    }
}
