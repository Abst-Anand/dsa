package src.lld.wallet;

public class BillPaymentTransaction implements Trasaction{
    private double amount;

    public BillPaymentTransaction(double amount){
        this.amount = amount;
    }

    @Override
    public void apply(Wallet wallet){
        wallet.changeBalance(-amount);
    }
}
