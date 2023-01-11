import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        ArrayList<Teller> tellers = bank.createTellers();
        for (Teller teller: tellers){
            teller.start();
        }
    }
}
