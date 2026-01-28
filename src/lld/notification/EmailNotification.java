package src.lld.notification;

public class EmailNotification implements Notification{
    private String message;
    private String toEmail;

    public EmailNotification(String toEmail, String message){
        this.toEmail = toEmail;
        this.message = message;
    }

    @Override
    public void send(NotificationSystem notificationSystem) {
        System.out.println("Sending Email: '" + message + "' to email: " + toEmail);
    }
}
