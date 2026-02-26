package org.example.tparchi26022026.exercice2.solid.d.problem;

public class OrderService {
    private EmailNotification emailService;
    private DatabaseRepository dbRepo;

    public OrderService() {
        this.emailService = new EmailNotification();
        this.dbRepo = new DatabaseRepository();
    }

    public void createOrder(String userId, String bookId) {
        dbRepo.save("order_" + userId, bookId);
        emailService.sendEmail(userId, "Order created successfully");
    }
}
