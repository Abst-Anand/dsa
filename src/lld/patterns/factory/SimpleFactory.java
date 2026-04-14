package src.lld.patterns.factory;

// Prodcut interface
interface Burger{
    void prepare();
}

// Concrete Products
class BasicBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Preparing basic burger");
    }
}
class StandardBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Preparing standard burger");
    }
}
class PremiumBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Preparing Premium Burger");
    }
}

class BasicWheatBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Preparing basic wheat burger");
    }
}
class StandardWheatBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Preparing standard wheat burger");
    }
}
class PremiumWheatBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Preparing Premium wheat Burger");
    }
}

// Factory class => Responsible to create objects and has-a Product
class BurgerFactory{
    Burger b;
    String type;

    public BurgerFactory(String type){
        this.type = type;
    }

    public Burger createBurger(){
        if("basic".equals(type)){
            return new BasicBurger();
        }

        if("std".equals(type)){
            return new StandardBurger();
        }

        if("pre".equals(type)){
            return new PremiumBurger();
        }

        return null;
    }

}


public class SimpleFactory {

    public static void main(String[] args) {

        // create obj of factory class
        String type = "std";
        BurgerFactory factory = new BurgerFactory(type);

        // get a product object using factory class
        Burger burger = factory.createBurger();

        // use this product object to perform ops
        burger.prepare();
    }
}
