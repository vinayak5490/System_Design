package notification;

public class NotificationFactory {

    public static Notification createNotification(String type) {

        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();

        } else if (type.equalsIgnoreCase("SMS")) {
            return new SmsNotification();

        } else if (type.equalsIgnoreCase("WHATSAPP")) {
            return new WhatsAppNotification();
        }

        throw new IllegalArgumentException(
                "Unknown notification type: " + type);
    }
}