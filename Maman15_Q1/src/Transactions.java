import java.util.LinkedList;

public class Transactions {

    LinkedList<Transaction> transactions;

    public Transactions(LinkedList<Transaction> transactions){
        this.transactions = transactions;
    }

    public Transaction getTransaction(){
        return transactions.poll();
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
}
