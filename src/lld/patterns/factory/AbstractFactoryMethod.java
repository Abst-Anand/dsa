package src.lld.patterns.factory;

// we have multiple products here and one factory can create multiple products
// additional product
interface GarlicBread{
    void prepare();
}

// concrete products
class BasicGarlicBread implements GarlicBread{

    @Override
    public void prepare() {
        System.out.println("Preparing basic garlic bread");
    }
}
class StandardGarlicBread implements GarlicBread{

    @Override
    public void prepare() {
        System.out.println("Preparing standard garlic bread");
    }
}

class BasicGarlicWheatBread implements GarlicBread{

    @Override
    public void prepare() {
        System.out.println("Preparing basic garlic wheat bread");
    }
}
class StandardGarlicWheatBread implements GarlicBread{

    @Override
    public void prepare() {
        System.out.println("Preparing standard garlic wheat bread");
    }
}

public class AbstractFactoryMethod {

    public static void main(String[] args) {
        IBurgerFactory factory = new KingBurgers("basic", "std");
        Burger burger = factory.createBurger();
        GarlicBread garlicBread = factory.createGarlicBread();

        burger.prepare();
        garlicBread.prepare();
    }
}
