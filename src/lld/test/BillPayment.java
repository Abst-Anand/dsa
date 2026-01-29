package src.lld.test;

public class BillPayment implements Transaction{
    private double amount;
    private String otp;

    public BillPayment(double amount, String otp) {
        this.amount = amount;
        this.otp = otp;
    }

    @Override
    public void change(Wallet wallet) {
        System.out.println("Bill Payment of Rs: " + amount);
        wallet.changeBalance(-amount);
    }
}
