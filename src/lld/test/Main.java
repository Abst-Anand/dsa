package src.lld.test;

public class Main {

    public static void main(String[] args) {
        Wallet wallet = new Wallet(1000);

        BillPayment billPayment = new BillPayment(300, "456465");
        CashBack cashBack = new CashBack(300, 10);

        //1000 700 400 430

        System.out.println(wallet.getBalance());

        wallet.process(billPayment);
        wallet.process(cashBack);

        System.out.println(wallet.getBalance());

        AddMoney addMoney = new AddMoney(500);

        wallet.process(addMoney);
        System.out.println(wallet.getBalance());
    }
}
