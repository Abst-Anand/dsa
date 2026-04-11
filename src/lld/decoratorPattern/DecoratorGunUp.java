package src.lld.decoratorPattern;

public class DecoratorGunUp implements Decorator{
    Character ch;

    public DecoratorGunUp(Character ch){
        this.ch= ch;
    }

    @Override
    public String getAbilities() {
        return ch.getAbilities() + " :armed with Gun:";
    }
}
