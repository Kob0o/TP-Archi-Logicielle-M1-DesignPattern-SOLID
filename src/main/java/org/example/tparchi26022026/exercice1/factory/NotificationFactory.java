package org.example.tparchi26022026.exercice1.factory;


public class NotificationFactory {
    public enum NotificationType {
        EMAIL, SMS, PUSH
    }
    public static NotificationService createNotification(NotificationType type) {
        return switch (type) {
            case EMAIL -> new EmailNotificationService();
            case SMS -> new SmsNotificationService();
            case PUSH -> new PushNotificationService();
        };
    }


    public static NotificationService createNotification(String type) {
        try {
            NotificationType notificationType = NotificationType.valueOf(type.toUpperCase());
            return createNotification(notificationType);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Type de notification non supporté: " + type, e);
        }
    }
}
