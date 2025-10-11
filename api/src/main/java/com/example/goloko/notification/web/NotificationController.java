package com.example.goloko.notification.web;

import com.example.goloko.notification.application.NotificationService;
import com.example.goloko.notification.web.request.CreateNotificationRequest;
import com.example.goloko.notification.web.response.CreateNotificationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<CreateNotificationResponse> create(@RequestBody CreateNotificationRequest request){
        CreateNotificationResponse saved = service.create(request);

        return ResponseEntity.created(URI.create("/api/notifications"))
                .body(saved);
    }
}

