package src.lld.examples.discountengine;

public class BuyOneGetOneDiscount implements Discount{

    @Override
    public double delta(double total) {
        return total / 2;
    }
}
