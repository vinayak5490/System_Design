package notification;

public class WhatsAppNotification implements Notification{
    @Override
    public void send(String message){
        System.out.println("Sending Whatsapp message:" + message);
    }
}
