package src.lld.test;

public class Test {
    private double balance;

    public Test(double _b){
        balance = _b;
    }

    public void changeBalance(double amount){
        balance = balance + amount;
    }

    public static void main(String[] args) {

        Test wallet = new Test(1000);

        // Upi, Cashback, Bill Payment
        // Upi(200), BillPayment(300), Cashback(400, 5)
        String txns = "Upi";
        double amount = 200;
        int percent = 5;

        if(txns == "Upi"){
            wallet.changeBalance(-amount);
        } else if (txns == "BillPayment") {
            wallet.changeBalance(-amount);
        } else if (txns == "Cashback") {
            wallet.changeBalance(-amount);
            double amt = amount * percent / 100;
            wallet.changeBalance(amt);
        }

        // addMoneyToWallet(500)

        //Principal : Open-Closed Principal -> Open for extension, closed for modification

        // steps:
        /*

            What actually changes when this happens?

            What is common across all the variants?

            Can the core logic work without knowing the exact type?

            What question should one object ask another instead of using if/else?

            Who should own this decision or behavior?

            What is most likely to change or grow in the future?

            What is the smallest contract (interface) I can define?

            Can my core class be dumb and still correct?
        *
        * */




    }
}
