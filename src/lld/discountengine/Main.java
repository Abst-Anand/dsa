package src.lld.discountengine;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Cart cart = new Cart(1000);
        FlatPercentDiscount percentDiscount = new FlatPercentDiscount(10);
        BuyOneGetOneDiscount buyOneGetOneDiscount = new BuyOneGetOneDiscount();

        cart.setDiscounts(List.of(percentDiscount, buyOneGetOneDiscount));

        double netCheckoutAmount = cart.applyDiscount();
        System.out.println(netCheckoutAmount);
    }
}
