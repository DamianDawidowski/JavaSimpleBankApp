import java.util.ArrayList;
import java.util.Objects;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean addCustomerTransaction(String customerName, double transaction) {
       if (findCustomer(customerName) == null) {
                return false;
       }
       findCustomer(customerName).addTransaction(transaction);
       return true;
   }

    public boolean newCustomer(String customerName, double transaction) {
       Customer customer = new Customer(customerName,transaction);
        if (findCustomer(customerName)==null) {
            customers.add(customer);
            return true;
        }
    return false;
   }

    private Customer findCustomer(String customerName) {
        for(Customer customer : this.customers ) {
            if (Objects.equals(customer.getName(), customerName)) {
                return customer;
            }
        } return null;
    }




}
