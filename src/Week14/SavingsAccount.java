package Week14;

public class SavingsAccount extends Account {
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double number) {
        // chưa đủ: check thêm $1000 && $5000

        try {
            if (balance < 5000) {
                throw new InsufficientFundsException(balance);
            }
            if (number > 1000) {
                throw new InsufficientFundsException(number);
            }
            doWithdrawing(number);
            addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS,
                    number, balance + number, balance));
        } catch (InsufficientFundsException | InvalidFundingAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deposit(double number) {
        try {
            doDepositing(number);
            addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS,
                    number, balance - number, balance));
        } catch (InvalidFundingAmountException e) {
            System.out.println(e.getMessage());
        }
    }
}
