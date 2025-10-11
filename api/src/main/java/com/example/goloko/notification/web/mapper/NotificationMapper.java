package com.example.goloko.notification.web.mapper;

import com.example.goloko.notification.domain.Notification;

import com.example.goloko.notification.web.request.CreateNotificationRequest;
import com.example.goloko.notification.web.response.CreateNotificationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    @Mapping(target = "user",ignore = true)
    Notification toEntity(CreateNotificationRequest cnr);

    @Mapping(source = "user.firstName",target = "firstName")
    @Mapping(source = "user.lastName",target = "lastName")
    CreateNotificationResponse toResponse(Notification notification);
}
