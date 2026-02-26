package org.example.tparchi26022026.exercice2.solid.s.solution;

public class UserService {
    private final UserRepository userRepository;
    private final UserValidator userValidator;
    private final NotificationService notificationService;
    private final DatabaseService databaseService;

    public UserService(UserRepository userRepository, UserValidator userValidator,
                      NotificationService notificationService, DatabaseService databaseService) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
        this.notificationService = notificationService;
        this.databaseService = databaseService;
    }

    public void registerUser(String username, String email) {
        if (!userValidator.isValidUsername(username)) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (!userValidator.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email");
        }

        userRepository.addUser(username);
        databaseService.saveUser(username);
        notificationService.notifyUser(username, "Welcome to the library!");
    }
}
