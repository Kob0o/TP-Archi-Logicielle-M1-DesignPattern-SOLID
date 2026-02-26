package org.example.tparchi26022026.exercice1.factory;

public class EmailNotificationFactory {
    public NotificationService createNotification() {
        return new EmailNotificationService();
    }
}
