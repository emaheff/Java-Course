
public class BankAccount {

    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public synchronized void transaction(double deposit){
        while ((this.balance + deposit) < 0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.balance += deposit;
        notifyAll();
    }

    public double getBalance(){
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}