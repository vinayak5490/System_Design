package Stratedy_Design_Pattern.Factory_Design_Pattern;

import java.util.concurrent.PriorityBlockingQueue;

//Burger Interface
interface Burger{
    void prepare();
}

//concrete burger implementations
class BasicBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("Preparing Basic Burger with bun, patty, and ketchup!");
    }
}

class StandardBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("Preparing Standard Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("Preparing Premium Burger with gourmet bun, premium patty, cheese, lettuce and secret sauce!");
    }
}

//Burger Factory
class BurgerFactory{
    public Burger creatBurger(String type){
        if(type.equalsIgnoreCase("basic")){
            return new BasicBurger();
        }else if(type.equalsIgnoreCase("standard")){
            return new StandardBurger();
        }else if(type.equalsIgnoreCase("premium")){
            return new PremiumBurger();
        }else{
            System.out.println("Invalid burger type!");
            return null;
        }
    }
}
public class SimpleFactory {
    public static void main(String[] args) {
        String type = "standard";
        BurgerFactory myBurgerFactory = new BurgerFactory();

        Burger burger = myBurgerFactory.creatBurger(type);

        if(burger != null){
            burger.prepare();
        }
    }
}
