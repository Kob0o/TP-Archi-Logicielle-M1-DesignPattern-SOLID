package org.example.tparchi26022026.exercice1.factory;


public class PushNotificationFactory {
    public NotificationService createNotification() {
        return new PushNotificationService();
    }
}
