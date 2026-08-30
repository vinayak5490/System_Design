package notification;

public class Main {
    public static void main(String[] args) {
        Notification notification = NotificationFactory.createNotification("EMAIL");

        notification.send("Your order has been shipped!");
    }
}
