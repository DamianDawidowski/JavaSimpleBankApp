public class main {
    public static void main(String[] args) {
        Bank bank = new Bank("PKO");

        bank.addBranch("PKO: Main Branch");
        bank.addBranch("PKO: VIP");
        bank.addCustomer("PKO: Main Branch", "Damian", 50.05);
        bank.addCustomer("PKO: Main Branch", "Dawid", 175.34);
        bank.addCustomer("PKO: Main Branch", "Dariusz", 220.12);

        bank.addCustomerTransaction("PKO: Main Branch", "Damian", 44.22);
        bank.addCustomerTransaction("PKO: Main Branch", "Damian", 12.44);
        bank.addCustomerTransaction("PKO: Main Branch", "Dariusz", 1.65);

        bank.listCustomers("PKO: Main Branch", true);
    }
}
