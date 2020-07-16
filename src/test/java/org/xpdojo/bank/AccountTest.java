package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {

    @Test
    public void openAccountWithInitialBalance() {
        Account account = new Account(100.0);
        assertThat(account.getBalance()).isEqualTo(100.0);
    }

    @Test
    public void openAccountWithNoInitialBalance() {
        Account account = new Account();
        assertThat(account.getBalance()).isEqualTo(0.0);
    }

    @Test
    public void depositAnAmountToIncreaseTheBalance() {
        Account account = new Account();
        account.deposit(100.0);
        assertThat(account.getBalance()).isEqualTo(100.0);
    }

    @Test
    public void withdrawAnAmountToDecreaseTheBalance() {
        Account account = new Account(100.0);
        account.deposit(50.0);
        assertThat(account.getBalance()).isEqualTo(150.0);
    }

    @Test
    public void notEnoughBalanceToWithdraw() {
        Account account = new Account(100.0);
        Exception exception = assertThrows(Exception.class, () -> account.withdraw(120.0));
        assertTrue(exception.getMessage().contains("Not enough balance"));
    }

}
