package org.example.tparchi26022026.exercice2.solid.d.solution;

public class SmsNotificationService implements NotificationService {
    @Override
    public void sendNotification(String user, String message) {
        System.out.println("SMS to " + user + ": " + message);
    }
}
