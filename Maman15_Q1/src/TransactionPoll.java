import java.util.LinkedList;
import java.util.Queue;

public class TransactionPoll {

    private Queue<Transaction> transactions;

    public TransactionPoll(LinkedList<Transaction> transactions){
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
