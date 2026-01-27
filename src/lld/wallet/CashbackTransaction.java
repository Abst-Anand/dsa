package src.lld.wallet;

public class CashbackTransaction implements Trasaction{
    private double purchaseAmount;
    private double percent;

    public CashbackTransaction(double purchaseAmount, double percent){
        this.purchaseAmount = purchaseAmount;
        this.percent = percent;
    }

    @Override
    public void apply(Wallet wallet) {
        double cashbackAmount = percent * purchaseAmount / 100;
        wallet.changeBalance(cashbackAmount);
    }
}
