package src.lld.wallet;

import java.util.ArrayList;

public class Wallet {
    private double balance;
    private ArrayList<Trasaction> trasactionsHistory = new ArrayList<>();

    public Wallet(double balance){
        this.balance = balance;
    }

    public void applyTrasaction(Trasaction trasaction){
        trasaction.apply(this);
        trasactionsHistory.add(trasaction);
    }

    public double getBalance() {
        return balance;
    }

    public void changeBalance(double amount) {
        System.out.println("Before :: " + balance + " :: " + amount);
        this.balance += amount;
        System.out.println("After :: " + balance);
    }

    public ArrayList<Trasaction> getTrasactionsHistory() {
        return trasactionsHistory;
    }

}
