package src.lld.wallet;

public class AddMoneyTransaction implements Trasaction{
    private double amount;

    public AddMoneyTransaction(double amount){
        this.amount = amount;
    }

    @Override
    public void apply(Wallet wallet) {
        wallet.changeBalance(amount);
    }
}
