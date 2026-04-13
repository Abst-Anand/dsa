package src.lld.patterns.decorator;

public class DecoratorHeightUp implements Decorator{
    Character ch;

    public DecoratorHeightUp(Character ch){
        this.ch= ch;
    }

    @Override
    public String getAbilities() {
        String res = ch.getAbilities();
        return res + " :heighUp Ability added:";
    }
}
