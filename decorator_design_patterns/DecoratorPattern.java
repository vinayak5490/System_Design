package decorator_design_patterns;

//component Interface: defines a common interface for Mario and all power-up decorators.
interface Character{
    String getAbilities();
}

//concrete component: Basic Mario character with no power-ups.
class Mario implements Character{
    public String getAbilities(){
        return "Mario";
    }
}

//Abstract Decorator: CharacterDecorator "is-a" Character and "has-a" Character.
abstract class CharacterDecorator implements Character{
    protected Character character; //wrapped components

    public CharacterDecorator(Character c){
        this.character = c;
    }
}

// Concrete Decorator: Height-Increasing Power-Up.
class HeightUp extends CharacterDecorator{
    public HeightUp(Character c){
        super(c);
    }

    public String getAbilities(){
        return character.getAbilities() + " with HeightUp";
    }
}

//concrete Decorator: Gun shooting power-up.
class GunPowerUp extends CharacterDecorator{
    public GunPowerUp(Character c){
        super(c);
    }
    public String getAbilities(){
        return character.getAbilities() + " with Gun";
    }
}

//concrete Decorator: Star Power-Up (temporary ability)
class StarPowerUp extends CharacterDecorator{
    public StarPowerUp(Character c){
        super(c);
    }
    public String getAbilities(){
        return character.getAbilities() + " with star power (limited time)";
    }
}
public class DecoratorPattern {
    public static void main(String[] args) {
        //create a basic Mario character.
        Character mario = new Mario();
        System.out.println("Basic Character: " + mario.getAbilities());

        //Decorator Mario with HeightUp power-Up
        mario = new HeightUp(mario);
        System.out.println("After HeightUp: " + mario.getAbilities());

        //Finally, add a StartPowerUp decoration
        mario = new StarPowerUp(mario);
        System.out.println("After StarPowerUp: " + mario.getAbilities());
    }
}
