import java.util.LinkedList;

public class Transactions {

    private LinkedList<Transaction> transactions;

    public Transactions(LinkedList<Transaction> transactions){
        this.transactions = transactions;
    }

    public synchronized Transaction getTransaction(){
        return transactions.poll();
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public synchronized boolean isTransactionsEmpty(){
        return transactions.isEmpty();
    }
}
