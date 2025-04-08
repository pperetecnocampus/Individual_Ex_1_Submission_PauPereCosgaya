# **Bank Account Management - Individual Project**

## **Overview**
Welcome to the **Bank Account Management** project! In this assignment, you will develop a **simple domain-driven Java application** to manage bank account operations while following proper **Git workflow practices**.

### **Features**
The system should allow users to:
- Create and manage bank accounts.
- Deposit and withdraw money.
- Transfer funds between accounts.
- Retrieve account details.
- Follow Git best practices, including feature branching and pull requests.

---
## **Project Requirements**

### 1. Create a New Bank Account 
**Class:** `BankAccount`

#### Constructor:
```java
BankAccount account = new BankAccount("John Doe", 1000.00);
```
#### Rules:
- A **new account must have a valid owner name**.
- The **initial balance must be non-negative**.
- Each account will have a **unique account number**.

---
### 2. Deposit Money 
**Method:** `deposit(double amount)`

#### Example:
```java
account.deposit(500.00);
```
#### Rules:
- Deposits **must be positive**.
- The balance should be **updated correctly**.

---
### 3. Withdraw Money 
**Method:** `withdraw(double amount)`

#### Example:
```java
account.withdraw(300.00);
```
#### Rules:
- A **withdrawal cannot exceed the account balance**.
- A withdrawal **must be positive**.

---
### 4. Transfer Money Between Accounts 
**Method:** `transfer(BankAccount targetAccount, double amount)`

#### Example:
```java
account1.transfer(account2, 200.00);
```
#### Rules:
- Transfers must be **positive**.
- A transfer cannot **overdraw the sender's account**.

---
### 5. Retrieve Account Information 
**Method:** `getAccountDetails()`

#### Returns:
```json
{
  "accountNumber": "123456",
  "owner": "John Doe",
  "balance": 1000.00
}
```
#### Rules:
- The **account number is unique**.
- The **owner and balance must be correctly displayed**.

---
## Git Requirements 

### **6. Git Workflow**
**Minimum Commits:** Students must make **at least 5 commits** before finalizing their solution.

**Branching:**  
- Create and publish a **feature branch for transferring money** (e.g., `feature/transfer`).
- This branch must be pushed to the remote repository.

**Pull Requests:**  
- The transfer feature branch must be **merged into `main` via a pull request** on GitHub.

---
## **7. Error Handling**
- **IllegalArgumentException** is thrown for:
  - Negative deposits or withdrawals.
  - Transfers exceeding balance.

---
## **8. Submission Guidelines**
- Update your name in student-info.json
- Submit the project via **GitHub**, ensuring the final code is in the **main branch**.

---
## **Git Commands Summary**
```sh
git init
git add .
git commit -m "Initial commit"
git branch feature/transfer
git checkout feature/transfer
git push origin feature/transfer
git checkout main
git merge feature/transfer
git push origin main
```

---
# **Grading Breakdown**

#1. Git Workflow (2 points)

Minimum 5 commits → 1 point

Deduction of -1 point if less than 5 commits.

Feature branch for transfer functionality and PR merge → 1 point

Deduction of -1 point if missing.

#2. Automated Testing (8 points)

JUnit & Cucumber tests pass successfully.

Deduction of -1 point per failed test case (up to -8 points).

