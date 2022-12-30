import java.util.ArrayList;
import java.util.LinkedList;

public class Bank {
    private static final int NUM_OF_ACCOUNTS = 5;
    private static final int NUM_OF_TRANSACTIONS = 50;
    private static final int NUM_OF_TELLERS = 10;
    private static ArrayList<BankAccount> accounts = createAccounts();
    private static Transactions transactions = createTransactions();

    private static Transactions createTransactions(){
        LinkedList<Transaction> transactionsList = new LinkedList<>();
        Transactions transactions = new Transactions(transactionsList);
        for (int i = 0; i < NUM_OF_TRANSACTIONS; i++){
            Transaction transaction = new Transaction("" + (int)(Math.random()*5), (int)(Math.random()*2000) - 1000);
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
        Teller[] tellers = new Teller[NUM_OF_TELLERS];
        for (int i = 0; i < NUM_OF_TELLERS; i++){
            tellers[i] = new Teller(accounts, transactions, "" + i);
        }
        return tellers;
    }
    private static void printAccounts(){
        for (BankAccount account : accounts) {
            System.out.println(account);
        }
    }
    private static boolean isFinish(Teller[] tellers){
        for (Teller teller : tellers) {
            if (teller.isAlive()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Teller[] tellers = createTellers();
        printAccounts();
        for (Teller teller: tellers){
            teller.start();
        }
        while (!isFinish(tellers)){

        }
        printAccounts();
    }
}