package src.lecture.lld;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> productList;

    // 1. calculateTotalPrice()
    // 2. printInvoice()
    // 3. saveToDB()

    public ShoppingCart() {
        this.productList = new ArrayList<>();
    }

    public double calculateTotalPrice(){
        double total = 0.0;

        for(Product p : productList){
            total = total + p.getPrice();
        }
        //productList.stream().forEach(product -> total = total + product.getPrice());
        System.out.println("Total Price: " + total);
        return total;
    }


    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
