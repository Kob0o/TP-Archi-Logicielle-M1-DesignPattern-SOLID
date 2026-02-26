package org.example.tparchi26022026.exercice2.solid.d.solution;

public class OrderService {
    private final NotificationService notificationService;
    private final DataRepository dataRepository;

    public OrderService(NotificationService notificationService, DataRepository dataRepository) {
        this.notificationService = notificationService;
        this.dataRepository = dataRepository;
    }

    public void createOrder(String userId, String bookId) {
        dataRepository.save("order_" + userId, bookId);
        notificationService.sendNotification(userId, "Order created successfully");
    }
}
