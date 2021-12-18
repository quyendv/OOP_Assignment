package Week14;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";

    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<>();

    public Account() {
    }

    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Withdraw.
     * @param number amount
     * @throws InsufficientFundsException Ex.
     * @throws InvalidFundingAmountException Ex.
     */
    public void doWithdrawing(double number)
            throws InsufficientFundsException, InvalidFundingAmountException {
        if (number < 0) {
            throw new InvalidFundingAmountException(number);
        } else if (number > balance) {
            throw new InsufficientFundsException(number);
        } else {
            balance -= number;
        }
    }

    /**
     * Deposit.
     * @param number amount.
     * @throws InvalidFundingAmountException Ex.
     */
    public void doDepositing(double number) throws InvalidFundingAmountException {
        if (number < 0) {
            throw new InvalidFundingAmountException(number);
        } else {
            balance += number;
        }
    }

    public abstract void withdraw(double number);

    public abstract void deposit(double number);

    /**
     * Print transaction history.
     * @return String
     */
    public String getTransactionHistory() {
        StringBuilder result = new StringBuilder();
        result.append("Lịch sử giao dịch của tài khoản ").append(accountNumber).append(":\n");
        for (Transaction t : transactionList) {
            result.append(t.getTransactionSummary()).append('\n');
        }
        return result.toString();
    }

    /**
     * Add new transaction.
     * @param transaction newT
     */
    public void addTransaction(Transaction transaction) {
        if (transaction != null) {
            transactionList.add(transaction);
        }
    }

    /**
     * Equals method.
     * @param o other
     * @return boolean.
     */
    public boolean equals(Object o) {
        if (!(o instanceof Account)) {
            return false;
        }
        return accountNumber == ((Account) o).getAccountNumber();
    }
}
