package com.example.goloko.notification.web.request;

public record CreateNotificationRequest(
        Long userId,
        String message,
        boolean isRead
) {
}
