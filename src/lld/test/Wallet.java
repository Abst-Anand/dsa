package src.lld.test;

public class Wallet {
    private double balance;

    public Wallet(double b){
        balance = b;
    }

    public void process(Transaction transaction){
        transaction.change(this);
    }

    public void changeBalance(double amount){
        balance = balance + amount;
    }

    public double getBalance() {
        return balance;
    }
}
