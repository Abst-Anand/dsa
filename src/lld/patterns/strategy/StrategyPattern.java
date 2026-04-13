package src.lld.patterns.strategy;


// Ability Interfaces -> What abilities a robot can have
interface Walkable{
    void walk();
}
class NormalWalk implements Walkable{

    @Override
    public void walk() {
        System.out.println("I am walking");
    }
}
class NoWalk implements Walkable{

    @Override
    public void walk() {
        System.out.println("Cannot walk");
    }
}

interface Talkable{
    void talk();
}
class NormalTalk implements Talkable{

    @Override
    public void talk() {
        System.out.println("i can talk");
    }
}
class NoTalk implements Talkable{

    @Override
    public void talk() {
        System.out.println("cannot talk");
    }
}

interface Flyable{
    void fly();
}
class NormalFly implements Flyable{

    @Override
    public void fly() {
        System.out.println("i can fly");
    }
}
class NoFly implements Flyable{

    @Override
    public void fly() {
        System.out.println("cannot fly");
    }
}

// Base Abstract class for Robot
abstract class Robot{
    private Talkable talkBehaviour;
    private Walkable walkBehaviour;
    private Flyable flyBehaviour;

    // this constructor can make the behaviour in any order we want
    public Robot(Talkable t, Walkable w, Flyable f){
        this.talkBehaviour = t;
        this.walkBehaviour = w;
        this.flyBehaviour = f;
    }

    public void walk(){
        walkBehaviour.walk();
    }

    public void talk(){
        talkBehaviour.talk();
    }

    public void fly(){
        flyBehaviour.fly();
    }

    abstract void projection();
}

// creating actual Robots
class CompanionRobot extends Robot{

    public CompanionRobot(Talkable t, Walkable w, Flyable f){
        super(t, w, f);
    }

    @Override
    void projection() {
        System.out.println("displaying friendly companion robot features");
    }
}

class WorkerRobot extends Robot{

    public WorkerRobot(Talkable t, Walkable w, Flyable f){
        super(t, w, f);
    }

    @Override
    void projection() {
        System.out.println("displaying worker efficiency stats..");
    }

}

public class StrategyPattern {

    public static void main(String[] args) {
        Robot companionRobot = new CompanionRobot(new NormalTalk(), new NormalWalk(), new NoFly());
        companionRobot.walk();
        companionRobot.talk();
        companionRobot.fly();

        System.out.println("==============================================");

        Robot worker = new WorkerRobot(new NoTalk(), new NormalWalk(), new NormalFly());
        worker.walk();
        worker.talk();
        worker.fly();
    }

}
