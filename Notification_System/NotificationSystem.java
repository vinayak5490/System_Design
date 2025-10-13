import java.util.*;

interface INotification{
    String getContent();
}
//concrete Notification: simple text notification
class SimplNotification implements INotification{
    private String text;

    public SimplNotification(String msg){
        this.text = msg;
    }
    public String getContent(){
        return text;
    }
}
// Abstract Decorator: wraps a Notification objects.
abstract class INotificationDecorator implements INotification{
    protected INotification notification;

    public INotificationDecorator(INotification n){
        this.notification = n;
    }
}

//Decorator to add a timestamp to the content.
class TimestampDecorator extends INotificationDecorator{
    public TimestampDecorator(INotification n){
        super(n);
    }
    public String getContent(){
        return "[2025-04-13 14:22:00] " + notification.getContent();
    }
}

//Decorator to append a signature to the content.
class SignatureDecorator extends INotificationDecorator{
    private String signature;

    public SignatureDecorator(INotification n, String sig){
        super(n);
        this.signature = sig;
    }
    public String getContent(){
        return notification.getContent() + "\n-- " + signature + "\n\n";
    }
}

//oberserver Pattern components

interface IObserver{
    void update();
}

interface IObservable{
    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers();
}

class NotificationObservable implements IObservable{
    private List<IObserver> observers = new ArrayList<>();
    private INotification currentNotification;

    public void addObserver(IObserver obs){
        observers.add(obs);
    }
    public void removeObserver(IObserver obs){
        observers.remove(obs);
    }
    public void notifyObservers(){
        for(IObserver observer : observers){
            observer.update();
        }
    }
    public void setNotification(INotification notification){
        this.currentNotification = notification;
        notifyObservers();
    }
    public INotification getNotification(){
        return currentNotification;
    }
    public String getNotificationContent(){
        return currentNotification.getContent();
    }
}

//concrete observer 1
class Logger implements IObserver {
    private NotificationObservable notificationObservable;

    public Logger(NotificationObservable observable){
        this.notificationObservable = observable;
    }
    public void update(){
        System.out.println("Logging New Notification : \n" + notificationObservable.getNotificationContent());
    }
}

interface INotificationStrategy{
    void sendNotification(String content);
}

class EmailStrategy implements INotificationStrategy{
    private String emailId;
    public EmailStrategy(String emailId){
        this.emailId = emailId;
    }
    public void sendNotification(String content){
        System.out.println("Sending email Notification to: " + emailId + "\n" + content);
    }
}

class SMSStrategy implements INotificationStrategy {
    private String mobileNumber;

    public SMSStrategy(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void sendNotification(String content) {
        System.out.println("Sending SMS Notification to: " + mobileNumber + "\n" + content);
    }
}

class PopUpStrategy implements INotificationStrategy {
    public void sendNotification(String content) {
        System.out.println("Sending Popup Notification: \n" + content);
    }
}

class NotificationEngine implements IObserver{
    private NotificationObservable notificationObservable;
    private List<INotificationStrategy> notificationStrategies = new ArrayList<>();

    public NotificationEngine(NotificationObservable observable){
        this.notificationObservable = observable;
    }
    public void addNotificationStrategy(INotificationStrategy ns){
        this.notificationStrategies.add(ns);
    }
    public void update(){
        String notificationContent = notificationObservable.getNotificationContent();
        for(INotificationStrategy strategy : notificationStrategies){
            strategy.sendNotification(notificationContent);
        }
    }
}

public class NotificationSystem {
    
}
