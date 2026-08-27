/**
 * singledesignPattern
 */
public class singledesignPattern {
    static class Singleton{//Singleton class
        private static Singleton instance;
        private Singleton(){

        }
        public static Singleton getInstance(){
            if(instance == null){// avoids synchronization when object already exsist
                //not created yet
                synchronized(Singleton.class){
                    if(instance == null){
                        instance = new Singleton(); // lazy initialization :- initialize the instance only when required
                    }
                }
            }
            return instance;
        }
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
    
}