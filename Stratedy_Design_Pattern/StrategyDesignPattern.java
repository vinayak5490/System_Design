package Stratedy_Design_Pattern;
import java.util.*;
//Strategy Interface for walk
interface WalkableRobot{
    void walk();
}
//concrete stategies for walk
class NormalWalk implements WalkableRobot{
    public void walk(){
        System.out.println("Walking normally...");
    }
}
class NoWalk implements WalkableRobot{
    public void walk(){
        System.out.println("Cannot Walk.");
    }
}
//strategy interface for talk
interface TalkableRobot{
    void talk();
}

//concrete strategies for talk
class NormalTalk implements TalkableRobot{
    public void talk(){
        System.out.println("Talking normally..");
    }
}
class NoTalk implements TalkableRobot{
    public void talk(){
        System.out.println("Cannot talk.");
    }
}

//strategy interface for fly..
interface FlyableRobot{
    void fly();
}
class NormalFly implements FlyableRobot{
    public void fly(){
        System.out.println("Flying normally..");
    }
}
class Nofly implements FlyableRobot{
    public void fly(){
        System.out.println("Cannot fly.");
    }
}

//robot base class
abstract class Robot{
    protected WalkableRobot walkBehvior;
    protected TalkableRobot talkBehavior;
    protected FlyableRobot flyBehvior;

    public Robot(WalkableRobot w, TalkableRobot t, FlyableRobot f){
        this.walkBehvior = w;
        this.talkBehavior = t;
        this.flyBehvior = f;
    }

    public void walk(){
        walkBehvior.walk();
    }
    public void talk(){
        talkBehavior.talk();
    }
    public void fly(){
        flyBehvior.fly();
    }
    public abstract void projection(); //abstract method for subclasses
}
//concrete Robot Types
class CompanionRobot extends Robot{
    public CompanionRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f){
        super(w, t, f);
    }
    public void projection(){
        System.out.println("Displaying friendly companion features...");
    }
}
class WorkerRobot extends Robot{
    public WorkerRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f){
        super(w, t, f);
    }
    public void projection(){
        System.out.println("Displaying worker efficiency stats...");
    }
}
public class StrategyDesignPattern {
    public static void main(String[] args) {
        Robot robot1 = new CompanionRobot(new NormalWalk(), new NormalTalk(), new Nofly());
        robot1.walk();
        robot1.talk();
        robot1.fly();
        robot1.projection();

        System.out.println("--------");

        Robot robot2 = new WorkerRobot(new NoWalk(), new NoTalk(), new NormalFly());
        robot2.walk();
        robot2.talk();
        robot2.fly();
        robot2.projection();
    }
}
