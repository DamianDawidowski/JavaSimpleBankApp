import java.util.ArrayList;
import java.util.Objects;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

   public boolean addBranch(String branchName) {
        for (Branch branch : branches) {
            if (Objects.equals(branch.getName(), branchName)) {
                return false;
            }
        }
        Branch branch = new Branch(branchName);
        branches.add(branch);
        return true;
    }

    public boolean addCustomer(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if (branch!=null) {
            return branch.newCustomer(customerName,transaction);
            }
        return false;
    }

   private Branch findBranch(String branchName) {
        for (Branch branch : this.branches) {
            if (Objects.equals(branch.getName(), branchName)) {
                return branch;
            }
        }
        return null;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        if (findBranch(branchName) != null) {
            for (Customer customer : findBranch(branchName).getCustomers()) {
                if (Objects.equals(customer.getName(), customerName)) {

                    findBranch(branchName).addCustomerTransaction(customerName, transaction);
                    return true;
                }

            }
        }     return false;
    }
    public boolean listCustomers(String branchName, boolean printTransactions) {

        if (findBranch(branchName) != null) {
            System.out.println("Customer details for branch " + findBranch(branchName).getName());
            ArrayList<Customer> customers= findBranch(branchName).getCustomers();
            for (Customer customer:customers) {
                System.out.printf("Customer: %s[%d]%n", customer.getName(),customers.indexOf(customer)+1);
if(printTransactions) {
    System.out.println("Transactions");
    for(Double transaction: customer.getTransactions()) {
        System.out.printf("[%d]  Amount %s%n", customer.getTransactions().indexOf(transaction)+1, transaction.toString());
    }
}
            }
            return true;
        }
        return false;

    }
}