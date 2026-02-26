package org.example.tparchi26022026.exercice1.factory;


public class SmsNotificationFactory {
    public NotificationService createNotification() {
        return new SmsNotificationService();
    }
}
