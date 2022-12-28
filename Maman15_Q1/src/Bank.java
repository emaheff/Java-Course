import java.util.ArrayList;
import java.util.LinkedList;

public class Bank {
    private static final int NUM_OF_ACCOUNTS = 5;
    private static final int NUM_OF_TRANSACTIONS = 20;
    private static final int MAX_TELLERS = 10;

    private static Transactions createTransactions(){
        LinkedList<Transaction> transactionsList = new LinkedList<>();
        Transactions transactions = new Transactions(transactionsList);
        for (int i = 0; i < NUM_OF_TRANSACTIONS; i++){
            Transaction transaction = new Transaction("" + (int)(Math.random()*5), (Math.random()*2000) - 1000);
            transactions.addTransaction(transaction);
        }
        return transactions;
    }

    private static ArrayList<BankAccount> createAccounts(){
        ArrayList<BankAccount> accounts = new ArrayList<>();
        for (int i = 0; i < NUM_OF_ACCOUNTS; i++){
            BankAccount account = new BankAccount("" + i, 0);
            accounts.add(account);
        }
        return accounts;
    }
    private static Teller[] createTellers(){
        Teller[] tellers = new Teller[MAX_TELLERS];
        for (int i = 0; i < MAX_TELLERS; i++){
            tellers[i] = new Teller(createAccounts(), createTransactions());
        }
        return tellers;
    }

    public static void main(String[] args) {
        Teller[] tellers = createTellers();
        for (Teller teller: tellers){
            teller.start();
        }
    }
}
