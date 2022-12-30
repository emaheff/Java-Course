import java.util.Objects;

public class BankAccount {

    private String accountNumber;
    private int balance;

    public BankAccount(String accountNumber, int balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public synchronized void transaction(int deposit, String accountNumber){
        while ((getBalance() + deposit) < 0){
            try {
                System.out.println("\nAccount: " + accountNumber + "\nBalance: " + balance + "\nDeposit: " + deposit
                + "\ncan't do this transaction, this account have no money");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int temp = getBalance();
        temp += deposit;
        try {
            Thread.sleep((int)(Math.random() * 100));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nAccount: " + accountNumber + "\nBalance: " + balance + "\nDeposit: " + deposit + "\nafter deposit balance = " + (balance += deposit));
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