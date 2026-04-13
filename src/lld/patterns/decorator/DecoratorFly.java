package src.lld.patterns.decorator;

public class DecoratorFly implements Decorator{
    Character ch;

    public DecoratorFly(Character ch){
        this.ch= ch;
    }



    @Override
    public String getAbilities() {
        return ch.getAbilities() + " :fly ability added:";
    }
}
