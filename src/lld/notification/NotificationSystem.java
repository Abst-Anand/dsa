package src.lld.notification;

public class NotificationSystem {

    public void send(Notification notification){
        notification.send(this);
    }

}
