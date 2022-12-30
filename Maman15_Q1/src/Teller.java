import java.util.ArrayList;

public class Teller extends Thread {

    private ArrayList<BankAccount> accounts;
    private Transactions transactions;
    private String name;

    public Teller(ArrayList<BankAccount> accounts, Transactions transactions, String name) {
        super();
        this.accounts = accounts;
        this.transactions = transactions;
        this.name = name;
    }

    @Override
    public void run() {
        super.run();
        while (!transactions.isTransactionsEmpty()) {
            Transaction transaction = transactions.getTransaction();
            if (transaction != null){
                String accountNumber = transaction.getAccountNumber();
                int deposit = transaction.getDeposit();
                BankAccount account = getAccount(accountNumber);
                if (account != null){
                    account.transaction(deposit, accountNumber);
                }
            }
        }
    }

    private BankAccount getAccount(String accountNumber) {
        for (BankAccount current : accounts) {
            if (current.getAccountNumber().equals(accountNumber)) {
                return current;
            }
        }
        return null;
    }
}
//while (!transactions.isTransactionsEmpty()){
//        Transaction transaction = transactions.getTransaction();
//        String accountNumber = transaction.getAccountNumber();
//        int deposit = transaction.getDeposit();
//        int index = getIndex(accounts, accountNumber);
//        if (index == -1)
//        return;
//        count++;
//        accounts.get(index).transaction(deposit, accountNumber, count);
////            System.out.println("\nAccount:" + accountNumber + " \nDeposit: " + deposit + "\nBalance: " + accounts.get(index).getBalance());
//        }