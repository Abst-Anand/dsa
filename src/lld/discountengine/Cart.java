package src.lld.discountengine;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private double cartTotal;
    private List<Discount> discounts;

    public Cart(double cartTotal) {
        this.cartTotal = cartTotal;
        discounts = new ArrayList<>();
    }

    public double applyDiscount(){
        double runningTotal = cartTotal;
        for (Discount d : discounts){
            double del = d.delta(runningTotal);
            runningTotal -= del;
        }
        return runningTotal;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(double cartTotal) {
        this.cartTotal = cartTotal;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }
}
