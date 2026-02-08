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

// TODO
/*
*
Caps

“Max discount ₹200 — where does that logic go?”

✔️ Inside the discount implementation.

Eligibility

“Discount only applies if cart > ₹1000?”

✔️ Discount returns zero delta.

Stacking rules

“Some discounts don’t combine.”

✔️ Discount engine / pipeline layer, not Cart.
* */