package Week14;

public class CheckingAccount extends Account {
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double number) {
        try {
            doWithdrawing(number);
            this.addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_CHECKING,
                    number, balance + number, balance));
        } catch (InsufficientFundsException | InvalidFundingAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deposit(double number) {
        try {
            doDepositing(number);
            this.addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_CHECKING,
                    number, balance - number, balance));
        } catch (InvalidFundingAmountException e) {
            System.out.println(e.getMessage());
        }
    }
}
