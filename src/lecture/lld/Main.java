package src.lecture.lld;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Product pdt1 = new Product("Laptop", 45000);
        Product pdt2 = new Product("Mobile", 5000);
        Product pdt3 = new Product("Gaming Console", 9000);

        List<Product> pdtList = new ArrayList<>();

        pdtList.add(pdt1);
        pdtList.add(pdt2);
        pdtList.add(pdt3);

        cart.setProductList(pdtList);

        cart.calculateTotalPrice();

        CartInvoicePrinter invoicePrinter = new CartInvoicePrinter(cart);
        SaveToDB saveToDB = new SaveToDB(cart);

        invoicePrinter.printInvoice();
        saveToDB.save();


    }
}
