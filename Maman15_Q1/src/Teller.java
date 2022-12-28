import java.util.ArrayList;

public class Teller extends Thread {

    private ArrayList<BankAccount> accounts;
    private Transactions transactions;

    public Teller(ArrayList<BankAccount> accounts, Transactions transactions){
        super();
        this.accounts = accounts;
        this.transactions = transactions;
    }

    @Override
    public void run() {
        super.run();
        while (transactions.transactions.pop() != null){
            Transaction transaction = transactions.getTransaction();
            String accountNumber = transaction.getAccountNumber();
            double deposit = transaction.getDeposit();
            int index = getIndex(accounts, accountNumber);
            accounts.get(index).transaction(deposit);
            System.out.println("\nAccount:" + accountNumber + " \nDeposit: " + deposit + "\nBalance: " + accounts.get(index).getBalance());
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private int getIndex(ArrayList<BankAccount> accounts, String accountNumber){
        for (int i = 0; i < accounts.size(); i++){
            if (accounts.get(i).getAccountNumber().equals(accountNumber)){
                return i;
            }
        }
        return -1;
    }
}