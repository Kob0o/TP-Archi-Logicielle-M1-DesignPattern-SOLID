package org.example.tparchi26022026.exercice1.factory;


public class FactoryPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Démonstration du Factory Pattern ===\n");

        // ===== APPROCHE A : Multiple Factory Classes =====
        System.out.println("--- Approche A : Multiple Factory Classes ---");
        
        EmailNotificationFactory emailFactory = new EmailNotificationFactory();
        NotificationService emailService = emailFactory.createNotification();
        emailService.sendNotification("user@example.com", "Votre livre est disponible !");
        
        SmsNotificationFactory smsFactory = new SmsNotificationFactory();
        NotificationService smsService = smsFactory.createNotification();
        smsService.sendNotification("+33612345678", "Rappel : retour de livre dans 3 jours");
        
        PushNotificationFactory pushFactory = new PushNotificationFactory();
        NotificationService pushService = pushFactory.createNotification();
        pushService.sendNotification("user123", "Nouvelle recommandation disponible");
        
        System.out.println();

        // ===== APPROCHE B : Simple Factory Pattern =====
        System.out.println("--- Approche B : Simple Factory Pattern ---");
        
        NotificationService email = NotificationFactory.createNotification(NotificationFactory.NotificationType.EMAIL);
        email.sendNotification("user@example.com", "Votre livre est disponible !");
        
        NotificationService sms = NotificationFactory.createNotification(NotificationFactory.NotificationType.SMS);
        sms.sendNotification("+33612345678", "Rappel : retour de livre dans 3 jours");
        
        NotificationService push = NotificationFactory.createNotification(NotificationFactory.NotificationType.PUSH);
        push.sendNotification("user123", "Nouvelle recommandation disponible");
        
        // Utilisation avec String
        NotificationService emailFromString = NotificationFactory.createNotification("EMAIL");
        emailFromString.sendNotification("admin@library.com", "Nouveau livre ajouté");
        
        System.out.println();
        System.out.println("=== Comparaison des approches ===");
        System.out.println("Approche A (Multiple Factories) :");
        System.out.println("  + Plus flexible pour des factories complexes");
        System.out.println("  + Chaque factory peut avoir sa propre logique");
        System.out.println("  - Plus de classes à maintenir");
        System.out.println();
        System.out.println("Approche B (Simple Factory) :");
        System.out.println("  + Plus simple et centralisé");
        System.out.println("  + Facile à étendre (ajouter un case dans le switch)");
        System.out.println("  - Peut devenir complexe avec beaucoup de types");
        System.out.println();
        System.out.println("Question : Quelle approche est plus flexible pour ajouter un nouveau type ?");
        System.out.println("Réponse : L'approche B (Simple Factory) est généralement plus flexible");
        System.out.println("         car il suffit d'ajouter un case dans le switch, sans créer");
        System.out.println("         de nouvelle classe Factory.");
    }
}
