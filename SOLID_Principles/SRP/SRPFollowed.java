package SOLID_Principles.SRP;
import java.util.*;
class Product{
    public String name;
    public double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }
}

class shoppingCart{
    private List<Product> products = new ArrayList<>();
    public void addProduct(Product p){
        products.add(p);
    }
    public List<Product> getProducts(){
        return products;
    }

    //calculate total price in cart
    public double calculateTotal(){
        double total = 0;
        for(Product p : products){
            total += p.price;
        }
        return total;
    }
}

//2. shopping cart printer: only responsible for printing invoices
class ShoppingCartPrinter{
    private ShoppingCart cart;
    public ShoppingCartPrinter(ShoppingCart cart){
        this.cart = cart;
    }
    public void printInvoice(){
        System.out.println("Shopping Cart Invoice");
        for(Product p : cart.getProducts()){
            System.out.println(p.name+ "- Rs " + p.price);
        }
        System.out.println("Total: Rs " + cart.calculateTotal());
    }
}


//3. shoppingCartStorage: only responsible for saving cart to DB
class shoppingCartStorage{
    private ShoppingCart cart;
    public shoppingCartStorage(ShoppingCart cart){
        this.cart = cart;
    }
    public void saveToDatabase(){
        System.out.println("Saving shopping cart to database...");
    }
}
public class SRPFollowed {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Laptop", 5000));
        cart.addProduct(new Product("Mouse", 2000));

        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart);
        printer.printInvoice();

        shoppingCartStorage db = new shoppingCartStorage(cart);
        db.saveToDatabase();
    }
}
