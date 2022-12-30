
public class Transaction {

    private String accountNumber;
    private int deposit;

    public Transaction(String accountNumber, int deposit){
        this.accountNumber = accountNumber;
        this.deposit = deposit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getDeposit() {
        return deposit;
    }
}
