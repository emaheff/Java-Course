import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Teller extends Thread {
    private TransactionPoll transactionPoll;
    private Map<String,BankAccount> accounts;

    public Teller(ArrayList<BankAccount> accounts, TransactionPoll transactionPoll) {
        this.transactionPoll = transactionPoll;
        this.accounts = new HashMap<>();
        for (BankAccount account: accounts){
            this.accounts.put(account.getAccountNumber(), account);
        }
    }

    @Override
    public void run() {
        super.run();
        while (!transactionPoll.isTransactionsEmpty()) {
            Transaction transaction = transactionPoll.getTransaction();
            if (transaction != null){
                BankAccount account = accounts.get(transaction.getAccountNumber());
                if (account != null){
                    account.transaction(transaction);
                }
            }
            try {
                Thread.sleep((int)(Math.random() * 101));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}