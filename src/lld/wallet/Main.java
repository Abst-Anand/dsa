package src.lld.wallet;

public class Main {

    public static void main(String[] args) {

        Wallet wallet = new Wallet(1000);

        AddMoneyTransaction addMoneyTransaction = new AddMoneyTransaction(500);
        BillPaymentTransaction bpf = new BillPaymentTransaction(200);
        CashbackTransaction cashbackTransaction = new CashbackTransaction(200, 25);

        wallet.applyTrasaction(addMoneyTransaction);
        wallet.applyTrasaction(bpf);
        wallet.applyTrasaction(cashbackTransaction);

    }
}
