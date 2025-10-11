package com.example.goloko.payment.application;

import com.example.goloko.client.domain.Client;
import com.example.goloko.client.domain.ClientRepository;
import com.example.goloko.event.domain.EventRepository;
import com.example.goloko.exceptions.NotFoundException;
import com.example.goloko.payment.domain.Payment;
import com.example.goloko.payment.domain.PaymentRepository;
import com.example.goloko.payment.web.mapper.PaymentMapper;
import com.example.goloko.payment.web.request.CreatePaymentRequest;
import com.example.goloko.payment.web.response.CreatePaymentResponse;
import com.example.goloko.subscription_plan.domain.SubscriptionPlan;
import com.example.goloko.subscription_plan.domain.SubscriptionPlanRepository;
import com.example.goloko.user.domain.User;
import com.example.goloko.user.domain.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {
    private final PaymentRepository repository;
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final SubscriptionPlanRepository subscriptionPlanRepository;
    private final PaymentMapper mapper;

    public PaymentService(PaymentRepository repository,UserRepository userRepository,
                          ClientRepository clientRepository,SubscriptionPlanRepository subscriptionPlanRepository,
                          PaymentMapper mapper){
        this.repository = repository;
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
        this.subscriptionPlanRepository = subscriptionPlanRepository;
        this.mapper = mapper;

    }
    @Transactional
    public CreatePaymentResponse create(CreatePaymentRequest request){

        User user = userRepository.findById(request.userId()).orElseThrow(()->new NotFoundException("User not found"));
        SubscriptionPlan subscriptionPlan = subscriptionPlanRepository.findById(request.subscriptionPlanId())
                .orElseThrow(()->new NotFoundException("Subscription plan not found"));

        Client client = clientRepository.findByUserId(user.getId()).orElseThrow(()-> new NotFoundException("Client does not exist"));

        Payment payment = mapper.toEntity(request);
        payment.setUser(user);
        payment.setSubscriptionPlan(subscriptionPlan);
        payment.setClient(client);

        repository.save(payment);

        return mapper.toResponse(payment);

    }
}
