package org.example.tparchi26022026.exercice4.reviewservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BookServiceClient {
    
    private final RestTemplate restTemplate;
    private final String bookServiceUrl;

    public BookServiceClient(RestTemplate restTemplate,
                           @Value("${book.service.url:http://localhost:8081}") String bookServiceUrl) {
        this.restTemplate = restTemplate;
        this.bookServiceUrl = bookServiceUrl;
    }

    public boolean bookExists(Long bookId) {
        try {
            ResponseEntity<Boolean> response = restTemplate.getForEntity(
                bookServiceUrl + "/api/books/" + bookId + "/exists",
                Boolean.class
            );
            return Boolean.TRUE.equals(response.getBody());
        } catch (Exception e) {
            return false;
        }
    }
}
