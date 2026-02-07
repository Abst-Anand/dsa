package src.lld.discountengine;

public class FlatPercentDiscount implements Discount{
    private double percentDiscount;

    public FlatPercentDiscount(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    @Override
    public double delta(double total) {
        return percentDiscount * total / 100;
    }
}
