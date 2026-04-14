package src.lld.patterns.factory;

// here in addition to SimpleFactory, we add abstraction in Factory side as well
interface IBurgerFactory{
    Burger createBurger();
    GarlicBread createGarlicBread();
}

class SinghBurgers implements IBurgerFactory{
    private String burgerType;
    private String breadType;

    public SinghBurgers(String burgerType){
        this.burgerType = burgerType;
    }
    public SinghBurgers(String burgerType, String breadType){
        this.burgerType = burgerType;
        this.breadType = breadType;
    }

    @Override
    public Burger createBurger(){
        if("basic".equals(burgerType)){
            return new BasicBurger();
        }

        if("std".equals(burgerType)){
            return new StandardBurger();
        }

        if("pre".equals(burgerType)){
            return new PremiumBurger();
        }

        return null;
    }

    @Override
    public GarlicBread createGarlicBread() {
        if("basic".equals(breadType)){
            return new BasicGarlicBread();
        }

        if("std".equals(breadType)){
            return new StandardGarlicBread();
        }
       return null;
    }

}
class KingBurgers implements IBurgerFactory{
    private String burgerType;
    private String breadType;

    public KingBurgers(String burgerType){
        this.burgerType = burgerType;
    }

    public KingBurgers(String burgerType, String breadType){
        this.burgerType = burgerType;
        this.breadType = breadType;
    }

    @Override
    public Burger createBurger(){
        if("basic".equals(burgerType)){
            return new BasicWheatBurger();
        }

        if("std".equals(burgerType)){
            return new StandardWheatBurger();
        }

        if("pre".equals(burgerType)){
            return new PremiumWheatBurger();
        }

        return null;
    }

    @Override
    public GarlicBread createGarlicBread() {
        if("basic".equals(breadType)){
            return new BasicGarlicWheatBread();
        }

        if("std".equals(breadType)){
            return new StandardGarlicWheatBread();
        }
        return null;
    }

}

public class FactoryMethod {
    public static void main(String[] args) {

        IBurgerFactory factory = new SinghBurgers("basic");
        IBurgerFactory factory1 = new KingBurgers("basic");

        Burger burger = factory.createBurger();
        Burger burger1 = factory1.createBurger();

        burger.prepare();
        burger1.prepare();

    }
}
