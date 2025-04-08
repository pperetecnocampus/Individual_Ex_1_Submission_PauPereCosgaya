package com.tecnocampus.bank.steps;

import com.tecnocampus.bank.BankAccount;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class BankAccountSteps {


    private BankAccount account;
    private BankAccount secondAccount;
    private String errorMessage;

    @Given("a user wants to open a new bank account")
    public void aUserWantsToOpenANewBankAccount() {
        account = null;
        secondAccount = null;
        errorMessage = null;
    }

    @When("they provide the owner name {string} and an initial balance of {double}")
    public void theyProvideTheOwnerNameAndAnInitialBalanceOf(String owner, double initialBalance) {
        try {
            account = new BankAccount(owner, initialBalance);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("the bank account is created with a unique account ID")
    public void theBankAccountIsCreatedWithAUniqueAccountID() {
        Assertions.assertNotNull(account);
        Assertions.assertNotNull(account.getAccountId());
    }

    @Then("the account balance should be {double}")
    public void theAccountBalanceShouldBe(double balance) {
        Assertions.assertEquals(balance, account.getBalance());
    }

    @Then("the account creation should be declined with an error message {string}")
    public void theAccountCreationShouldBeDeclinedWithAnErrorMessage(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, errorMessage);
    }

    @Given("a bank account with owner {string} and balance {double}")
    public void aBankAccountWithOwnerAndBalance(String owner, double balance) {
        account = new BankAccount(owner, balance);
    }

    @When("the user deposits {double}")
    public void theUserDeposits(double amount) {
        account.deposit(amount);
    }

    @When("the user tries to deposit {double}")
    public void theUserTriesToDeposit(double amount) {
        try {
            account.deposit(amount);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
    }

    @When("the user withdraws {double}")
    public void theUserWithdraws(double amount) {
        account.withdraw(amount);
    }

    @When("the user tries to withdraw {double}")
    public void theUserTriesToWithdraw(double amount) {
        try {
            account.withdraw(amount);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("the withdrawal should be declined with an error message {string}")
    public void theWithdrawalShouldBeDeclinedWithAnErrorMessage(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, errorMessage);
    }

    @Given("two bank accounts with balances {double} and {double}")
    public void twoBankAccountsWithBalances(double balance1, double balance2) {
        account = new BankAccount("Account 1", balance1);
        secondAccount = new BankAccount("Account 2", balance2);
    }

    @When("they provide an empty owner name and an initial balance of {int}")
    public void they_provide_an_empty_owner_name_and_an_initial_balance_of(Integer initialBalance) {
        try {
            account = new BankAccount("", initialBalance);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("the new balance should be {double}")
    public void the_new_balance_should_be(Double value) {
        Assertions.assertEquals(value, account.getBalance());
    }

    @When("the first account transfers {double} to the second account")
    public void theFirstAccountTransfersToTheSecondAccount(double amount) {
        account.transfer(secondAccount, amount);
    }

    @Then("the deposit should be declined with an error message {string}")
    public void the_deposit_should_be_declined_with_an_error_message(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, errorMessage);
    }

    @When("the first account tries to transfer {double} to the second account")
    public void theFirstAccountTriesToTransferToTheSecondAccount(double amount) {
        try {
            account.transfer(secondAccount, amount);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
    }

    @When("the user tries to transfer {double} to the same account")
    public void theUserTriesToTransferToTheSameAccount(double amount) {
        try {
            account.transfer(account, amount);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("the transfer should be declined with an error message {string}")
    public void theTransferShouldBeDeclinedWithAnErrorMessage(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, errorMessage);
    }

    @Then("the first account's balance should be {double}")
    public void theFirstAccountSBalanceShouldBe(double expectedBalance) {
        Assertions.assertEquals(expectedBalance, account.getBalance());
    }

    @Then("the second account's balance should be {double}")
    public void theSecondAccountSBalanceShouldBe(double expectedBalance) {
        Assertions.assertEquals(expectedBalance, secondAccount.getBalance());
    }
}


