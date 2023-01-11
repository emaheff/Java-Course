import java.util.ArrayList;
import java.util.LinkedList;

public class Bank {
    private static final int NUM_OF_ACCOUNTS = 5;
    private static final int NUM_OF_TRANSACTIONS = 20;
    private static final int NUM_OF_TELLERS = 10;
    private static final int MAX_DEPOSIT = 1000;
    private ArrayList<BankAccount> accounts = createAccounts();
    private TransactionPoll transactionPoll = createTransactions();

    private ArrayList<BankAccount> createAccounts(){
        ArrayList<BankAccount> accounts = new ArrayList<>();
        for (int i = 0; i < NUM_OF_ACCOUNTS; i++){
            BankAccount account = new BankAccount("" + i, 0);
            accounts.add(account);
        }
        return accounts;
    }

    private TransactionPoll createTransactions(){
        LinkedList<Transaction> transactionsList = new LinkedList<>();
        TransactionPoll transactionPoll = new TransactionPoll(transactionsList);
        for (int i = 0; i < NUM_OF_TRANSACTIONS; i++){
            Transaction transaction = new Transaction("" + (int)(Math.random()*NUM_OF_ACCOUNTS), (int)(Math.random()*(2 * MAX_DEPOSIT)) - MAX_DEPOSIT);
            transactionPoll.addTransaction(transaction);
        }
        return transactionPoll;
    }

    public ArrayList<Teller> createTellers(){
        ArrayList<Teller> tellers = new ArrayList<>();
        for (int i = 0; i < NUM_OF_TELLERS; i++){
            tellers.add(new Teller(accounts, transactionPoll));
        }
        return tellers;
    }
}