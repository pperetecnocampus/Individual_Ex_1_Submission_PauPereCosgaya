Feature: Bank Account Management

  Scenario: Creating a new bank account successfully
    Given a user wants to open a new bank account
    When they provide the owner name "John Doe" and an initial balance of 1000
    Then the bank account is created with a unique account ID
    And the account balance should be 1000

  Scenario: Creating a bank account with an empty owner name
    Given a user wants to open a new bank account
    When they provide an empty owner name and an initial balance of 1000
    Then the account creation should be declined with an error message "Owner name is required."

  Scenario: Creating a bank account with a negative initial balance
    Given a user wants to open a new bank account
    When they provide the owner name "John Doe" and an initial balance of -100
    Then the account creation should be declined with an error message "Initial balance cannot be negative."

  Scenario: Depositing money into an account
    Given a bank account with owner "John Doe" and balance 1000
    When the user deposits 500
    Then the new balance should be 1500

  Scenario: Depositing a negative amount
    Given a bank account with owner "John Doe" and balance 1000
    When the user tries to deposit -100
    Then the deposit should be declined with an error message "Deposit amount must be positive."

  Scenario: Withdrawing money from an account successfully
    Given a bank account with owner "John Doe" and balance 1000
    When the user withdraws 200
    Then the new balance should be 800

  Scenario: Attempting to withdraw more than available balance
    Given a bank account with owner "John Doe" and balance 1000
    When the user tries to withdraw 1200
    Then the withdrawal should be declined with an error message "Insufficient funds."

  Scenario: Withdrawing a negative amount
    Given a bank account with owner "John Doe" and balance 1000
    When the user tries to withdraw -50
    Then the withdrawal should be declined with an error message "Withdrawal amount must be positive."

  Scenario: Transferring money between two accounts
    Given two bank accounts with balances 1000 and 500
    When the first account transfers 300 to the second account
    Then the first account's balance should be 700
    And the second account's balance should be 800

  Scenario: Transferring a negative amount between accounts
    Given two bank accounts with balances 1000 and 500
    When the first account tries to transfer -200 to the second account
    Then the transfer should be declined with an error message "Withdrawal amount must be positive."

  Scenario: Transferring money to the same account
    Given a bank account with owner "John Doe" and balance 1000
    When the user tries to transfer 100 to the same account
    Then the transfer should be declined with an error message "Cannot transfer money to the same account."

