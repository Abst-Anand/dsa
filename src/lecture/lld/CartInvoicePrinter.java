package src.lecture.lld;

public class CartInvoicePrinter {

    private ShoppingCart cart;

    public CartInvoicePrinter(ShoppingCart cart) {
        this.cart = cart;
    }

    public void printInvoice(){
        System.out.println("Invoive for cart ::");
        for (Product p : cart.getProductList()){
            System.out.println(p.getName() + " : " + p.getPrice());
        }
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }
}
