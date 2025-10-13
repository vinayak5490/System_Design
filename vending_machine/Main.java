package vending_machine;

public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        // Add items
        machine.addItem(new Item("Coke", 10, 3));
        machine.addItem(new Item("Pepsi", 15, 2));
        machine.addItem(new Item("Water", 5, 5));

        // Show inventory
        machine.showInventory();

        // Insert coins and select items
        machine.insertCoin(Coin.TEN);
        machine.selectItem("Pepsi");

        machine.insertCoin(Coin.TEN);
        machine.selectItem("Pepsi");

        machine.insertCoin(Coin.FIVE);
        machine.selectItem("Water");

        // Show remaining items
        machine.showInventory();
    }
}
