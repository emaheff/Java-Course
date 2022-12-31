import java.util.Objects;

public class BankAccount {

    private String accountNumber;
    private int balance;

    public BankAccount(String accountNumber, int balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public synchronized void transaction(Transaction transaction){
        int deposit = transaction.getDeposit();
        String accountNumber = transaction.getAccountNumber();
        while ((getBalance() + deposit) < 0){
            try {
                System.out.println("\nAccount: " + accountNumber + "\nBalance: " + getBalance() + "\nDeposit: " + deposit
                + "\ncan't do this transaction, this account haven't enough money");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int temp = getBalance() + deposit;
        try {
            Thread.sleep((int)(Math.random() * 101));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nAccount: " + accountNumber + "\nBalance: " + getBalance() + "\nDeposit: " + deposit
                + "\nafter deposit balance = " + temp);
        this.balance = temp;
        notifyAll();
    }

    public int getBalance(){
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}