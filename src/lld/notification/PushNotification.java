package src.lld.notification;

public class PushNotification implements Notification{
    private String deviceId;
    private String message;

    public PushNotification(String deviceId, String message){
        this.deviceId = deviceId;
        this.message = message;
    }

    @Override
    public void send(NotificationSystem notificationSystem) {
        System.out.println("Sending Push Notification: '" + message + "' to device: " + deviceId);
    }
}
