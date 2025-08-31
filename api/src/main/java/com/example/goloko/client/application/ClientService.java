package com.example.goloko.client.application;

import com.example.goloko.client.domain.Client;
import com.example.goloko.client.domain.ClientRepository;
import com.example.goloko.client.web.request.CreateClientRequest;
import com.example.goloko.exceptions.NotFoundException;
import com.example.goloko.subscriptionplan.domain.SubscriptionPlan;
import com.example.goloko.subscriptionplan.domain.SubscriptionPlanRepository;
import com.example.goloko.user.domain.User;
import com.example.goloko.user.domain.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
   private final ClientRepository clientRepository;
   private final UserRepository userRepository;
   private final SubscriptionPlanRepository subscriptionPlanRepository;

    public ClientService(ClientRepository clientRepository,UserRepository userRepository, SubscriptionPlanRepository subscriptionPlanRepository)
    {
        this.clientRepository = clientRepository;
        this.userRepository =userRepository;
        this.subscriptionPlanRepository = subscriptionPlanRepository;
    }
@Transactional
    public Client create(CreateClientRequest request)
    {
        User user = userRepository.findById(request.userId()).orElseThrow(() ->new NotFoundException("User not found"));
        SubscriptionPlan subscriptionPlan = subscriptionPlanRepository.findById(request.subscriptionPlanId())
                .orElseThrow(() -> new NotFoundException("Subscription plan not found"));

        Client client = new Client();
        client.setUser(user);
        client.setBusinessName(request.businessName());
        client.setSubscriptionPlan(subscriptionPlan);
        client.setVerificationText(request.verificationNotes());
        return clientRepository.save(client);
    }
}
