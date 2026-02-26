package org.example.tparchi26022026.exercice4.apigateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class ApiGatewayController {

    private final RestTemplate restTemplate;
    
    @Value("${book.service.url:http://localhost:8081}")
    private String bookServiceUrl;
    
    @Value("${user.service.url:http://localhost:8082}")
    private String userServiceUrl;
    
    @Value("${loan.service.url:http://localhost:8083}")
    private String loanServiceUrl;
    
    @Value("${review.service.url:http://localhost:8084}")
    private String reviewServiceUrl;

    public ApiGatewayController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/books/**", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<?> forwardBooks(@RequestBody(required = false) Object body, 
                                          HttpMethod method,
                                          HttpServletRequest request) {
        String path = request.getRequestURI().substring("/api".length());
        return forwardRequest(bookServiceUrl + path, method, body);
    }

    @RequestMapping(value = "/users/**", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<?> forwardUsers(@RequestBody(required = false) Object body,
                                          HttpMethod method,
                                          HttpServletRequest request) {
        String path = request.getRequestURI().substring("/api".length());
        return forwardRequest(userServiceUrl + path, method, body);
    }

    @RequestMapping(value = "/loans/**", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<?> forwardLoans(@RequestBody(required = false) Object body,
                                         HttpMethod method,
                                         HttpServletRequest request) {
        String path = request.getRequestURI().substring("/api".length());
        return forwardRequest(loanServiceUrl + path, method, body);
    }

    @RequestMapping(value = "/reviews/**", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<?> forwardReviews(@RequestBody(required = false) Object body,
                                           HttpMethod method,
                                           HttpServletRequest request) {
        String path = request.getRequestURI().substring("/api".length());
        return forwardRequest(reviewServiceUrl + path, method, body);
    }

    private ResponseEntity<?> forwardRequest(String url, HttpMethod method, Object body) {
        try {
            HttpEntity<Object> entity = new HttpEntity<>(body);
            return restTemplate.exchange(url, method, entity, Object.class);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error forwarding request: " + e.getMessage());
        }
    }
}
