package Week4;

import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     * Nap tien.
     *
     * @param amount so tien can dat coc
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        balance += amount;
        Transaction t = new Transaction(Transaction.DEPOSIT, amount, balance);
        transitionList.add(t);
    }

    /**
     * Rut tien.
     *
     * @param amount so tien can rut
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        balance -= amount;
        Transaction t = new Transaction(Transaction.WITHDRAW, amount, balance);
        transitionList.add(t);
    }

    /**
     * Thuc hien giao dich.
     *
     * @param amount    so tien
     * @param operation kieu giao dich
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * in ket qua theo yeu cau.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            System.out.printf("Giao dich %d: %s $%.2f. So du luc nay: $%.2f.%n",
                    i + 1, transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)
                            ? "Nap tien" : "Rut tien",
                    transitionList.get(i).getAmount(), transitionList.get(i).getBalance());
        }
    }
}
