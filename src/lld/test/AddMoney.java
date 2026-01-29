package src.lld.test;

public class AddMoney implements Transaction{
    private double amount;

    public AddMoney(double amount) {
        this.amount = amount;
    }

    @Override
    public void change(Wallet wallet) {
        System.out.println("Adding Money: Rs" + amount);
        wallet.changeBalance(amount);
    }
}
