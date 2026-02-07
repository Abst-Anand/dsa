package src.lecture.lld;

public class SaveToDB {
    private ShoppingCart cart;

    public SaveToDB(ShoppingCart cart) {
        this.cart = cart;
    }

    public void save(){
        //connect to db
        // query to insert
        // execute query
        System.out.println("Saving Products in cart : " + cart.getProductList());
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }
}
