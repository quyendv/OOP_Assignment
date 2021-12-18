package Week14;

public class InsufficientFundsException extends BankException {
    public InsufficientFundsException(double number) {
        super(String.format("Số dư tài khoản không đủ $%.2f để thực hiện giao dịch", number));
    }
}
