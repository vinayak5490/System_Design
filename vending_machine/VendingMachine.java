package vending_machine;

public class VendingMachine {

    private int currentBalance = 0;
    private MachineState state;
    private Inventory inventory;
    private Item selectedItem;

    public VendingMachine(){
        this.inventory = new Inventory();
        this.state = MachineState.READY;
        }


        public void insertCoin(Coin coin){
            currentBalance += coin.getValue();
            state = MachineState.COIN_INSERTED;
            System.out.println("Inserted coin: ₹" + coin.getValue() + " | Current balance: ₹" + currentBalance);
        }

        public void selectItem(String itemName){
            if(state != MachineState.COIN_INSERTED){
                System.out.println("Insert coin first!");
                return;
            }

            if(!inventory.hasItem(itemName)){
                System.out.println("Item out of stock!");
                return;
            }

            selectedItem = inventory.getItem(itemName);
            if(selectedItem.getPrice() > currentBalance){
                System.out.println("Insufficient balance! please insert more coins.");
                return;
            }
            state = MachineState.DISPENSE;
            dispenceItem();
        }
        private void dispenceItem(){
            if(state != MachineState.DISPENSE){
                System.out.println("No item selected.");
                return;
            }
            selectedItem.reduceQuantity();
            currentBalance -= selectedItem.getPrice();

            System.out.println("Dispensing: " + selectedItem.getName());
            if(currentBalance > 0){
                System.out.println("Returning balance: ₹" + currentBalance);
                refund();
            }
            reset();
        }
        public void refund(){
            currentBalance = 0;
        }
        public void addItem(Item item){
            inventory.addItem(item);
        }

        public void showInventory(){
            inventory.showInventory();
        }
        
        private void reset() {
            state = MachineState.READY;
            selectedItem = null;
            currentBalance = 0;
        }
}
