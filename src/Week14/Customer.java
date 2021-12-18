package Week14;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accountList = new ArrayList<>();

    public Customer() {
    }

    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    public String getCustomerInfo() {
        return String.format("Số CMND: %d. Họ tên: %s.",
                idNumber, fullName);
    }

    /**
     * Add new Week14.Account.
     * @param account newA.
     */
    public void addAccount(Account account) {
        if (account != null) {
            accountList.add(account);
        }

    }

    /**
     * Remove an account.
     * @param account oldA
     */
    public void removeAccount(Account account) {
        if (account != null) {
            accountList.remove(account);
        }
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
