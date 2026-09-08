package zomato.models;

public class MenuItem {
    private String code;
    private String name;
    private int price;

    public String getCode(){
        return code;
    }
    public void setCode(String c){
        code = c;
    }
    public void setName(String s){
        name = s;
    }
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int p){
       price = p;
    }
}
