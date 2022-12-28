
public class Transaction {

    private String accountNumber;
    private double deposit;

    public Transaction(String accountNumber, double deposit){
        this.accountNumber = accountNumber;
        this.deposit = deposit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getDeposit() {
        return deposit;
    }
}
