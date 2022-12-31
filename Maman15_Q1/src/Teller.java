import java.util.ArrayList;

public class Teller extends Thread {

    private ArrayList<BankAccount> accounts;
    private Transactions transactions;

    public Teller(ArrayList<BankAccount> accounts, Transactions transactions) {
        this.accounts = accounts;
        this.transactions = transactions;
    }

    @Override
    public void run() {
        super.run();
        while (!transactions.isTransactionsEmpty()) {
            Transaction transaction = transactions.getTransaction();
            if (transaction != null){
                String accountNumber = transaction.getAccountNumber();
                BankAccount account = getAccount(accountNumber);
                if (account != null){
                    account.transaction(transaction);
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