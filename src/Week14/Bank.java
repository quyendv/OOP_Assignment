package Week14;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    /**
     * Read inputStream.
     *
     * @param inputStream text.
     */
    public void readCustomerList(InputStream inputStream) {
        /*
            Nguyễn Thị A 123456789
            1234567890 CHECKING 1000.0
            1234567891 SAVINGS 3000.0
            Lê Hoàng B 123456788
            1234567892 CHECKING 5000.0
            Hoàng Văn C 123456787
        */
        Scanner sc = new Scanner(inputStream);
        String line;
        Customer customer = null;
        while (sc.hasNextLine()) {
            line = sc.nextLine().trim();
            if (Character.isLetter(line.charAt(0))) {   // fullName " " idNumber
                if (customer != null) {
                    customerList.add(customer);   // prev customer
                }

                // new Week14.Customer
                customer = new Customer();

                // String[] split = line.split(" ");
                // StringBuilder fullName = new StringBuilder();
                // for (int i = 0; i < split.length - 1; i++) {
                //     fullName.append(split[i]).append(" ");
                // }
                // customer.setFullName(fullName.toString());
                // customer.setIdNumber(Long.parseLong(split[split.length - 1]));

                customer.setFullName(line.substring(0, line.length() - 10));
                customer.setIdNumber(Long.parseLong(line.substring(line.length() - 9)));
            } else {                    // accountNumber, type, balance
                String[] split = line.split(" ");
                if (split[1].equals(Account.CHECKING)) {
                    if (customer != null) {
                        customer.addAccount(new CheckingAccount(Long.parseLong(split[0]),
                                Double.parseDouble(split[2])));
                    }
                } else if (split[1].equals(Account.SAVINGS)) {
                    if (customer != null) {
                        customer.addAccount(new SavingsAccount(Long.parseLong(split[0]),
                                Double.parseDouble(split[2])));
                    }
                }
            }
        }
        // lastCustomer.
        if (customer != null) {
            customerList.add(customer);
        }
        sc.close();
    }

    /**
     * Return customersList by name order.
     *
     * @return String.
     */
    public String getCustomersInfoByNameOrder() {
        customerList.sort((o1, o2) -> o1.getFullName().compareTo(o2.getFullName()));

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < customerList.size(); i++) {
            Customer c = customerList.get(i);
            if (i == customerList.size() - 1) {
                result.append(c.getCustomerInfo());
            } else {
                result.append(c.getCustomerInfo()).append('\n');
            }
        }
        return result.toString();
    }

    /**
     * Return customersList by idNumber order.
     *
     * @return String.
     */
    public String getCustomersInfoByIdOrder() {
        customerList.sort((o1, o2) -> (int) (o1.getIdNumber() - o2.getIdNumber()));

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < customerList.size(); i++) {
            Customer c = customerList.get(i);
            if (i == customerList.size() - 1) {
                result.append(c.getCustomerInfo());
            } else {
                result.append(c.getCustomerInfo()).append('\n');
            }
        }
        return result.toString();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
