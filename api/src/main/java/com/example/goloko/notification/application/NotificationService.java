package com.example.goloko.notification.application;

import com.example.goloko.exceptions.NotFoundException;
import com.example.goloko.notification.domain.Notification;
import com.example.goloko.notification.domain.NotificationRepository;
import com.example.goloko.notification.web.mapper.NotificationMapper;
import com.example.goloko.notification.web.request.CreateNotificationRequest;
import com.example.goloko.notification.web.response.CreateNotificationResponse;
import com.example.goloko.user.domain.User;
import com.example.goloko.user.domain.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationService {

    private final NotificationRepository repository;
    private final NotificationMapper mapper;
    private final UserRepository userRepository;

    public NotificationService(NotificationRepository repository, NotificationMapper mapper,
                               UserRepository userRepository){

        this.repository = repository;
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Transactional
    public CreateNotificationResponse create(CreateNotificationRequest request){

        User user = userRepository.findById(request.userId()).orElseThrow(()-> new NotFoundException("User not found!"));

        Notification notification = mapper.toEntity(request);
        notification.setUser(user);
        repository.save(notification);

        return mapper.toResponse(notification);

    }
}
