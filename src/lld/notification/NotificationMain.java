package src.lld.notification;

public class NotificationMain {

    public static void main(String[] args) {

        NotificationSystem sender = new NotificationSystem();
        PushNotification pushNotification = new PushNotification("device123", "Order Delivered");
        EmailNotification emailNotification = new EmailNotification("test1@gmail.com", "Your receipt for Transaction X");

        sender.send(pushNotification);
        sender.send(emailNotification);

    }
}
