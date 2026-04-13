package src.lld.patterns.decorator;

public class Main {

    public static void main(String[] args) {

        Character mario = new Mario();
        System.out.println(mario.getAbilities());

        mario = new DecoratorHeightUp(mario);
        System.out.println(mario.getAbilities());

        mario = new DecoratorFly(mario);
        System.out.println(mario.getAbilities());

        mario = new DecoratorGunUp(mario);
        System.out.println(mario.getAbilities());

    }
}
