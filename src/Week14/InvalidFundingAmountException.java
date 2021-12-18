package Week14;

public class InvalidFundingAmountException extends BankException {
    public InvalidFundingAmountException(double number) {
        super(String.format("Số tiền không hợp lệ: $%+.2f", number));
    }
}
