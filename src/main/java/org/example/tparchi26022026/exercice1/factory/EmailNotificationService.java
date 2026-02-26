package org.example.tparchi26022026.exercice1.factory;


public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("📧 Email envoyé à " + recipient + ": " + message);
    }

    @Override
    public String getType() {
        return "EMAIL";
    }
}
