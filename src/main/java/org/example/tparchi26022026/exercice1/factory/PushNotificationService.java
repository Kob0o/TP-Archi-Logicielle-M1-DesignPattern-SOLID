package org.example.tparchi26022026.exercice1.factory;


public class PushNotificationService implements NotificationService {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("🔔 Notification Push envoyée à " + recipient + ": " + message);
    }

    @Override
    public String getType() {
        return "PUSH";
    }
}
