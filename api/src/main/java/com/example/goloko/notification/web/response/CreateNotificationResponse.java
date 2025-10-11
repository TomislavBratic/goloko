package com.example.goloko.notification.web.response;

public record CreateNotificationResponse(
        String firstName,
        String lastName,
        String message,
        boolean isRead
) {
}
