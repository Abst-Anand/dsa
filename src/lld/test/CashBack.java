package src.lld.test;

public class CashBack implements Transaction{

    private double amount;
    private double percent;

    public CashBack(double amount, double percent) {
        this.amount = amount;
        this.percent = percent;
    }

    @Override
    public void change(Wallet wallet) {
        System.out.println("Cashback Amount: Rs " + amount);
        System.out.println("Cashback Percent: Rs " + percent);

        double cashbackAmount = amount * percent / 100;

        wallet.changeBalance(-amount);
        wallet.changeBalance(cashbackAmount);
    }
}
